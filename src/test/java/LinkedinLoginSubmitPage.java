import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {
    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
    }
    private WebElement errorMessage;
    private WebElement errorEmailMessage;
    private WebElement errorPasswordMessage;
    private WebElement emailField;

    public  LinkedinLoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
           }

    public String getTextErrorMessage() {
                           return errorMessage.getText();
    }

    public String getTextEmailErrorMessage() {
        errorEmailMessage = webDriver.findElement(By.xpath("//span [@class='error' and contains(@id,'session_key-login-error')]"));
                          return errorEmailMessage.getText();
    }

    public String getTextPasswordErrorMessage() {
       errorPasswordMessage = webDriver.findElement(By.xpath("//span [@class='error' and contains(@id,'session_password-login-error')]"));
                return errorPasswordMessage.getText();
    }

    public boolean isPageLoaded(){
        emailField = webDriver.findElement(By.id("session_key-login"));
        return emailField.isDisplayed();
    }

    public String getCurrentUrl() {
        return  webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }


 }

