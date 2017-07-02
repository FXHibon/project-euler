package com.fxhibon.euler.problem7

import akka.stream.{Attributes, Outlet, SourceShape}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}

/**
  * Created by fx on 02/07/2017.
  * Emit prime number while downstream ask for it
  */
class PrimeSource extends GraphStage[SourceShape[Long]] {

  val out = Outlet[Long]("Source.out")
  override val shape = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes) = {
    var current = 2L
    new GraphStageLogic(shape) {

      setHandler(out, new OutHandler {
        override def onPull(): Unit = {
          push(out, current)
          do {
            current += 1
          } while ((2L to (current - 1)).exists(current % _ == 0))
        }
      })
    }
  }
}
