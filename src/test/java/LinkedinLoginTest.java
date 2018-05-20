import org.openqa.selenium.WebDriver;
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
    public  void wrongPasswordLoginTest() throws InterruptedException {

     LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
     LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(this.webDriver);

     Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
             "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");
     Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
             "https://us.linkedin.com/",
             "URL is wrong!");
     Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
             "Sign In button is not Displayed");

     linkedinLoginPage.login( "postoltest@gmail.com", "12345678");

     sleep(3000);

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrenUrl(),
             "https://www.linkedin.com/uas/login-submit",
             "URL is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
             "Sign In to LinkedIn",
             "Title is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextErrorMessage(),
             "There were one or more errors in your submission. Please correct the marked fields below.",
             "Wrong error message text displayed!");

    }

    @Test
    public  void wrongEmailLoginTest () throws InterruptedException {
     LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
     LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(this.webDriver);

     Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
             "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");
     Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
             "https://us.linkedin.com/",
             "URL is wrong!");
     Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
             "Sign In button is not Displayed");

     linkedinLoginPage.login( "postoltestgmail.com", "q12345678");

     sleep(3000);

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrenUrl(),
             "https://www.linkedin.com/uas/login-submit",
             "URL is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
             "Sign In to LinkedIn",
             "Title is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextEmailErrorMessage(),
             "Please enter a valid email address.",
             "Wrong error message text displayed!");

    }

    @Test
    public void wrongLengthCharacters () throws InterruptedException {
     LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
     LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(this.webDriver);

     Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
             "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");
     Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
             "https://us.linkedin.com/",
             "URL is wrong!");
     Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
             "Sign In button is not Displayed");

     linkedinLoginPage.login( "p", "q");

     sleep(3000);

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrenUrl(),
             "https://www.linkedin.com/uas/login-submit",
             "URL is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
             "Sign In to LinkedIn",
             "Log In to LinkedIn");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextEmailErrorMessage(),
             "The text you provided is too short (the minimum length is 3 characters, your text contains 1 character).",
             "Wrong error message text displayed!");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextPasswordErrorMessage(),
             "The password you provided must have at least 6 characters.",
             "Wrong error message text displayed!");
    }

    @Test
    public void notRecognizedEmail () throws InterruptedException {
     LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
     LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(this.webDriver);

     Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
             "LinkedIn: Log In or Sign Up",
             "Login page title is wrong!");
     Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
             "https://us.linkedin.com/",
             "URL is wrong!");
     Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
             "Sign In button is not Displayed");

     linkedinLoginPage.login( "qwasdx@taphear.com", "q12345678");

     sleep(3000);

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrenUrl(),
             "https://www.linkedin.com/uas/login-submit",
             "URL is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
             "Sign In to LinkedIn",
             "Log In to LinkedIn");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextEmailErrorMessage(),
             "Hmm, we don't recognize that email. Please try again.",
             "Wrong error message text displayed!");

    }


    @AfterMethod
    public void after() {
    webDriver.close();
  }

}
