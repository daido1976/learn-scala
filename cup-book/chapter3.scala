package chapter3

private def widthOfLength(s: String): Int = s.length.toString.length

def linesWithLength(lines: List[String]): List[String] = {
  val longestLine =
    lines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) yield {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    // TODO: Replace stripSuffix() with trimEnd().
    s"$padding ${line.length} | $line".stripSuffix(" ")
  }
}

// e.g. $ scala-cli cup-book/chapter3.scala -- cup-book/chapter3.scala
@main
def main(args: String*): Unit = {
  import scala.io.Source

  if (args.length < 1) {
    return Console.err.println("please enter filename")
  }

  val lines =
    Source.fromFile(args(0)).getLines.toList

  linesWithLength(lines).foreach(println)
}
