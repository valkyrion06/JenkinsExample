package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver100");


        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.addArguments("start-maximized");

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions foption = new FirefoxOptions();
        foption.setBinary(firefoxBinary);

        if(browser != "" && browser != null) {

            if(browser.equalsIgnoreCase("chrome")) {
                driver =  new ChromeDriver(option);

            }else if(browser.equalsIgnoreCase("firefox")) {
                driver =  new FirefoxDriver(foption);

            }

        }else {

            driver =  new ChromeDriver(option);


        }





        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1440, 900));

        driver.get("https://keybooks.ro/");
    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus()) {

            TakesScreenshot poza = (TakesScreenshot) driver;
            File screenshot = poza.getScreenshotAs(OutputType.FILE);
            String timestamp =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //Files.copy(screenshot, new File("screenshots/"+ result.getName() + timestamp + ".png"));

        }






    }

}

