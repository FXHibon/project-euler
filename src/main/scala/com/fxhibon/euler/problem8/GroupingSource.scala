package com.fxhibon.euler.problem8

import akka.stream.{ Attributes, Outlet, SourceShape }
import akka.stream.stage.{ GraphStage, GraphStageLogic, OutHandler }

/**
 * Created by fx on 06/07/2017.
 */
class GroupingSource(rawData: String, group: Int) extends GraphStage[SourceShape[String]] {

  val out = Outlet[String]("Source.out")
  override val shape: SourceShape[String] = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {
    new GraphStageLogic(shape) {
      var cursor = 0
      setHandler(out, new OutHandler {
        override def onPull(): Unit = {
          if ((cursor + group) <= rawData.length) {
            push(out, rawData.substring(cursor, group + cursor))
            cursor += 1
          } else {
            completeStage()
          }
        }
      })
    }
  }
}
