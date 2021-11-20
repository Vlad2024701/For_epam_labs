package dataProvider;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public static Object[][] summarizeDataProvider() {
        return new Object[][]{{5, 10, 15}, {50, 100, 150}, {41, 22, 63}};
    }

    @DataProvider
    public static Object[][] substractionDataProvider() {
        return new Object[][]{{50, 10, 40}, {100, 50, 50}, {41, 22, 19}};
    }

    @DataProvider
    public static Object[][] multiplyDataProvider() {
        return new Object[][]{{50, 10, 500}, {4, 8, 32}, {41, 22, 902}};
    }

    @DataProvider
    public static Object[][] divisionDataProvider() {
        return new Object[][]{{50, 10, 5}, {8, 4, 2}, {88, 22, 4}};
    }

    @DataProvider
    public static Object[][] divisionByZeroDataProvider() {
        return new Object[][]{{100, 0}};
    }
}
