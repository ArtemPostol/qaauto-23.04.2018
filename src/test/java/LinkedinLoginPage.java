import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {


    @FindBy(xpath = "//input [@class='login-email' and contains(@type,'text')]")
    private WebElement loginField;

    @FindBy(xpath = "//input [@class='login-password' and contains(@type,'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input [@class='login submit-button' and contains(@type,'submit')]")
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public LinkedinHomePage login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
        }

    }
