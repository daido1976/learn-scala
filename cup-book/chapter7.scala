package chapter7

private def makeRowSeq(row: Int, end: Int): IndexedSeq[String] =
  for (column <- 1 to end) yield {
    val product = (row * column).toString()
    val padding = " " * (4 - product.length())
    padding + product
  }

private def makeRow(row: Int, end: Int): String = makeRowSeq(row, end).mkString

def multiTable(end: Int) = {
  val tableSeq = for (row <- 1 to end) yield makeRow(row, end)
  tableSeq.mkString("\n")
}

@main
def main(args: String*): Unit = {
  val end = args match {
    case Nil    => 10
    case h +: _ => h.toIntOption.getOrElse(10)
    case _      => return Console.err.println("unrecognized argument!")
  }
  println(multiTable(end))
}
