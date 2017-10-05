package com.fxhibon.euler.problem2

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{ Keep, Source }
import com.typesafe.scalalogging.LazyLogging

/**
 * Created by fx on 14/06/2017.
 *
 * @see https://projecteuler.net/problem=2
 */
object Problem2 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  private val max = 4000000
  Source.fromGraph(new FibonacciSource(max = max))
    .map(i => {
      logger.info(i.toString)
      i
    })
    .filter(i => (i % 2) == 0)
    .watchTermination()(Keep.right)
    .runFold(0)(_ + _)
    .map { res => logger.info(s"Sums of fibonacci < $max = $res") }
    .onComplete { _ =>
      system.terminate()
    }

}