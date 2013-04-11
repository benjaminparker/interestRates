package interestRates

import org.specs2.mutable.Specification

class RateCalculatorSpec extends Specification {

  "Rate Calculator" should {

    "give zero interest for zero balance" in {
      RateCalculator.interest(0) mustEqual 0
    }

    "give 1% of balance to 2DP for a balance greater than 0 and less than 1000" in {
      RateCalculator.interest(150.2) mustEqual BigDecimal(1.50)
    }

    "give 2% of balance for a balance greater than or equal to 1000 and less than 5000" in {
      RateCalculator.interest(2500) mustEqual BigDecimal(50)
    }

    "give 3% of balance for a balance greater than or equal to 5000" in {
      RateCalculator.interest(5000) mustEqual BigDecimal(150)
    }

    "fail for a negative balance" in {
      RateCalculator.interest(-150) must throwA[IllegalArgumentException](message = "Balance: -150 is not valid")
    }
  }

}
