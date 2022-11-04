//> using lib "org.scalameta::munit::0.7.27"
package chapter9

class MyTests extends munit.FunSuite {
  test("ListSearcher") {
    val ls = ListSearcher
    assertEquals(ls.containsNeg(List(1, 2, 3)), false)
    assertEquals(ls.containsNeg(List(1, -2, 3)), true)
    assertEquals(ls.containsOdd(List(1, 2, 3)), true)
    assertEquals(ls.containsOdd(List(2, 4, 6)), false)
  }
}
