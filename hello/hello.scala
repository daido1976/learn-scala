def helloMessage(names: Seq[String]) = {
  names match
    case Nil =>
      "Hello!"
    case names =>
      names.mkString("Hello ", ", ", "!")
}

@main
def main(args: String*): Unit = {
  println(helloMessage(args))
}
