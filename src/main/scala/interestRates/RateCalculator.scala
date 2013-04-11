package interestRates

case class InterestRate(lowerBound: Int, upperBound: Int, rate: BigDecimal) {
  def appliesTo(amount: BigDecimal) = amount >= lowerBound && amount < upperBound
}

object RateCalculator {

  val rates: List[InterestRate] = List(
    InterestRate(0, 1000, 0.01),
    InterestRate(1000, 5000, 0.02),
    InterestRate(5000, Int.MaxValue, 0.03)
  )

  def interest(balance: BigDecimal): BigDecimal = {
    rates.find(_.appliesTo(balance)) match {
      case Some(InterestRate(_, _, rate)) => to2DP(balance * rate)
      case _ => throw new IllegalArgumentException(s"Balance: $balance is not valid")
    }
  }

  private def to2DP(amount: BigDecimal) = amount setScale(2, BigDecimal.RoundingMode.HALF_UP)
}
