package com.fxhibon.euler.problem4

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by fx on 17/06/2017.
  *
  * @see https://projecteuler.net/problem=4
  */
object Problem4 extends App with LazyLogging {

  val (min, max) = (100, 999)

  def isPalyndrom(i: Int): Boolean = {
    i.toString match {
      case even if even.length % 2 == 0 =>
        even.substring(0, even.length / 2) == even.substring(even.length / 2).reverse
      case odd =>
        odd.substring(0, (odd.length - 1) / 2) == odd.substring((odd.length + 1) / 2).reverse
    }
  }


  for (x <- (min to max).reverse) {
    for (y <- (min to max).reverse) {
      if (isPalyndrom(x * y)) {
        logger.info(s"Largest palyndrom is ${x * y} = $x x $y")
        sys.exit()
      }
    }
  }

}
