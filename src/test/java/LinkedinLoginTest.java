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
        webDriver.get("https://www.linkedin.com/");


//     Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");

       Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong!");

       Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "URL is wrong!");



        WebElement inputLoginField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        inputLoginField.sendKeys("artempostol@gmail.com");

        WebElement inputPasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        inputPasswordField.sendKeys("Traktor23");

        WebElement clickLoginButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));
        clickLoginButton.sendKeys(Keys.ENTER);

        Assert.assertTrue(clickLoginButton.isDisplayed(),
                "Login button is not Displayed");


        sleep(3000);

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title for authorized user is wrong!"  );


            }

}
