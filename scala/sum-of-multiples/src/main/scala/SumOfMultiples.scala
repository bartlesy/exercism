object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    (0 until limit).filter(x => x % 3 == 0 | x % 5 == 0).reduce(_ + _)
  }
}

