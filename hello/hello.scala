package hello

def helloMessage(names: Seq[String]) = {
  names match
    case Nil =>
      "Hello!"
    case names =>
      names.mkString("Hello ", ", ", "!")
}

// e.g. $ scala-cli hello -- taro shota
@main
def main(args: String*): Unit = {
  println(helloMessage(args))
}
