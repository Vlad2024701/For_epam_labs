package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//*[@name='xslogin']")));
        enterLogInArea.sendKeys(text);
        return this;
    }

    public XtbLoginPage enterPassword(String text){
        enterPasswordArea.sendKeys(text);
        return this;
    }

    public XtbDemoAccountPage logInUnderDemoAccount(){
        LogInButton.click();
        return new XtbDemoAccountPage(driver);
    }

}
