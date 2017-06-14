package com.fxhibon.euler.problem2

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
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

  Source.fromGraph(new FibonacciSource(max = 4000000))
    .runFold(0)(_ + _)
    .map { res => logger.info(s"Sums of fibonacci < 4 000 000 = $res") }

}