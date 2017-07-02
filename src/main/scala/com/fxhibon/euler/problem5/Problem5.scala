package com.fxhibon.euler.problem5

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, Sink, Source}
import com.typesafe.scalalogging.LazyLogging

/**
  * Created by fx on 19/06/2017.
  *
  * @see https://projecteuler.net/problem=5
  */
object Problem5 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  val max = 20

  val range = 1 to max

  def ok(i: Int) = {
    range.forall(i % _ == 0)
  }

  Source(max + 1 to Int.MaxValue)
    .takeWhile(!ok(_))
    .watchTermination()(Keep.right)
    .runWith(Sink.last)
    .map(_ + 1)
    .map { res =>
      logger.info(s"Smallest evenly divisible by $range is $res")
    }
    .onComplete { _ =>
      system.terminate()
    }

}
