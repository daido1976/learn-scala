//> using lib "org.scalameta::munit::0.7.27"
package chapter3

class MyTests extends munit.FunSuite {
  test("example") {
    import scala.io.Source
    val lines =
      Source.fromFile("../cup-book/fixture").getLines.toList

    linesWithLength(lines).foreach(println)

    // e.g. following output
    //
    //  22 | import scala.io.Source
    //   0 |
    //  60 | def widthOfLength(s: String): Int = s.length.toString.length
    //   0 |
    //   5 | @main
    //  33 | def main(args: String*): Unit = {
    //  24 |   if (args.length < 1) {
    //  55 |     return Console.err.println("please enter filename")
    //   3 |   }
    //   0 |
    //  54 |   val lines = Source.fromFile(args(0)).getLines.toList
    //  19 |   val longestLine =
    //  69 |     lines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
    //  43 |   val maxWidth = widthOfLength(longestLine)
    //   0 |
    //  23 |   for (line <- lines) {
    //  50 |     val numSpaces = maxWidth - widthOfLength(line)
    //  33 |     val padding = " " * numSpaces
    //  47 |     println(s"$padding ${line.length} | $line")
    //   3 |   }
    //   1 | }
  }
}
