import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
 public  WebDriver webDriver;


 @BeforeMethod
 public void before() {
  webDriver = new FirefoxDriver();
  webDriver.get("https://us.linkedin.com/");
 }

    @DataProvider
    public Object[][] validLoginData() {
        return new Object[][]{
                { "postoltest@gmail.com", "q12345678" },
                { "POSTOLTEST@GMAIL.COM", "q12345678" },
        };
    }

     @Test (dataProvider = "validLoginData")
     public void successfulLoginTest(String email, String password) throws InterruptedException {
  LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);
  LinkedinHomePage linkedinHomePage = new LinkedinHomePage (webDriver);

  Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
          "LinkedIn: Log In or Sign Up",
          "Login page title is wrong!");
  Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
          "Sign In button is not Displayed");

  linkedinLoginPage.login( email, password);

  sleep(3000);


  Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
          "https://www.linkedin.com/feed/",
          "Home page is wrong");
  Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
          "Home page Title is wrong");
 }

    @DataProvider
    public Object[][] invalidLoginData() {
        return new Object[][]{
                { "postoltest@gmail.com", "12345678" },
                { "postoltest@gmail.com", "Q12345678" },
                { "postoltestgmail.com", "q12345678" },
                { "postoltest@gmailcom", "q12345678" },
                { "postoltest@gmailcom", "q" },
                { "p", "q" },
        };
    }

    @Test (dataProvider = "invalidLoginData")
    public  void negativeReturnedToLoginSubmitTest(String email, String password) throws InterruptedException {

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

     linkedinLoginPage.login( email, password);

     sleep(3000);


     Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login-Submit Page is not loaded");

    Assert.assertEquals(linkedinLoginSubmitPage.getTextErrorMessage(),
             "There were one or more errors in your submission. Please correct the marked fields below.",
             "Wrong error message text displayed!");

    }

    @DataProvider
    public Object[][] emptyLoginFieldData() {
        return new Object[][]{
                { "", "" },
                { "", "q" },
                { "q", "" },
        };
    }

    @Test (dataProvider = "emptyLoginFieldData")
    public  void negativeStayAtLoginPageTest (String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(this.webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong!");
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "URL is wrong!");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login( email, password);


        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "Login page URL is wrong!");

    }

    @DataProvider
    public Object[][] wrongPasswordLengthData() {
        return new Object[][]{
                { "postoltest@gmail.com", "q" },
                { "postoltest@gmail.com", "q1" },
                { "postoltest@gmail.com", "q12" },
                { "postoltest@gmail.com", "q123" },
                { "postoltest@gmail.com", "q1234" },

        };
    }

    @Test (dataProvider = "wrongPasswordLengthData")
    public void wrongPasswordLengthTest (String email, String password) throws InterruptedException {
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

     linkedinLoginPage.login( email, password);

     sleep(3000);

     Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
             "https://www.linkedin.com/uas/login-submit",
             "URL is wrong!");

     Assert.assertEquals(linkedinLoginSubmitPage.getTextPasswordErrorMessage(),
             "The password you provided must have at least 6 characters.",
             "Wrong error message text displayed!");
   }

    @AfterMethod
    public void after() {
    webDriver.close();
  }

}
