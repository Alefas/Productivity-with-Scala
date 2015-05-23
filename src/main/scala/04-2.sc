"Parboiled"

import org.parboiled2._
case class ComplexNumber(re: Double, im: Double)
class ComplexParser(val input: ParserInput) extends Parser {
  def WS = rule { zeroOrMore(" ") }
  def Sign = rule { capture("+" | "-") ~> { sign =>
    if (sign == "-") -1
    else +1
  }}
  def Sign_? = rule { Sign.? ~> { _.getOrElse(-1) } }
  def Double = rule { capture(CharPredicate.Digit.+ ~
    ("." ~ CharPredicate.Digit.+).?) ~> { _.toDouble } }

  def Complex = rule {
    //TODO:
  }
}
new ComplexParser("-123+123i").Complex.run()