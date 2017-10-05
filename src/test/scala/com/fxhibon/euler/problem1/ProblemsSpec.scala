package com.fxhibon.euler

import com.fxhibon.euler.problem1.Problem1
import org.scalatest._

class ProblemsSpec extends AsyncFlatSpec with Matchers {

  "Broblem 1" should "find the sum of all the multiples of 3 or 5 below 1000" in {
    new Problem1()
      .run()
      .map { sum => assert(sum == 233168) }
  }
}
