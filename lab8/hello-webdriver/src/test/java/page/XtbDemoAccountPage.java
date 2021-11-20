package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static waits.ExpicitWaiter.waitForElementLocatedBy;

public class XtbDemoAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='xs-tab-header xs-tab-header-text']/parent::li")
    private List<WebElement> analisTab;
    @FindBy(xpath = "//*[@class='xs-slider-range-values-box']/span[2]")
    private WebElement valueOfMarketCapitalizationMax;
    @FindBy(xpath = "//div[@label='SCREENER.MARKET_CAPITALISATION']//input[@name ='stepperInput']")
    private WebElement areaValueOfMarketCapitalizationMax;
    @FindBy(xpath = "//div[@label='SCREENER.DIVIDED_YIELD']//span[@class='xs-slider-range-min']")
    private WebElement valueOfDevidentAbilityMin;
    @FindBy(xpath = "//div[@label='SCREENER.DIVIDED_YIELD']//div[@class='xs-slider-range-min-stepper']//input")
    private WebElement areaValueOfDevidentAbilityMin;
    @FindBy(xpath = "//span[@class ='slick-column-name']/parent::div")
    private List<WebElement> sortValueByDevidence;

    public XtbDemoAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XtbDemoAccountPage pressTabMarketAnalysis(){
        waitForElementLocatedBy(driver, By.xpath("//*[@class='xs-tab-header xs-tab-header-text']/parent::li"));
        analisTab.get(3).click();
        return this;
    }

    public XtbDemoAccountPage inputValueOfMarketCapitalizationMax(String text){
        waitForElementLocatedBy(driver, By.xpath("//*[@class='xs-slider-range-values-box']/span[2]"));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.
                        xpath("//*[@class='xs-slider-range-values-box']/span[2]")));
        valueOfMarketCapitalizationMax.click();
        areaValueOfMarketCapitalizationMax.clear();
        areaValueOfMarketCapitalizationMax.sendKeys(text);
        areaValueOfMarketCapitalizationMax.sendKeys(Keys.ENTER);
        return this;
    }

    public XtbDemoAccountPage inputValueOfDevidentAbilityMin(String text){
        waitForElementLocatedBy(driver,By.xpath("//div[@label='SCREENER.DIVIDED_YIELD']//span[@class='xs-slider-range-min']"));
        valueOfDevidentAbilityMin.click();
        areaValueOfDevidentAbilityMin.clear();
        areaValueOfDevidentAbilityMin.sendKeys(text);
        areaValueOfDevidentAbilityMin.sendKeys(Keys.ENTER);
        return this;
    }

    public XtbDemoAccountPage sortValueByDevidendYield(){
        waitForElementLocatedBy(driver, By.xpath("//span[@class ='slick-column-name']/parent::div"));
        sortValueByDevidence.get(6).click();
        return this;
    }

    public float getFirstDevidendYiledAfterSort() {
        waitForElementLocatedBy(driver, By.xpath("//div[@class='slick-cell l6 r6 slickgrid-cell-align-center']"));
        WebElement sortedDevidendYield = driver.findElement(By.
                xpath("//div[@class='slick-cell l6 r6 slickgrid-cell-align-center']"));
        return Float.parseFloat(sortedDevidendYield.getText().replace("%", ""));
    }
}
