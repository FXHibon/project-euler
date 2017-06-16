package com.fxhibon.euler.problem3

import akka.Done
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}
import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable
import scala.concurrent.Future
import scala.util.Success

/**
  * Created by francois-xavierhibon on 15/06/2017.
  *
  * @see https://projecteuler.net/problem=3
  */
object Problem3 extends App with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = materializer.executionContext

  val n = 600851475143L

  Source.fromGraph(new PrimeSource(147))
    .watchTermination()(Keep.right)
    .runFold(mutable.Queue.empty[Long])(_ :+ _)
    .map { primes =>
      logger.info(s"${primes.length} prime numbers generated. Applying algorithm ...")
      primes.fold
    }
    .onComplete { _ =>
      system.terminate()
    }


}
