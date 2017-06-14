package com.fxhibon.euler.problem1

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import com.typesafe.scalalogging.LazyLogging

/**
  * Created by fx on 14/06/2017.
  *
  * @see https://projecteuler.net/problem=1
  */
object Problem1 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  Source(0 to 999)
    .filter { e => (e % 3 == 0) || (e % 5 == 0) }
    .runFold(0)(_ + _)
    .map { res => logger.info(s"Sum of all the multiples of 3 or 5 below 1000 is $res") }
}
