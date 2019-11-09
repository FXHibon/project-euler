package com.fxhibon.euler.problem1

import akka.stream.scaladsl.{ Keep, Source }
import domain.Problem

/**
 * Created by fx on 14/06/2017.
 *
 * @see https://projecteuler.net/problem=1
 */
class Problem1(max: Int) extends Problem[Int] {
  override val stream = Source(0 until max)
    .filter { e => (e % 3 == 0) || (e % 5 == 0) }
    .reduce(_ + _)
}
