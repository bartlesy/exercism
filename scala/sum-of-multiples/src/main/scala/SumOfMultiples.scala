object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    (0 to limit - 1).filter(x => x % 3 == 0 | x % 5 == 0).reduce(_ + _)
  }
}

