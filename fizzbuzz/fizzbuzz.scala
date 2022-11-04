package fizzbuzz

@main
def main(): Unit = {
  for (i <- 1 to 100) {
    val x = (i % 3, i % 5) match
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
      case _      => i
    println(x)
  }
}
