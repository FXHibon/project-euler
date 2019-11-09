package com.fxhibon.euler.problem6

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import com.typesafe.scalalogging.LazyLogging

/**
 * Created by fx on 19/06/2017.
 *
 * @see https://projecteuler.net/problem=6
 */
object Problem6 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val executionContext = system.dispatcher

  val source = Source(1 to 100)

  val futureRes = for {
    sumOfSquares <- source.runFold(0)((prev, cur) => prev + (cur * cur))
    squaresOfSum <- source.runFold(0)(_ + _).map(sum => sum * sum)
  } yield {
    logger.info(s"sumOfSquares = $sumOfSquares")
    logger.info(s"squaresOfSum = $squaresOfSum")
    squaresOfSum - sumOfSquares
  }

  futureRes.map { res =>
    logger.info(s"The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum is $res")
  }.onComplete { _ =>
    system.terminate()
  }

}
