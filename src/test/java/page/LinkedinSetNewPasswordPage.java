package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage{

    @FindBy(xpath = "//label [@class='form__label']")
    private WebElement formLable;

    @FindBy(xpath = "//input [@name='newPassword']")
    private WebElement inputNewPassword;

    @FindBy(xpath = "//input [@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button [@class='form__submit' ]")
    private WebElement submitButton;

    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    @Override
     public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }

    /**Method submit new password
     * @param newUserPassword
     * @return - webDriver
     */
      public LinkedinSuccessfulPaswordResetPage submitNewPassword(String newUserPassword) {
        inputNewPassword.sendKeys(newUserPassword);
        confirmPassword.sendKeys(newUserPassword);
        submitButton.click();
        return new LinkedinSuccessfulPaswordResetPage(webDriver);
    }

}
