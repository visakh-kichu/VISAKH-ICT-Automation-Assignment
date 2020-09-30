package Common;

import TestScripts.LoginTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import javafx.scene.layout.Priority;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


public class Common extends Driver {

    public static ExtentReports reports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;

    @BeforeMethod
    public void startBrowser() {
        WebDriver driver = Driver.openBrowser("ie", "https://www.amazon.in/");
    }

    @AfterMethod()
    public void stopBrowser(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
            extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
            extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
            extentTest.addScreenCaptureFromPath(Common.takeScreenshot());
        }


        Driver.closeBrowser();
    }

    @BeforeSuite
    public void startReport() throws UnknownHostException {
        System.out.println("Reporting Start ");
        String path = System.getProperty("user.dir");
        reports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(path + "\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
    }

    @AfterSuite
    public void stopReport() {
        reports.flush();
    }

    public static String takeScreenshot() throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        String file = "ss" + random.nextInt(1000) + ".png";
        String fileName = System.getProperty("user.dir") + "\\report\\" + file;
        File destinationFile = new File(fileName);
        FileUtils.copyFile(screenshot, destinationFile);
        return file;
    }
}
