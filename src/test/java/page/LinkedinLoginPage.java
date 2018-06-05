package page;

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

    @FindBy (xpath = "//a [@class='link-forgot-password']")
    private WebElement forgotPasswordButton;

    @FindBy (xpath = "//div [@class='legal-nav']")
    private  WebElement loginPageFooter;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean  isPageLoaded() {
        return signInButton.isDisplayed();
    }

    public LinkedinRequestPasswordReset clickForgotPassword () {
        forgotPasswordButton.click();
        return new LinkedinRequestPasswordReset(webDriver);
    }

    public <T> T login(String email,String password ) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")){
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentTitle().contains("login-submit")) {
            return (T) new LinkedinLoginSubmitPage(webDriver);
        }
        else {
            return (T) this;
        }
    }


    public WebElement waitUntilElementIsClickable() {
        return super.waitUntilElementIsClickable(loginPageFooter, 10);
    }
}