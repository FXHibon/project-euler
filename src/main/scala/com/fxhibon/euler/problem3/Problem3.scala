package com.fxhibon.euler.problem3

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, Source}
import com.typesafe.scalalogging.LazyLogging

/**
  * Created by francois-xavierhibon on 15/06/2017.
  *
  * @see https://projecteuler.net/problem=3
  */
class Problem3 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  val n = 600851475143L

  Source.fromGraph(new PrimeSource(n))
    .watchTermination()(Keep.right)
  .


}
