"Magnet pattern"

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.implicitConversions

sealed trait TwiceMagnet {
  type R
  def apply(): R
}
//noinspection NoReturnTypeForImplicitDef
object TwiceMagnet {
  implicit def intMagnet(x: Future[Int]) =
    new TwiceMagnet {
      override def apply(): R = x.map(2 * _)
      override type R = Future[Int]
    }

  //todo: string?

}

def twice(magnet: TwiceMagnet): magnet.R = magnet()
val x = twice(Future.successful(2))