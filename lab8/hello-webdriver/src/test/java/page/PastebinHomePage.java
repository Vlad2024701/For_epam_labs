package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement searchTextArea;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement inputPasteExperation;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement selectPasteExperation10Min;
    @FindBy(xpath = "//*[@id=\"postform-name\"]")
    private WebElement searchInputTextTitle;
    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button")
    private WebElement buttonCreateNewPaste;

    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage addSomeTextForNewPaste(String term){
        searchTextArea.sendKeys(term);
        return this;
    }

    public PastebinHomePage changePasteExperationTo10Min(){
        (new Actions(driver)).moveToElement(buttonCreateNewPaste).perform(); //Scroll for element
        inputPasteExperation.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='10 Minutes']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                selectPasteExperation10Min); //Scroll for down of the page
        selectPasteExperation10Min.click();
        return this;
    }

    public PastebinHomePage addSomeTitle(String term){
        searchInputTextTitle.sendKeys(term);
        return this;
    }

    public PastebinSearchResultPage createNewPaste(){
        buttonCreateNewPaste.click();
        return new PastebinSearchResultPage(driver);
    }
}
