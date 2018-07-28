object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    (0 until limit).filter(x => factors.map(y => x % y).contains(0)).sum
  }
}

