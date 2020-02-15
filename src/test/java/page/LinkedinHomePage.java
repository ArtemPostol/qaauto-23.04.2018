package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**Object class
 * Linkedin HomePage Object class
 */
public class LinkedinHomePage extends LinkedinBasePage {


    @FindBy (xpath = "//input [@role='combobox']")
    private WebElement searchInput;

    @FindBy (xpath = "//div [@class='neptune-grid three-column ghost-animate-in']")
    private  WebElement contentInfo;

    @FindBy (xpath = "//input [@type= 'text' and contains(@role,'combobox')]")
    private  WebElement searchField;

    /**  Linkedin Home Page constructor
     * @param webDriver
     */
    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return searchInput.isDisplayed();
    }



    public WebElement waitUntilElementIsClickable() {
        return super.waitUntilElementIsClickable(contentInfo, 60);
    }


    /** Method for input search term
     * @param searchTerm - string
     * @return - new webDriver
     */
    public LinkedinSearchResults search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResults(webDriver);

    }

}
