package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.XtbDemoAccountPage;
import page.XtbHomePage;
import page.XtbLoginPage;

import java.util.ArrayList;

public class WebDriverSeleniumTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Test-case market analis")
    public void testCase() throws InterruptedException {
        XtbLoginPage chooseHowToLogInSwitchToSecondWindowHandle = new XtbHomePage(driver)
                .openPage()
                .pressLogInButton()
                .pressHowToLogInButton();
        ArrayList<String> getBrowserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(getBrowserTabs.get(1));
        XtbDemoAccountPage expectedResultsOfMarketAnalys = chooseHowToLogInSwitchToSecondWindowHandle
                .enterLogIn("simakovich_vlad228@mail.ru")
                .enterPassword("5212160Vladislavsimakovich2876746")
                .logInUnderDemoAccount()
                .pressTabMarketAnalysis()
                .inputValueOfMarketCapitalizationMax("10000000000")
                .inputValueOfDevidentAbilityMin("2.49")
                .sortValueByDevidendYield();
        float expectedMinDevidendValueSortResult = expectedResultsOfMarketAnalys.getFirstDevidendYiledAfterSort();
        float expectedMaxDevidentValueSortResult = expectedResultsOfMarketAnalys
                .sortValueByDevidendYield()
                .getFirstDevidendYiledAfterSort();

        Assert.assertTrue(expectedMaxDevidentValueSortResult >= 2.49 && expectedMinDevidendValueSortResult >= 2.49);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public static void fail(String failMessage) {
        throw new AssertionError(failMessage);
    }
}
