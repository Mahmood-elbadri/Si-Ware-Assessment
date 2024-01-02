package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddItemToCart extends PageBase{
    @FindBy(linkText = "Nokia lumia 1520")
    private WebElement product;
    //onclick='addToCart(2)'
    @FindBy(xpath = "//a[@onclick='addToCart(2)']")
    private WebElement addProductBtn;

    public AddItemToCart(WebDriver driver) {
        super(driver);
    }
    public void clickAddProduct(){
        product.click();
        addProductBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
