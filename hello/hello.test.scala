//> using lib "org.scalameta::munit::0.7.27"

class MyTests extends munit.FunSuite {
  test("helloMessage") {
    assertEquals(helloMessage(Nil), "Hello!")
    assertEquals(helloMessage(List("taro", "shota")), "Hello taro, shota!")
  }
}
