package chapter6

// chapter6,12
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numerator = n / g
  val denominator = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = new Rational(
    numerator * that.denominator + that.numerator * denominator,
    denominator * that.denominator
  )

  def +(i: Int): Rational = new Rational(
    numerator + i * denominator,
    denominator
  )

  def -(that: Rational): Rational = new Rational(
    numerator * that.denominator - that.numerator * denominator,
    denominator * that.denominator
  )

  def -(i: Int): Rational = new Rational(
    numerator - i * denominator,
    denominator
  )

  def *(that: Rational): Rational = new Rational(
    numerator * that.numerator,
    denominator * that.denominator
  )

  def *(i: Int): Rational = new Rational(
    numerator * i,
    denominator
  )

  def /(that: Rational): Rational = new Rational(
    numerator * that.denominator,
    denominator * that.numerator
  )

  def /(i: Int): Rational = new Rational(
    numerator,
    denominator * i
  )

  override def toString(): String = s"$numerator/$denominator"

  // Derive the greatest common divisor with Euclidean Algorithm.
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def compare(that: Rational): Int =
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
}

@main
def main(args: String*): Unit = {
  implicit def intToRational(x: Int): Rational = new Rational(x)
  println(2 * new Rational(2, 3))
}
