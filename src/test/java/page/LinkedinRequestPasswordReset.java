package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordReset extends LinkedinBasePage {

    @FindBy(xpath = "//input [@name='userName' and contains(@id,'username')]")
    private WebElement userNameField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement submitButton;


    public LinkedinRequestPasswordReset(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }



    public  LinkedinCheckpointReset submitUserEmail(String email)  {
        gMailService.connect();
        userNameField.sendKeys(email);
        submitButton.click();
        return new LinkedinCheckpointReset(webDriver);



    }



    public boolean isPageLoaded() {
        return userNameField.isDisplayed();
    }
}
