package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.SelectProduct;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HamburgerMenuTest extends Common {

    @Test
    public void hamburgerMenu() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.validateHMenu();
        extentTest = reports.createTest("Hamburger Menu Test");
    }
}
