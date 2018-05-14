import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://us.linkedin.com/");

        String signUpTitle = webDriver.getTitle();

       Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Login page title is wrong!");

       Assert.assertEquals(webDriver.getCurrentUrl(), "https://us.linkedin.com/",
                "URL is wrong!");

        WebElement inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        WebElement inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        WebElement clickSignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

        inputLoginField.sendKeys("postoltestgmailcom");
        inputPasswordField.sendKeys("q12345678");
        clickSignInButton.sendKeys(Keys.ENTER);

        sleep(5000);

        WebElement invalidEmailMessage = ((FirefoxDriver) webDriver).findElementByXPath("//span [text() ='Please enter a valid email address.']");
        Assert.assertTrue(invalidEmailMessage.isDisplayed(),"Error invalid email message is not displayed!" );

        webDriver.get("https://us.linkedin.com/");

        sleep(5000);

        inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        clickSignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

        inputLoginField.sendKeys("postoltest@gmail.com");
        inputPasswordField.sendKeys("qweasdzxc");
        clickSignInButton.sendKeys(Keys.ENTER);

        sleep(5000);

        WebElement invalidPasswordMessage = webDriver.findElement(By.xpath("//span [@class='error' and contains(@id,'session_password-login-error')]"));
        Assert.assertTrue(invalidPasswordMessage.isDisplayed(), "Error invalid password message is not displayed!");

        webDriver.get("https://us.linkedin.com/");

        sleep(5000);

        inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        clickSignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

        inputLoginField.sendKeys("ps");
        inputPasswordField.sendKeys("qweas");
        clickSignInButton.sendKeys(Keys.ENTER);

        sleep(5000);

        WebElement invalidEmailLength = webDriver.findElement(By.xpath("//span [text()='The text you provided is too short (the minimum length is 3 characters, your text contains 2 characters).']"));
        Assert.assertTrue(invalidEmailLength.isDisplayed(), "Error message about the length of the email input field is not displayed!");

        WebElement invalidPasswordLength = webDriver.findElement(By.xpath("//span [text() ='The password you provided must have at least 6 characters.' ]"));
        Assert.assertTrue(invalidPasswordLength.isDisplayed(), "Error message about the length of the password input field is not displayed!");

        webDriver.get("https://us.linkedin.com/");

        sleep(3000);

        inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        clickSignInButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

        inputLoginField.sendKeys("postoltest@gmail.com");
        inputPasswordField.sendKeys("q12345678");
        clickSignInButton.sendKeys(Keys.ENTER);

        Assert.assertTrue(clickSignInButton.isDisplayed(),
                "Sign In button is not Displayed");


        sleep(3000);

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title for authorized user is wrong!"  );

        String homePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(signUpTitle, homePageTitle, "Home page title is wrong!");



            }

}
