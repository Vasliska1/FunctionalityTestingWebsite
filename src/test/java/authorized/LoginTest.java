package authorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp(){
        javascriptExecutor = (JavascriptExecutor) driver;
    }


    @Test
    public void autorizationTest(){
        mainPage.clickLogin();
        ConfigurationSetUpTest.loginPage.inputLogin("v.lisitsina@gmail.com");
        ConfigurationSetUpTest.loginPage.inputPassword("Vasilisa2023");
        ConfigurationSetUpTest.loginPage.clickSubmit();
        profilePage.clickUserMenuHolder();
        profilePage.goToPersonalArea();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assertions.assertEquals("vasliska1", profilePage.getNickname());
        Assertions.assertEquals("v.lisitsina@gmail.com", profilePage.getMail());
        profilePage.clickUserMenuHolder();
        profilePage.clickLogOutButton();
    }

    @Test
    public void failedAutorizationTest(){
        mainPage.clickLogin();
        ConfigurationSetUpTest.loginPage.inputLogin("v.lisitsina@gmail.com");
        ConfigurationSetUpTest.loginPage.inputPassword("VasilisaLoh");
        ConfigurationSetUpTest.loginPage.clickSubmit();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/id/signin/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void logOutTest(){
        mainPage.clickLogin();
        ConfigurationSetUpTest.loginPage.inputLogin("v.lisitsina@gmail.com");
        ConfigurationSetUpTest.loginPage.inputPassword("Vasilisa2023");
        ConfigurationSetUpTest.loginPage.clickSubmit();
        profilePage.clickUserMenuHolder();
        profilePage.clickLogOutButton();
        assertTrue(mainPage.isLoginButtonExist());
    }
    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
