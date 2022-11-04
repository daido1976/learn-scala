package chapter9

// Reduce code duplication.
object FileMatcher {
  // TODO: Inject from outside.
  private def filesHere = (new java.io.File(".")).listFiles()

  private def filesMatching(mathcer: String => Boolean) = {
    for {
      file <- filesHere
      if mathcer(file.getName)
    } yield file
  }

  // eq. def filesEnding(query: String) = filesMatching(x => x.endsWith(query))
  def filesEnding(query: String) = filesMatching(_.endsWith(query))
  def filesContaining(query: String) = filesMatching(_.contains(query))
  def filesRegex(query: String) = filesMatching(_.matches(query))
}

// Simplify client code.
// NOTE: See Test Codes for usage.
object ListSearcher {
  // eq. def containsNeg(nums: List[Int]) = nums.exists(x => x < 0)
  def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
  def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
}

// Use loan pattern with currying.
import java.io._

/** Usage: `withPrintWriter(f) { writer => writer.println("some text") }` */
def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
// another curried syntax (like JS).
def withPrintWriter2(file: File) = { (op: PrintWriter => Unit) =>
  {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}

@main
def main(args: String*): Unit = {
  FileMatcher.filesEnding(".json").map(_.getName).foreach(println)

  withPrintWriter(new File("sandbox.txt")) { writer =>
    writer.println("some text")
  }
}
