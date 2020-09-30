package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.SelectProduct;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SelectProductTest extends Common {

    @Test
    @Parameters("product")
    public void selectProduct(String product) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product);
        SelectProduct selectProduct = new SelectProduct(getDriver());
        selectProduct.selectActivity();
        selectProduct.validateSeclectActivity();
        extentTest = reports.createTest("Select Product Test");
    }

    @Test
    @Parameters("product")
    public void sortTest(String product) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product);
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.sortActivity();
        extentTest = reports.createTest("Sort Result Test");
    }
}
