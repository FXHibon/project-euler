package com.fxhibon.euler.problem3

import com.typesafe.scalalogging.LazyLogging
import scala.collection.mutable

/**
 * Created by francois-xavierhibon on 15/06/2017.
 *
 * @see https://projecteuler.net/problem=3
 */
object Problem3 extends App with LazyLogging {

  val n = 600851475143L
  var current = n
  val primesFactors = mutable.ListBuffer.empty[Long]
  var i = 2
  while (i <= current) {
    while (current % i == 0) {
      primesFactors += i
      current /= i
    }
    i += 1
  }
  logger.info(s"$n = ${primesFactors.mkString(" x ")}")
  logger.info(s"Max is ${primesFactors.last}")
}
