package PageObjects;

import Common.Common;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectProduct {
    String productSearched, productSelected;
    @FindBy(xpath = "//*[@id=\"productTitle\"]")
    private WebElement product_Title;
    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    private WebElement cart_Count;
    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    private WebElement btn_cart;
    @FindBy(id = "hlb-view-cart-announce")
    private WebElement btn_goCart;
    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div[1]/div/h1")
    private WebElement msg_CartEmpty;
    @FindBy(xpath = "//input[@value='Save for later']")
    private WebElement link_saveItLater;

    public SelectProduct(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectActivity() throws IndexOutOfBoundsException {
        Common.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> elements = Common.getDriver().findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        elements.get(2).click();
        productSearched = elements.get(2).getText();
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void removeFromCart(ExtentTest extentTest) throws IOException {
        ArrayList<String> windowTab = new ArrayList<>(Common.getDriver().getWindowHandles());
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Common.getDriver().switchTo().window(windowTab.get(1));
        Assert.assertEquals(cart_Count.getText(), "0", "Check Locator:Cart 0");
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select product_Quantity = new Select(Common.getDriver().findElement(By.xpath("//select[@name='quantity']")));
        product_Quantity.selectByValue("1");
        btn_cart.click();
        btn_goCart.click();
        Assert.assertEquals(cart_Count.getText(), "1", "Check Locator:Cart 1");
        Select cart_Quantity = new Select(Common.getDriver().findElement(By.xpath("//select[@name='quantity']")));
        cart_Quantity.selectByValue("0");
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(msg_CartEmpty.isDisplayed());
//        extentTest = reports.createTest("Remove Product from Cart Test");
//        extentTest.log(Status.PASS, "Product Removed successfully");
//        extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        Common.getDriver().close();
        Common.getDriver().switchTo().window(windowTab.get(0));
    }

    public void addToCart(ExtentTest extentTest) throws IOException {
        ArrayList<String> windowTab = new ArrayList<>(Common.getDriver().getWindowHandles());
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Common.getDriver().switchTo().window(windowTab.get(1));
        Assert.assertEquals(cart_Count.getText(), "0", "Check Locator:Cart 0");
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select product_Quantity = new Select(Common.getDriver().findElement(By.xpath("//select[@name='quantity']")));
        product_Quantity.selectByValue("3");
        btn_cart.click();
        btn_goCart.click();
        Select quantitySelected = new Select(Common.getDriver().findElement(By.xpath("//select[@name='quantity']")));
        Assert.assertEquals(quantitySelected.getFirstSelectedOption().getText().replaceAll("\\s", ""), "3", "Quantity 3");
        extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        Common.getDriver().close();
        Common.getDriver().switchTo().window(windowTab.get(0));
    }

    public void validateSeclectActivity() {

        ArrayList<String> windowTab = new ArrayList<>(Common.getDriver().getWindowHandles());
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Common.getDriver().switchTo().window(windowTab.get(1));
        productSelected = product_Title.getText();
        Common.getDriver().close();
        Common.getDriver().switchTo().window(windowTab.get(0));
        Assert.assertEquals(productSearched, productSelected);
    }

    public void moveToSaveList(ExtentTest extentTest) throws IOException {
        ArrayList<String> windowTab = new ArrayList<>(Common.getDriver().getWindowHandles());
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Common.getDriver().switchTo().window(windowTab.get(1));
        Assert.assertEquals(cart_Count.getText(), "0", "Check Locator:Cart 0");
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select product_Quantity = new Select(Common.getDriver().findElement(By.xpath("//select[@name='quantity']")));
        product_Quantity.selectByValue("1");
        btn_cart.click();
        btn_goCart.click();
        Assert.assertEquals(cart_Count.getText(), "1", "Check Locator:Cart 1");
        link_saveItLater.click();
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        Assert.assertTrue(msg_CartEmpty.isDisplayed());
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Common.getDriver().close();
        Common.getDriver().switchTo().window(windowTab.get(0));

    }

}

