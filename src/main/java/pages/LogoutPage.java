package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage extends PageBase{
    //id="logout2"
    @FindBy(xpath = "//a[@id='logout2']")
    private WebElement logOutBtn;
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    //xpath = "//*[text()='Log out']"
    public void clickLogOut() throws InterruptedException {
        driver.navigate().to("https://www.demoblaze.com/");
        logOutBtn.click();
    }
}
