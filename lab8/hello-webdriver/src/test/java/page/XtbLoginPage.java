package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static waits.ExpicitWaiter.waitForElementLocatedBy;

public class XtbLoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@name='xslogin']")
    private WebElement enterLogInArea;
    @FindBy(xpath = "//*[@name='xspass']")
    private WebElement enterPasswordArea;
    @FindBy(xpath = "//*[@class='xs-btn xs-btn-ok-login ng-scope']")
    private WebElement LogInButton;

    public XtbLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XtbLoginPage enterLogIn(String text){
        waitForElementLocatedBy(driver,By.xpath("//*[@name='xslogin']"));
        enterLogInArea.sendKeys(text);
        return this;
    }

    public XtbLoginPage enterPassword(String text){
        waitForElementLocatedBy(driver,By.xpath("//*[@name='xspass']"));
        enterPasswordArea.sendKeys(text);
        return this;
    }

    public XtbDemoAccountPage logInUnderDemoAccount(){
        waitForElementLocatedBy(driver,By.xpath("//*[@class='xs-btn xs-btn-ok-login ng-scope']"));
        LogInButton.click();
        return new XtbDemoAccountPage(driver);
    }

}
