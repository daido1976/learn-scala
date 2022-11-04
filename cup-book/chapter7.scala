package chapter7

// NOTE: Optimal values depend on the output display size.
val SectionSize = 4
val Capacity = 30

private def makeRowSeq(row: Int, end: Int): IndexedSeq[String] =
  for (column <- 1 to end) yield {
    val product = (row * column).toString()
    val padding = " " * (SectionSize - product.length())
    padding + product
  }

private def makeRow(row: Int, end: Int): String = makeRowSeq(row, end).mkString

def multiTable(end: Int): String = {
  // TODO: Return Either to prevent an Exception.
  require(end <= Capacity)

  val tableSeq = for (row <- 1 to end) yield makeRow(row, end)
  tableSeq.mkString("\n")
}

@main
def main(args: String*): Unit = {
  val end = args match {
    case Nil => 10
    case h +: _ =>
      h.toIntOption match
        case Some(n) => n
        case None    => return Console.err.println("please input number!")
    case _ => return Console.err.println("unrecognized argument!")
  }
  println(multiTable(end))
}
