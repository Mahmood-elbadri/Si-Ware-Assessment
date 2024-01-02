package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    @Parameters("browser")
    @BeforeSuite
    public void setUp(@Optional("chrome")  String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "credentials")
    public Object[][] data() throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(9001) + 1000;
        String name = "Lionel-Messi" + Integer.toString(randomNumber) + "@xxx.com";
        String pass = "test123";
        return new Object[][]{
                {name, pass}
        };
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helper.takeScreenShot(driver, result.getName());
        }
    }

}
