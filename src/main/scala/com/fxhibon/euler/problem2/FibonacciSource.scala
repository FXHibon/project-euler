package com.fxhibon.euler.problem2

import akka.stream.{ Attributes, Outlet, SourceShape }
import akka.stream.stage.{ GraphStage, GraphStageLogic, OutHandler }

import scala.collection.mutable

/**
 * Construct a source which emit fibonacci values, until [[limit]] is reached if defined
 *
 * @param limit Max count to reach before source stop emit data
 * @param max   Stop the source as soon as it reaches [[max]] value
 */
class FibonacciSource(limit: Int = Int.MaxValue, max: Int = Int.MaxValue) extends GraphStage[SourceShape[Long]] {

  private val out = Outlet[Long]("FibonacciSource.out")
  override val shape = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {

    new GraphStageLogic(shape) {

      private var count = 0
      private var prevs = (0L, 1L)

      setHandler(out, new OutHandler {
        override def onPull(): Unit = {
          prevs = (prevs._2, prevs._1 + prevs._2)
          count += 1
          if (count >= limit || prevs._2 >= max) {
            completeStage()
          } else {
            push(out, prevs._2)
          }
        }
      })
    }

  }
}
