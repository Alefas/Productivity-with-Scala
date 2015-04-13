"Magnet pattern"

sealed trait TwiceMagnet {
  type R
  def apply(): R
}

//noinspection NoReturnTypeForImplicitDef
object TwiceMagnet {
  implicit def intMagnet(x: Int) =
    new TwiceMagnet {
      override def apply(): R = 2 * x
      override type R = Int
    }

  //todo: list magnet
}

def twice(magnet: TwiceMagnet): magnet.R = magnet()
val x: Int = twice(1)