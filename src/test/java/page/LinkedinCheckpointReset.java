package page;

import org.apache.commons.lang3.StringUtils;
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

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed();
    }

    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "postoltest@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(
                messageSubject, messageTo, messageFrom, 30);

        String resetPasswordLink = StringUtils.substringBetween(
                message,
                "To change your LinkedIn password, click <a href=\"",
                "\" style").replace("&amp;","&");

        webDriver.get(resetPasswordLink);
        return new LinkedinSetNewPasswordPage(webDriver);


    }




}
