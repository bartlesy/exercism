import scala.collection.mutable.ListBuffer

object BeerSong {

  def cycle[T](seq: Seq[T]): Stream[T] = {
    assert(seq.nonEmpty, "Cannot cycle over an empty sequence!")
    Stream.continually(seq).flatten
  }

  def get_lines(cnt: Int): String = {
    val next_cnt = cnt - 1
    var curStr = new StringBuilder
    if (cnt > 0) {
      curStr ++=  s"$cnt bottle${if (cnt > 1) "s" else ""} of beer on the wall, $cnt bottle${if (cnt > 1) "s" else ""} of beer.\n"
      if (next_cnt > 0) {
        curStr ++= s"Take one down and pass it around, ${next_cnt} bottle${if (next_cnt > 1) "s" else ""} of beer on the wall.\n"
      } else {
        curStr ++= s"Take it down and pass it around, no more bottles of beer on the wall.\n"
      }
    } else {
      curStr ++= "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    }
    curStr.toString
  }

  def recite(n: Int, k: Int): String = {
    val iters = (n to 0 by -1).toList ::: (99 until n by -1).toList
    var outArr = new ListBuffer[String]()
    for (cnt <- cycle(iters) take k) {
      outArr += get_lines(cnt)
    }
    outArr.mkString("\n")
  }
}

