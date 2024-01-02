package tests;

import Data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;

import java.io.IOException;

public class CartTest extends TestBase {
    CartPage cart;

    @DataProvider(name = "shippingData")
    public Object[][] data() throws IOException {
        ExcelReader er = new ExcelReader();
        return er.getExcelData();
    }

    @Test(dataProvider = "shippingData")
    public void testPurchase(String name, String country, String city, String creditCard, String orderMonth, String orderYear) {
        cart = new CartPage(driver);
        cart.clickCart();
        cart.fillOrderData(name, country, city, creditCard, orderMonth, orderYear);
    }
}
