package domain

import akka.{ Done, NotUsed }
import akka.stream.scaladsl.{ Keep, Sink, Source }
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future

/**
 * abstract problem to avoid boiler plate
 *
 * @tparam T
 */
abstract class Problem[T] extends LazyLogging with StreamImplicits {

  protected val stream: Source[T, NotUsed]

  def run(): Future[T] = stream
    .watchTermination()(Keep.right)
    .runWith(Sink.head)
}
