package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PastebinSearchResultPage {
    private WebDriver driver;

    public PastebinSearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String resultPageId(){
        return driver.getCurrentUrl().replace("https://pastebin.com", "");
    }
}
