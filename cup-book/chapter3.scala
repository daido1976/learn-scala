package chapter3

def widthOfLength(s: String): Int = s.length.toString.length

def linesWithLength(lines: List[String]): List[String] = {
  val longestLine =
    lines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) yield {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    s"$padding ${line.length} | $line"
  }
}
