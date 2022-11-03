import scala.io.Source

def widthOfLength(s: String): Int = s.length.toString.length

@main
def main(args: String*): Unit = {
  if (args.length < 1) {
    return Console.err.println("please enter filename")
  }

  val lines = Source.fromFile(args(0)).getLines.toList
  val longestLine =
    lines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(s"$padding ${line.length} | $line")
  }
}
