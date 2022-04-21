package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import utils.Log;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver =  driver;
    }



    //locatori
    public By username = By.id("log");
    public By password = By.id("password");
    public By loginButton = By.cssSelector("input[class='submit_button']");

    public By logoutButton = By.xpath("//li[@class='menu_user_logout']");
    public By closePopUpButton = By.xpath("//a[@class='popup_close']");

    //metode
    public void loginInApp(String user , String pass) {
        //Log.info("method login in app");
        driver.findElement(username).sendKeys(user);
       // Log.info("send username" + user);
        driver.findElement(password).sendKeys(pass);
       // Log.info("send username" + pass);
        driver.findElement(loginButton).click();
       // Log.info("click login button");
    }

    public void logoutFromApp() {
        driver.findElement(logoutButton).click();
    }

    public void closePopUp() {
        driver.findElement(username).clear();
        driver.findElement(password).clear();
        driver.findElement(closePopUpButton).click();
    }



}


