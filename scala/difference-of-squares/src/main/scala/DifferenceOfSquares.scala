import scala.math.pow
object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = {
    (0 to n).map(pow(_,2)).reduce(_ + _).toInt
  }

  def squareOfSum(n: Int): Int = {
    pow((0 to n).reduce(_ + _), 2).toInt
  }

  def differenceOfSquares(n: Int): Int = {
    squareOfSum(n) - sumOfSquares(n)
  }
}
