package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Base Page Object class
 */
public abstract class LinkedinBasePage {

    protected WebDriver webDriver;

    protected static GMailService gMailService = new GMailService();
    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public LinkedinBasePage (WebDriver webDriver){
        this.webDriver=webDriver;
    }

    /** Method get current url
     * @return - webDriver
     */
    public String getCurrentUrl(){
        return  webDriver.getCurrentUrl();
    }

    /**Method get current title
     * @return - webDriver
     */
    public String getCurrentTitle(){
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded ();

    /** Method wait until elemet stay clickable
     * @param webElement - return webElement
     * @param timeOutInSeconds - time for wait
     * @return
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /** Method wait until elemet stay visible
     * @param webElement - return webElement
     * @param timeOutInSeconds - time for wait
     * @return
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }


}
