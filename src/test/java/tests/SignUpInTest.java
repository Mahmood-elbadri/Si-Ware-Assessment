package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.SignUpPage;

import java.time.Duration;

public class SignUpInTest extends TestBase{
    SignUpPage sign;
    SignInPage signIn;
    @Test(dataProvider = "credentials",dataProviderClass = TestBase.class)
    public void signUp(String name,String pass){
        sign = new SignUpPage(driver);
        signIn = new SignInPage(driver);
        sign.signUp(name,pass);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        signIn.logInToBlaze(name,pass);
        Assert.assertTrue(signIn.isLogged());
    }


}
