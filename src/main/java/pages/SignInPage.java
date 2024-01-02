package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends PageBase {
    @FindBy(id = "login2")
    private WebElement startLogInBtn;

    @FindBy(id = "loginusername")
    private WebElement userNameTxtBox;
    @FindBy(id = "loginpassword")
    private WebElement passTxtBox;

    //onclick='logIn()'
    @FindBy(xpath = "//button[@onclick='logIn()']")
    private WebElement loginBtn;
    @FindBy(id = "nameofuser")
    private WebElement welcomeMsg;

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public void logInToBlaze(String username,String pass){
        startLogInBtn.click();
        userNameTxtBox.sendKeys(username);
        passTxtBox.sendKeys(pass);
        loginBtn.click();
    }
    public boolean isLogged(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "nameofuser")));
        return welcomeMsg.isDisplayed();
    }
}
