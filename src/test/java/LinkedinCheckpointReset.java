import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinCheckpointReset extends LinkedinBasePage {

    @FindBy(xpath = "//button [@class='resend__link' and contains(@id,'resend-url')]")
    private WebElement resendLinkButton;

    public LinkedinCheckpointReset(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return resendLinkButton.isDisplayed();
    }
}
