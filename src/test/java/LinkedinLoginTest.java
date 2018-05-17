import com.sun.istack.internal.NotNull;
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
 public  WebDriver webDriver;

 @BeforeMethod
 public void before() {
  webDriver = new FirefoxDriver();
  webDriver.get("https://us.linkedin.com/");
 }

 @Test
 public void successfulLoginTest() throws InterruptedException {
  LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);

  Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
          "LinkedIn: Log In or Sign Up",
          "Login page title is wrong!");

  Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
          "Sign In button is not Displayed");
  linkedinLoginPage.login( "postoltest@gmail.com", "q12345678");

  sleep(3000);

  LinkedinHomePage linkedinHomePage = new LinkedinHomePage (webDriver);
  Assert.assertEquals(linkedinHomePage.getCurrenUrl(),
          "https://www.linkedin.com/feed/",
          "Home page is wrong");

  Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
          "Home page Title is wrong");
 }



    @Test
    public  void negativeLoginTest() throws InterruptedException {

     Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");

     Assert.assertEquals(webDriver.getCurrentUrl(), "https://us.linkedin.com/",
             "URL is wrong!");

     LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
     Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
             "Sign In button is not Displayed");
     linkedinLoginPage.login( "postoltest@gmail.com", "1");


     sleep(3000);

     String currentPageUrl = webDriver.getCurrentUrl();
     String currentPageTitle =webDriver.getTitle();

     Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "URL is wrong!");

     Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn", "Title is wrong!");

     WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

     Assert.assertEquals(errorMessage.getText(),
             "There were one or more errors in your submission. Please correct the marked fields below.",
             "Wrong error message text displayed!" );

    }

    @AfterMethod
    public void after() {
    webDriver.close();
  }

}
