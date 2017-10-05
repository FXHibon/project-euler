package com.fxhibon.euler.problem10

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{ Keep, Source }
import com.fxhibon.euler.problem7.PrimeSource
import com.typesafe.scalalogging.LazyLogging

/**
 * Created by fx on 13/07/2017.
 *
 * @see https://projecteuler.net/problem=10
 */
object Problem10 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  val n = 2000000L

  Source.fromGraph(new PrimeSource())
    .takeWhile(_ < n)
    .watchTermination()(Keep.right)
    .runFold(0L)(_ + _)
    .map { res => logger.info(s"The sum of all the primes below two million is $res") }
    .onComplete { _ =>
      system.terminate()
    }

}
