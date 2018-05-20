import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {
    private WebDriver webDriver;

    private WebElement errorMessage;
    private WebElement errorEmailMessage;
    private WebElement errorPasswordMessage;

    public  LinkedinLoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }



    public String getTextErrorMessage() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
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

    public String getCurrenUrl() {
        return  webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }


 }

