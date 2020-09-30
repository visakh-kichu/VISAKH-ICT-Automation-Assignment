package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class FooterElementsTest extends Common {
    @Test
    public void validateFooterElements() throws IOException {
       HomePage homePage = new HomePage(getDriver());
       homePage.footerElements();
       extentTest = reports.createTest("Footer Elements Test");
    }

}
