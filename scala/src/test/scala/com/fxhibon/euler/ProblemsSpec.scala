package com.fxhibon.euler

import com.fxhibon.euler.problem1.Problem1
import com.fxhibon.euler.problem2.Problem2
import org.scalatest._

class ProblemsSpec extends AsyncFlatSpec with Matchers {

  "Problem 1" should "find the sum of all the multiples of 3 or 5 below 1000" in {
    new Problem1(1000)
      .run()
      .map(_ shouldBe 233168)
  }

  "Problem 2" should "find the sum of the even-valued terms of the terms in the Fibonacci sequence whose values do not exceed four million" in {
    new Problem2(4000000)
      .run()
      .map(_ shouldBe 4613732)
  }
}
