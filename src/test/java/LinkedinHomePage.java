import org.openqa.selenium.WebDriver;


public class LinkedinHomePage {
    WebDriver webDriver;

    public LinkedinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrenUrl() {
        return  webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }
}
