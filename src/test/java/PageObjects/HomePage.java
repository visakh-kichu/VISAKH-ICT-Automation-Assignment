package PageObjects;

import Common.Common;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement txtbox_Search;
    @FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[2]/div/input")
    private WebElement btn_search;
    @FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")
    private WebElement search_Count;
    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
    private WebElement product_First;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/div/span")
    private WebElement welcome_Msg;
    @FindBy(xpath = "//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]/a")
    private WebElement link_AboutUs;
    @FindBy(xpath = "//*[@id=\"p_n_feature_seven_browse-bin/8561130031\"]/span/a/span")
    private WebElement filter_ram;
    @FindBy(xpath = "//*[@id=\"nav-hamburger-menu\"]/i")
    private WebElement h_Menu;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[2]/a")
    private WebElement h_Menu_Option;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[2]/li[3]/a")
    private WebElement getH_Menu_Option_2;
    @FindBy(xpath = "//*[text()='Price: High to Low'][@id='s-result-sort-select_2']")
    private WebElement sort_HighToLow;
    @FindBy(xpath = "//span[text()='Sort by:']")
    private WebElement sort_options;
    String searchCount;
    WebDriverWait wait=new WebDriverWait(Common.getDriver(),20);
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void searchActivity(String product) {
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        txtbox_Search.sendKeys(product);
        wait.until(ExpectedConditions.visibilityOf(btn_search));
        btn_search.click();
        wait.until(ExpectedConditions.visibilityOf(search_Count));
        searchCount = search_Count.getText();
    }

    public void isSearchValid() {
        Assert.assertTrue(search_Count.isDisplayed());
    }


    public void footerElements() {
        js.executeScript("arguments[0].scrollIntoView();", link_AboutUs);
        link_AboutUs.click();
        Common.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(Common.getDriver().getTitle(), "Amazon India transforms small business in India");
    }

    public void filterCheck() {
        filter_ram.click();
        Assert.assertNotEquals(searchCount, search_Count.getText());
        Common.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void sortActivity() {
        sort_options.click();
        Common.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sort_HighToLow.click();
        Assert.assertTrue(sort_HighToLow.isEnabled());
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void validateHMenu() {
        h_Menu.click();
        h_Menu_Option.click();
        getH_Menu_Option_2.click();
        Common.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void validUser() {
        Assert.assertNotEquals(welcome_Msg.getText(), "Hello, Sign in");
    }
}
