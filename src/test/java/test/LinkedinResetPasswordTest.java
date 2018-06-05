package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinCheckpointReset;
import page.LinkedinRequestPasswordReset;
import page.LinkedinSetNewPasswordPage;
import page.LinkedinSuccessfulPaswordResetPage;

import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest extends LinkedinBaseTest{



    @Test
    public void successfulResetPasswordTest() throws InterruptedException {


        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "URL is wrong!");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Log In Page is not Displayed");


        LinkedinRequestPasswordReset linkedinRequestPasswordReset = linkedinLoginPage.clickForgotPassword();

        Assert.assertTrue(linkedinRequestPasswordReset.isPageLoaded(),
                "Request Password Reset page is not displayed! ");

        sleep(3000);

        String userEmail = "postoltest@gmail.com";
        String newUserPassword ="Qwer3267";

        LinkedinCheckpointReset linkedinCheckpointReset = linkedinRequestPasswordReset.submitUserEmail(userEmail);

        sleep(3000);

        Assert.assertTrue(linkedinCheckpointReset.isPageLoaded(),
                "Checkpoint Reset page is not displayed! ");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinCheckpointReset.navigateToLinkFromEmail();

       Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "Set New Password Page page is not displayed! ");

       LinkedinSuccessfulPaswordResetPage linkedinSuccessfulPaswordResetPage = linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);

       linkedinSuccessfulPaswordResetPage.waitUntilElementIsClickable();

        Assert.assertTrue(linkedinSuccessfulPaswordResetPage.isPageLoaded(),
                "Set New Password Page page is not displayed! ");

   }

}

