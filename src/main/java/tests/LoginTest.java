package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationMenu;
import utils.BaseTest;
//import utils.ImportPropertiesFile;
//import utils.Log;
//import utils.TestNgListener;

import java.io.IOException;

//@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest {

    @Parameters({"browser"})
    @Test
    public void loginTest(String username, String password) {
        NavigationMenu navMenu = new NavigationMenu(driver);
        navMenu.navigateTo(navMenu.loginLink);
        //Log.info("message whatever");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.loginInApp(username, password);


    }

    /*
    HomeWork v
     */

   /* public void logInFromFile() throws IOException {
        ImportPropertiesFile importPropertiesFile = new ImportPropertiesFile();
        NavigationMenu navMenu = new NavigationMenu(driver);
        navMenu.navigateTo(navMenu.loginLink);
        Log.info("Logger in metoda Login tests");

        LoginPage loginPage =  new LoginPage(driver);
        String password = importPropertiesFile.readPropertiesFile("password");

        String username = importPropertiesFile.readPropertiesFile("username");
        //String password = importPropertiesFile.readPropertiesFile("password");
        //System.out.println(password);
        loginPage.loginInApp(username, password);

    } */

}
