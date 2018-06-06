package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfulPaswordResetPage extends LinkedinBasePage {

    @FindBy(xpath = "//button [@class='form__cancel' ]")
    private WebElement goToHomePageButton;

    @FindBy(xpath = "//div [@class='footer__base']")
    private WebElement footerBase;

    public LinkedinSuccessfulPaswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return goToHomePageButton.isDisplayed();
    }

    public WebElement waitUntilElementIsClickable() {
        return super.waitUntilElementIsClickable(goToHomePageButton, 20);
    }
}