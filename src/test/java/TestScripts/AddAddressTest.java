package TestScripts;

import Common.Common;
import PageObjects.LoginPage;
import PageObjects.UserDetails;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddAddressTest extends Common {
    @Test
    @Parameters({"username","password","firstName","mobileNo","validPincode","houseNo","area","landMark","town","state"})
    public void addAddress(String username,String password,String firstName,String mobileNo,String validPincode,String houseNo,String area,String landMark,String town,String state) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginActivity(username,password);
        UserDetails userDetails = new UserDetails(getDriver());
        userDetails.addAddress(firstName,mobileNo,validPincode,houseNo,area,landMark,town,state);
        extentTest = reports.createTest("Add Address Test");
    }
}
