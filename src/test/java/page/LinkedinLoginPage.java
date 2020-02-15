package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {


    @FindBy(xpath = "//input [@id='username' and contains(@type,'text')]")
    private WebElement loginField;

    @FindBy(xpath = "//input [@id='password' and contains(@type,'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn__primary--large from__button--floating']")
    private WebElement signInButton;

    @FindBy(xpath = "//a [@class='nav__button-secondary']")
    private WebElement loginButton;

    @FindBy (xpath = "//a [@class='link-forgot-password']")
    private WebElement forgotPasswordButton;

    @FindBy (xpath = "//div [@class='legal-nav']")
    private  WebElement loginPageFooter;

    @FindBy (xpath = "//nav [@class='nav']")
    private  WebElement loginPageHeader;

    @FindBy (xpath = "//input [@type= 'submit' and contains(@class,'btn-primary')]")
    private  WebElement submitButton;


    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean  isPageLoaded() {
        return loginPageHeader.isDisplayed();
    }

    /** Method click on link forgot password
     * @return - webDriver
     */
    public LinkedinRequestPasswordReset clickForgotPassword () {
        forgotPasswordButton.click();
        return new LinkedinRequestPasswordReset(webDriver);
    }

    /** Login Method
     * @param email - current e-mail
     * @param password - current password
     * @param <T> - data type for return page
     * @return - webDriver
     */
    public <T> T login(String email,String password ) {
        loginButton.click();
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")){
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(webDriver);
        }
        else {
            return (T) this;
        }
    }


    public WebElement waitUntilElementIsClickable()
    {
        return super.waitUntilElementIsClickable(submitButton, 10);
    }
}
