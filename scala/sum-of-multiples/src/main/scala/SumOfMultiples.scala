object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    (0 until limit).filter(x => factors.exists(y => x % y == 0)).sum
  }

  def sum22(factors: Set[Int], limit: Int) = {
    factors.flatMap(factor => factor until limit by factor).sum
  }
}

