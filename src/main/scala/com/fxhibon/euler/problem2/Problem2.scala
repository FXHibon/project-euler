package com.fxhibon.euler.problem2

import akka.stream.scaladsl.{Keep, Source}
import domain.Problem

/**
  * Created by fx on 14/06/2017.
  *
  * @see https://projecteuler.net/problem=2
  */
class Problem2(max: Int) extends Problem[Long] {
  override val stream = Source
    .fromGraph(new FibonacciSource(max = max))
    .filter(i => (i % 2) == 0)
    .reduce(_ + _)
}