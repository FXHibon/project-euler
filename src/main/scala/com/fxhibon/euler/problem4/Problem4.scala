package com.fxhibon.euler.problem4

import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable

/**
  * Created by fx on 17/06/2017.
  *
  * @see https://projecteuler.net/problem=4
  */
object Problem4 extends App with LazyLogging {

  val (min, max) = (100, 999)

  def isPalyndrom(i: Int): Boolean = i.toString == i.toString.reverse

  case class Palyndrom(op1: Int, op2: Int) {
    val res: Int = op1 * op2
  }

  object Palyndrom {
    implicit val ordering: Ordering[Palyndrom] = (x: Palyndrom, y: Palyndrom) => x.res - y.res
  }

  val pals = mutable.ListBuffer.empty[Palyndrom]
  for (x <- min to max) {
    for (y <- min to max) {
      if (isPalyndrom(x * y)) {
        pals += Palyndrom(x, y)
      }
    }
  }

  val res = pals.max

  logger.info(s"Largest palyndrom is ${res.op1} x ${res.op2} = ${res.res}")


}
