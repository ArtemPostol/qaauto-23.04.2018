import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    private WebElement errorMessage;
    private WebElement errorPasswordMessage;
    private WebElement emailField;

    public  LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getTextErrorMessage() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        return errorMessage.getText();
    }


   public String getTextPasswordErrorMessage() {
       errorPasswordMessage = webDriver.findElement(By.xpath("//span [@class='error' and contains(@id,'session_password-login-error')]"));
       return errorPasswordMessage.getText();
   }


    public boolean isPageLoaded(){
        emailField = webDriver.findElement(By.id("session_key-login"));
        return emailField.isDisplayed();
    }



 }

