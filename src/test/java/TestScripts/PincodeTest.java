package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UserDetails;
import com.aventstack.extentreports.Status;
import javafx.scene.layout.Priority;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PincodeTest extends Common {
    @Test
    @Parameters({"username","password","validPincode"})
    public void validPincode(String username,String password,String validPincode) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        UserDetails userDetails = new UserDetails(getDriver());
        loginPage.loginActivity(username, password);
        userDetails.addPincode(validPincode);
        userDetails.validPincode();
        extentTest = reports.createTest("Valid Pincode Test");
    }

    @Test
    @Parameters({"username","password","invalidPincode"})
    public void invalidPincode(String username,String password,String invalidPincode) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        UserDetails userDetails = new UserDetails(getDriver());
        loginPage.loginActivity(username, password);
        userDetails.addPincode(invalidPincode);
        userDetails.invalidPincode();
        extentTest = reports.createTest("InValid Pincode Test");
    }

}
