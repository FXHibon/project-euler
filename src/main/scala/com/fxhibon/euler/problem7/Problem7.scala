package com.fxhibon.euler.problem7

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{ Keep, Sink, Source }
import com.typesafe.scalalogging.LazyLogging

/**
 * Created by fx on 02/07/2017.
 *
 * @see https://projecteuler.net/problem=7
 */
object Problem7 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  val n = 10001

  Source.fromGraph(new PrimeSource())
    .take(n)
    .runWith(Sink.last)
    .map { res =>
      logger.info(s"$n-st prime number is $res")
    }
    .onComplete { _ =>
      system.terminate()
    }
}
