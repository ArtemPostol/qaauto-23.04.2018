package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends LinkedinBasePage {


    @FindBy (xpath = "//input [@role='combobox']")
    private WebElement searchInput;

    @FindBy (xpath = "//div [@role='contentinfo']")
    private  WebElement contentInfo;

    @FindBy (xpath = "//input [@type= 'text' and contains(@role,'combobox')]")
    private  WebElement searchField;

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



    public LinkedinSearchResults search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResults(webDriver);

    }

}