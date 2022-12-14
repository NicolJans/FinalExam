package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homepage;
    String BASEURL = "https://katalon-demo-cura.herokuapp.com/";

    //CHROMEDRIVER SETUP
    @BeforeSuite
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        homepage = new HomePage(driver);
    }

    //METHOD TO CAPTURE SCREENSHOTS
    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/failResults/" +testResult.getName()+"_FAIL" +testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/passResults/" +testResult.getName()+"_PASS" +testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //METHOD TO CLOSE BROWSER WHEN TESTS COMPLETED
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
