import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends LinkedinBasePage {


    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//input [@role='combobox']")
    private WebElement searchInput;

    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }
}
