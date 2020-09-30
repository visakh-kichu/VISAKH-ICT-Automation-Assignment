package PageObjects;

import Common.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private WebElement txt_email;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement btn_continue;
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private WebElement txt_pwd;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    private WebElement btn_login;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
    private WebElement btn_signin;
    @FindBy(xpath = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")
    private WebElement error_Login;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginActivity(String userName, String pwd) throws IOException {
        btn_signin.click();
        txt_email.sendKeys(userName);
        btn_continue.click();
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        txt_pwd.sendKeys(pwd);
        btn_login.click();
    }

    public void invalidUser(String userName, String pwd) {
        btn_signin.click();
        txt_email.sendKeys(userName);
        btn_continue.click();
        Assert.assertTrue(error_Login.isDisplayed());
    }
}
