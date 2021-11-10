package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XtbHomePage {

    private WebDriver driver;
    private static String HOMEPAGE_URL = "https://www.xtb.com/int";

    @FindBy(xpath = "//*[@class='js-login-aa']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//*[@class = 'btn btn-block btn-shadow btn-green js-login-xs-5-aa']")
    private WebElement buttonChooseHowToLogIn;

    public XtbHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public XtbHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public XtbHomePage pressLogInButton(){
        buttonLogin.click();
        return this;
    }

    public XtbLoginPage pressHowToLogInButton(){
        buttonChooseHowToLogIn.click();
        return new XtbLoginPage(driver);
    }
}
