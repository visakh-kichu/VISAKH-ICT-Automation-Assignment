package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProductsTest extends Common {
    @Test
    @Parameters("product")
    public void validateSearch(String product) throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity(product);
        homePage.isSearchValid();
        extentTest = reports.createTest("Search Product Test");
    }

}
