package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver100.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1440,900));
        driver.get("https://keybooks.ro/");
        //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus()) {

            TakesScreenshot poza = (TakesScreenshot) driver;
            File screenshot = poza.getScreenshotAs(OutputType.FILE);
            String timestamp =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
           // Files.copy(screenshot, new File("screenshots/"+ result.getName() + timestamp + ".png"));

        }

    }

}

