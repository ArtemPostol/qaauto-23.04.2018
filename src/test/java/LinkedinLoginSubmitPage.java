import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy (xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    @FindBy (xpath = "//span [@class='error' and contains(@id,'session_password-login-error')]")
    private WebElement errorPasswordMessage;

    @FindBy (xpath = "//span [@class='error' and contains(@id,'session_password-login-error')]" )
    private WebElement emailField;

    public  LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public String getTextErrorMessage() {
        return errorMessage.getText();
    }


   public String getTextPasswordErrorMessage() {
        return errorPasswordMessage.getText();
   }


    public boolean isPageLoaded(){
        return emailField.isDisplayed();
    }

 }

