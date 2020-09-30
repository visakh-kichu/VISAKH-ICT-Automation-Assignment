package TestScripts;

import Common.Common;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class LoginTest extends Common {
    @Test
    @Parameters({"username","password"})
    public void validLogin(String username,String password) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.loginActivity(username, password);
        homePage.validUser();
        extentTest = reports.createTest("LoginTest with Valid Credentials");
    }

    @Test
    @Parameters({"invalidUsername","password"})
    public void invalidLogin(String invalidUsername,String password) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.invalidUser(invalidUsername, password);
        extentTest = reports.createTest("LoginTest with invalid Email");
    }
}
