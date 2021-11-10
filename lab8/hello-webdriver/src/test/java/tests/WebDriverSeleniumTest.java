package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinHomePage;
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

    @Test(description = "Test which create New Paste one pastebin.com with some details")
    public void commonSearchPageResult() throws InterruptedException {
        String expectedSearchResult = new PastebinHomePage(driver)
                .openPage()
                .addSomeTextForNewPaste("Hello from WebDriver")
                .changePasteExperationTo10Min()
                .addSomeTitle("helloweb")
                .createNewPaste()
                .resultPageId();

        Assert.assertNotNull(expectedSearchResult);
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
        Thread.sleep(5000);
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
