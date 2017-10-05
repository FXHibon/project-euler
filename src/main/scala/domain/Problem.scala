package domain

import akka.Done
import akka.stream.scaladsl.{ Sink, Source }
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future

/**
 * abstract problem to avoid boiler plate
 * @tparam T
 */
abstract class Problem[T] extends LazyLogging with StreamImplicits {

  protected val stream: Source[T, Future[Done]]

  def run(): Future[T] = stream.runWith(Sink.head)
}
