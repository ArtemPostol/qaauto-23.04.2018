import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement loginField;
    private WebElement passwordField;
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        loginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        passwordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        signInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));
    }

    public void login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.sendKeys(Keys.ENTER);
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
        }

    }
