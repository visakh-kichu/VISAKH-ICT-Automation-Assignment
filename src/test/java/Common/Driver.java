package Common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Driver {

    private static WebDriver driver = null;

    public static WebDriver openBrowser(String browser, String url) {

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                driver = new InternetExplorerDriver(ieoptions);
                break;
        }
        driver.manage().window().maximize();//maximize window
        driver.navigate().to(url);//navigate to url
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        driver.close();
    }
}
