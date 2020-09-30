package PageObjects;

import Common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UserDetails {

    @FindBy(xpath = "//*[@id=\"nav-global-location-slot\"]/span/a")
    private WebElement btn_Address;
    @FindBy(xpath = "//span[@id='GLUXZipError']") //*[@id="GLUXZipError"]/div/div/div
    private WebElement alert_invalidPin;
    @FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
    private WebElement txt_Pincode;
    @FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
    private WebElement btn_ApplyPin;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span[1]")
    private WebElement mouse_H;
    @FindBy(xpath = "//*[@id=\"nav-al-your-account\"]/a[1]")
    private WebElement link_Account;
    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")
    private WebElement link_Address;
    @FindBy(id = "ya-myab-plus-address-icon")
    private WebElement btn_addAddress;
    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement txt_Fullname;
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    private WebElement txt_MobileNo;
    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    private WebElement txt_Pincode_2;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    private WebElement txt_HouseNo;
    @FindBy(id = "address-ui-widgets-enterAddressLine2")
    private WebElement txt_Area;
    @FindBy(id = "address-ui-widgets-landmark")
    private WebElement txt_LandMark;
    @FindBy(id = "address-ui-widgets-enterAddressCity")
    private WebElement txt_Town;
    @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    private WebElement btn_addAddress_2;
    @FindBy(xpath = "//h4[text()='Address saved']")
    private WebElement alert_AddressSaved;
    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div/div[2]/div/span")
    private WebElement link_SecurityLogin;
    @FindBy(id = "auth-cnep-edit-password-button")
    private WebElement btn_editPassword;
    @FindBy(id = "ap_password")
    private WebElement txt_oldPassword;
    @FindBy(id = "ap_password_new")
    private WebElement txt_newPassword;
    @FindBy(id = "ap_password_new_check")
    private WebElement txt_reEnterPassword;
    @FindBy(id = "cnep_1D_submit_button")
    private WebElement btn_saveChanges;
    @FindBy(xpath = "//*[@id=\"auth-success-message-box\"]/div/div/ul/li/span")
    private WebElement alet_passWordChanged;


    Actions action = new Actions(Common.getDriver());

    public UserDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addPincode(String pincode) {
        btn_Address.click();
        txt_Pincode.clear();
        txt_Pincode.sendKeys(pincode);
        btn_ApplyPin.click();
    }

    public void validPincode() {
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertFalse(alert_invalidPin.isDisplayed());
    }

    public void invalidPincode() {
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(alert_invalidPin.isDisplayed());
    }

    public void addAddress(String fName, String mobile, String pinCode, String houseNo, String area, String landMark, String town, String state) {
        action.moveToElement(mouse_H).perform();
        link_Account.click();
        link_Address.click();
        btn_addAddress.click();
        txt_Fullname.sendKeys(fName);
        txt_MobileNo.sendKeys(mobile);
        txt_Pincode_2.sendKeys(pinCode);
        txt_HouseNo.sendKeys(houseNo);
        txt_Area.sendKeys(area);
        txt_LandMark.sendKeys(landMark);
        txt_Town.sendKeys(town);
        Select select_State = new Select(Common.getDriver().findElement(By.xpath("//select[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")));
        select_State.selectByValue(state.toUpperCase());
        btn_addAddress_2.click();
        Assert.assertTrue(alert_AddressSaved.isDisplayed());
    }

    public void changePassword(String oldPassword, String newPassword) {
        action.moveToElement(mouse_H).perform();
        link_Account.click();
        link_SecurityLogin.click();
        btn_editPassword.click();
        txt_oldPassword.sendKeys(oldPassword);
        txt_newPassword.sendKeys(newPassword);
        txt_reEnterPassword.sendKeys(newPassword);
        btn_saveChanges.click();
        Assert.assertTrue(alet_passWordChanged.isDisplayed());
    }
}
