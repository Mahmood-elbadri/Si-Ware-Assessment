package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    private final WebDriver driver;
    private final By signUpBtn= By.xpath( "//a[@id='signin2']");
    private final By userNameTxtBox = By.xpath ("//input[@id='sign-username']");
    private final By passTxtBox = By.xpath ("//input[@id='sign-password']");
    private final By finishSignUpBtn = By.xpath ("//button[@onclick='register()']");
    public SignUpPage(WebDriver driver) {

        this.driver = driver;
    }
    public void signUp(String name,String pass){
        driver.findElement(signUpBtn).click();
        driver.findElement(userNameTxtBox).sendKeys(name);
        driver.findElement(passTxtBox).sendKeys(pass);
        driver.findElement(finishSignUpBtn).click();
    }

}
