package com.fxhibon.euler.problem2

import akka.stream.{Attributes, Outlet, SourceShape}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}

import scala.collection.mutable

/**
  * Construct a source which emit fibonacci values, until [[limit]] is reached if defined
  *
  * @param limit Max count to reach before source stop emit data
  * @param max   Stop the source as soon as it reaches [[max]] value
  */
class FibonacciSource(limit: Int = Int.MaxValue, max: Int = Int.MaxValue) extends GraphStage[SourceShape[Int]] {

  private val out = Outlet[Int]("FibonacciSource.out")
  override val shape = SourceShape(out)
  private val buffer = mutable.Queue.empty[Int]

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {
    new GraphStageLogic(shape) {

      setHandler(out, new OutHandler {
        override def onPull(): Unit = if (buffer.nonEmpty) push(out, buffer.dequeue())
      })
      preStart()
      private var count = 0
      private var prevs = (1, 1)
      while (count < limit && prevs._2 < max) {
        count += 1
        if (isAvailable(out)) {
          push(out, prevs._2)
        } else {
          buffer.enqueue(prevs._2)
        }
        prevs = (prevs._2, prevs._1 + prevs._2)
      }
      completeStage()
    }
  }
}
