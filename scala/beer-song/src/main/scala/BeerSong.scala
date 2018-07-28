import scala.collection.mutable.ListBuffer

object BeerSong {

  def cycle[T](seq: Seq[T]): Stream[T] = {
    assert(seq.nonEmpty, "Cannot cycle over an empty sequence!")
    Stream.continually(seq).flatten
  }

  def get_lines(cnt: Int): String = {
    val next_cnt = cnt - 1
    var cur_str = new StringBuilder
    if (cnt > 0) {
      cur_str ++=  s"$cnt bottles of beer on the wall, $cnt bottles of beer.\nTake one down and pass it around, "
      if (next_cnt > 0) {
        cur_str ++= s"${cnt - 1} bottles of beer on the wall\n"
      } else {
        cur_str ++= s"no more bottes of beer on the wall.\n"
      }
    } else {
      cur_str ++= "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    }
    cur_str.toString
  }

  def recite(n: Int, k: Int): String = {
    val iters = (n to 0 by -1).toList ::: (99 until n by -1).toList
    var out_arr = new ListBuffer[String]()
    for (cnt <- cycle(iters) take k) {
      out_arr += get_lines(cnt)
    }
    out_arr.mkString("\n")
  }
}

