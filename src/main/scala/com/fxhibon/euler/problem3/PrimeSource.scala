package com.fxhibon.euler.problem3

import akka.stream.{Attributes, Outlet, SourceShape}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}
import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by francois-xavierhibon on 16/06/2017.
  *
  * Construct a source that emits prime numbers
  *
  * @param limit
  */
class PrimeSource(limit: Long = Long.MaxValue) extends GraphStage[SourceShape[Long]] {

  private val out = Outlet[Long]("PrimeSource.out")
  override val shape = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {
    new GraphStageLogic(shape) with LazyLogging {
      var count = 0
      var prevs = mutable.ListBuffer(2L)
      setHandler(out, new OutHandler {

        override def onPull(): Unit = {
          if (count >= limit) {
            completeStage()
          } else {
            count += 1
            var candidate = prevs.last + 1
            var prime = false
            while (!prime) {
              // if one of prevs elems can divide candidate, then it's not prime and it should be inc
              if (prevs.exists(candidate % _ == 0)) {
                candidate += 1
              } else {
                prime = true
                prevs += candidate
              }
            }
            push(out, prevs.last)
          }
        }
      })
    }
  }

}
