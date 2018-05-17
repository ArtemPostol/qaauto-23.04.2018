import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LinkedinLoginPage {
    private  WebDriver webDriver;



    private  WebElement LoginField;
    private WebElement PasswordField;
    private WebElement SignInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        LoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        PasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        SignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));
    }

    public void login(String email, String password) {
        LoginField.sendKeys(email);
        PasswordField.sendKeys(password);
        SignInButton.sendKeys(Keys.ENTER);
    }

    public boolean isSignInButtonDisplayed() {
        return SignInButton.isDisplayed();
        }

    public String getCurrenUrl(){
        return  webDriver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return webDriver.getTitle();
    }
    }
