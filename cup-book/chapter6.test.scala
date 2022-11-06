//> using lib "org.scalameta::munit::0.7.27"
package chapter6

class MyTests extends munit.FunSuite {
  test("Rational for chapter6") {
    val x = new Rational(2, 3)
    val y = new Rational(1, 2)
    assertEquals((x.toString(), y.toString()), ("2/3", "1/2"))
    assertEquals((x + y).toString(), "7/6")
    assertEquals((x + 2).toString(), "8/3")
    assertEquals((x - y).toString(), "1/6")
    assertEquals((x - 2).toString(), "-4/3")
    assertEquals((x * y).toString(), "1/3")
    assertEquals((x * 2).toString(), "4/3")
    assertEquals((x / y).toString(), "4/3")
    assertEquals((x / 2).toString(), "1/3")
  }

  test("Rational for chapter12") {
    val x = new Rational(2, 3)
    val y = new Rational(1, 2)
    assertEquals((x.toString(), y.toString()), ("2/3", "1/2"))
    assertEquals((x > y), true)
    assertEquals((x < y), false)
  }
}
