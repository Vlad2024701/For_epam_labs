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

public class XtbDemoAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[text()='Анализ рынка']/parent::li")
    private WebElement TabMarketAnalysis;
    @FindBy(xpath = "//*[@class='xs-slider-range-values-box']/span[2]")
    private WebElement ValueOfMarketCapitalizationMax;
    @FindBy(xpath = "//div[@label='SCREENER.MARKET_CAPITALISATION']//input[@name ='stepperInput']")
    private WebElement areaValueOfMarketCapitalizationMax;
    @FindBy(xpath = "//div[@label='SCREENER.DIVIDED_YIELD']//span[@class='xs-slider-range-min']")
    private WebElement ValueOfDevidentAbilityMin;
    @FindBy(xpath = "//div[@label='SCREENER.DIVIDED_YIELD']//div[@class='xs-slider-range-min-stepper']//input")
    private WebElement areaValueOfDevidentAbilityMin;
    @FindBy(xpath = "//span[text()='ДИВИДЕНДНАЯ ДОХОДНОСТЬ']/parent::div")
    private WebElement sortValueByDevidence;

    public XtbDemoAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XtbDemoAccountPage pressTabMarketAnalysis(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//*[text()='Анализ рынка']/parent::li")));
        TabMarketAnalysis.click();
        return this;
    }

    public XtbDemoAccountPage inputValueOfMarketCapitalizationMax(String text){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//*[@class='xs-slider-range-values-box']/span[2]")));
        ValueOfMarketCapitalizationMax.click();
        areaValueOfMarketCapitalizationMax.clear();
        areaValueOfMarketCapitalizationMax.sendKeys(text);
        areaValueOfMarketCapitalizationMax.sendKeys(Keys.ENTER);
        return this;
    }

    public XtbDemoAccountPage inputValueOfDevidentAbilityMin(String text){
        ValueOfDevidentAbilityMin.click();
        areaValueOfDevidentAbilityMin.clear();
        areaValueOfDevidentAbilityMin.sendKeys(text);
        areaValueOfDevidentAbilityMin.sendKeys(Keys.ENTER);
        return this;
    }

    public XtbDemoAccountPage sortValueByDevidendYield(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//span[text()='ДИВИДЕНДНАЯ ДОХОДНОСТЬ']/parent::div")));
        sortValueByDevidence.click();
        return this;
    }

    public float getFirstDevidendYiledAfterSort() {
        WebElement sortedDevidendYield = driver.findElement(By.
                xpath("//div[@class='slick-cell l6 r6 slickgrid-cell-align-center']"));
        float devidendYieldValue = Float.parseFloat(sortedDevidendYield.getText().replace("%", ""));
        return devidendYieldValue;
    }
}
