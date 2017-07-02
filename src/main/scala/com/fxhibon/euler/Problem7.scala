package com.fxhibon.euler

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
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

}
