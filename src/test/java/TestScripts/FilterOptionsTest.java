package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilterOptionsTest extends Common {

    @Test
    public void filterOptions() throws IOException {

        HomePage homePage = new HomePage(getDriver());
        homePage.searchActivity("redmi");
        homePage.filterCheck();
        extentTest = reports.createTest("Filter Options Test");
    }
}
