import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
 WebDriver webDriver;

 @BeforeMethod
 public void before() {
  webDriver = new FirefoxDriver();
  webDriver.get("https://us.linkedin.com/");
 }

 @Test
 public void successfulLoginTest() throws InterruptedException {

  String signUpTitle = webDriver.getTitle();

  Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up",
          "Login page title is wrong!");

  Assert.assertEquals(webDriver.getCurrentUrl(), "https://us.linkedin.com/",
          "URL is wrong!");



  LinkedinLoginPage linkedinLoginPage  = new LinkedinLoginPage();
  linkedinLoginPage.login( "postoltest@gmail.com", "q12345678");

/*  Assert.assertTrue(clickSignInButton.isDisplayed(), // -заернуть в класс linkedinLoginPage
          "Sign In button is not Displayed");
*/

  sleep(3000);

  Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title for authorized user is wrong!");

  String homePageTitle = webDriver.getTitle();

  Assert.assertNotEquals(signUpTitle, homePageTitle, "Home page title is wrong!");


 }



    @Test
    public  void negativeLoginTest() throws InterruptedException {



     String signUpTitle = webDriver.getTitle();

     Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");

     Assert.assertEquals(webDriver.getCurrentUrl(), "https://us.linkedin.com/",
             "URL is wrong!");

     WebElement inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
     WebElement inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
     WebElement clickSignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

     inputLoginField.sendKeys("postoltest@gmail.com");
     inputPasswordField.sendKeys("1");
     clickSignInButton.sendKeys(Keys.ENTER);

     sleep(3000);

     String currentPageUrl = webDriver.getCurrentUrl();
     String currentPageTitle =webDriver.getTitle();

     Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "URL is wrong!");

     Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn", "Title is wrong!");

     WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

     Assert.assertEquals(errorMessage.getText(),
             "There were one or more errors in your submission. Please correct the marked fields below.",
             "Wrong error message text displayed!" );

     webDriver.close();
 }

    @AfterMethod
    public void after() {
    webDriver.close();
  }

}
