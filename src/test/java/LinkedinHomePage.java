import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends LinkedinBasePage {


    @FindBy (xpath = "//input [@role='combobox']")
    private WebElement searchInput;

    @FindBy (xpath = "//div [@role='contentinfo']")
    private  WebElement contentInfo;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return searchInput.isDisplayed();
    }



    public WebElement waitUntilElementIsClickable() {
        return super.waitUntilElementIsClickable(contentInfo, 60);
    }
}
