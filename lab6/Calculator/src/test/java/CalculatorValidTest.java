import dataProvider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorValidTest {

    @Test(dataProvider = "summarizeDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void validInputValuesForSummarize(float firstTerm, float secondTerm, float expectedSum){
        Assert.assertEquals(Calculator.summarize(firstTerm, secondTerm), expectedSum);
    }

    @Test(dataProvider = "substractionDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void validInputValuesForSubstraction(float minuend, float subtrahend, float expectedDifference){
        Assert.assertEquals(Calculator.substraction(minuend, subtrahend), expectedDifference);
    }

    @Test(dataProvider = "multiplyDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void validInputValuesForMultiply(float firstMultiplier, float secondMultiplier, float expectedProduct){
        Assert.assertEquals(Calculator.multiply(firstMultiplier, secondMultiplier), expectedProduct);
    }

    @Test(dataProvider = "divisionDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void validInputValuesForDivision(int dividend, int divisor, int expectedRatio){
        Assert.assertEquals(Calculator.division(dividend, divisor), expectedRatio);
    }

    @Test(dataProvider = "divisionByZeroDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void validInputValuesForDivision(int dividend, int divisor){
        Assert.expectThrows(ArithmeticException.class, () -> Calculator.division(dividend, divisor));
    }
}
