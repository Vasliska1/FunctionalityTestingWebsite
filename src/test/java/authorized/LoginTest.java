package authorized;

import configuration.ConfigurationProvider;
import configuration.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends Init {

    private static String login;
    private static String password;
    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        login = ConfigurationProvider.getProperty("login");
        password = ConfigurationProvider.getProperty("password");
        driverList = initWebDriver();
    }


    @Test
    public void autorizationTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickLogin();
            Init.loginPage.inputLogin(login);
            Init.loginPage.inputPassword(password);
            Init.loginPage.clickSubmit();
            profilePage.clickUserMenuHolder();
            profilePage.goToPersonalArea();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Assertions.assertEquals("vasliska1", profilePage.getNickname());
            Assertions.assertEquals("v.lisitsina@gmail.com", profilePage.getMail());
            profilePage.clickUserMenuHolder();
            profilePage.clickLogOutButton();
        });
    }

    @Test
    public void failedAutorizationTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickLogin();
            Init.loginPage.inputLogin(login);
            Init.loginPage.inputPassword("VasilisaLoh");
            Init.loginPage.clickSubmit();
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://ru.wargaming.net/id/signin/"));
        });
    }

    @Test
    public void logOutTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickLogin();
            Init.loginPage.inputLogin(login);
            Init.loginPage.inputPassword(password);
            Init.loginPage.clickSubmit();
            profilePage.clickUserMenuHolder();
            profilePage.clickLogOutButton();
            assertTrue(mainPage.isLoginButtonExist());
        });
    }

    @AfterAll
    public static void quit() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            webDriver.quit();
        });
    }
}
