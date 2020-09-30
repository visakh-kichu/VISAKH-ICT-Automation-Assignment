package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.SelectProduct;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class CartOperationsTest extends Common {

    @Test
    @Parameters("product_2")
    public void addToCart(String product_2) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product_2);
        SelectProduct selectProduct = new SelectProduct(getDriver());
        selectProduct.selectActivity();
        extentTest = reports.createTest("Add Product to Cart Test");
        selectProduct.addToCart(extentTest);
    }

    @Test
    @Parameters("product_2")
    public void removeFromCart(String product_2) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product_2);
        SelectProduct selectProduct = new SelectProduct(getDriver());
        selectProduct.selectActivity();
        extentTest = reports.createTest("Remove Product from Cart Test");
        selectProduct.removeFromCart(extentTest);

    }

    @Test
    @Parameters("product_2")
    public void cartSaveItForLater(String product_2) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product_2);
        SelectProduct selectProduct = new SelectProduct(getDriver());
        selectProduct.selectActivity();
        extentTest = reports.createTest("Product Save It For Later Test");
        selectProduct.moveToSaveList(extentTest);
    }

}
