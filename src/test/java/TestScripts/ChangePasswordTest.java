package TestScripts;

import Common.Common;
import PageObjects.LoginPage;
import PageObjects.UserDetails;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangePasswordTest extends Common{
    @Test
    @Parameters({"username","password","newPassword",})
    public void changePassword(String username,String password,String newPassword) throws IOException {
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.loginActivity(username,password);
        UserDetails userDetails=new UserDetails(getDriver());
        userDetails.changePassword(password,newPassword);
        extentTest = reports.createTest("Change Password Test");
    }
}
