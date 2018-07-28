object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    if (factors.size == 0) return 0

    val outList = (0 until limit).filter(x => factors.map(y => x % y).min == 0)

    if (outList.length > 0) outList.reduce(_ + _) else 0
  }
}

