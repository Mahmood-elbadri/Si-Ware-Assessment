package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase {
    @FindBy(xpath = "//a[@id='signin2']")
    private WebElement signUpBtn;
    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement userNameTxtBox;
    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passTxtBox;
    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement finishSignUpBtn;
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    public void signUp(String name,String pass){
        signUpBtn.click();
        userNameTxtBox.sendKeys(name);
        passTxtBox.sendKeys(pass);
        finishSignUpBtn.click();
    }

}
