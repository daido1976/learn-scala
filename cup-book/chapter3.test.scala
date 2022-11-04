//> using lib "org.scalameta::munit::0.7.27"
package chapter3

class MyTests extends munit.FunSuite {
  test("linesWithLength") {
    val from = List(
      "foo",
      "aaaaaaaaaa",
      "",
      "barbaz"
    )
    val to = List(
      "  3 | foo",
      " 10 | aaaaaaaaaa",
      "  0 |",
      "  6 | barbaz"
    )
    assertEquals(linesWithLength(from), to)
  }
}
