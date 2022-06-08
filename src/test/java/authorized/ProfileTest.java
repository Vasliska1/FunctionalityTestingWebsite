package authorized;

import configuration.ConfigurationProvider;
import configuration.Init;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest extends Init {

    public static List<WebDriver> driverList;
    private static String login;
    private static String password;

    @BeforeAll
    public static void setUp() {
        login = ConfigurationProvider.getProperty("login");
        password = ConfigurationProvider.getProperty("password");
        driverList = initWebDriver();
    }

    @Test
    public void checkSomeLinkInUserMenuTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            if (!profilePage.isAccountButtonExist()) {
                mainPage.clickLogin();
                Init.loginPage.inputLogin(login);
                Init.loginPage.inputPassword(password);
                Init.loginPage.clickSubmit();
            }
            profilePage.clickUserMenuHolder();
            profilePage.goToPersonalArea();
            profilePage.clickChangeNickName();
            assertEquals("https://ru.wargaming.net/personal/nickname_change/", webDriver.getCurrentUrl());
            javascriptExecutor.executeScript("window.history.go(-1)");
            profilePage.clickSecurityData();
            assertEquals("https://ru.wargaming.net/personal/privacy/", webDriver.getCurrentUrl());
            javascriptExecutor.executeScript("window.history.go(-1)");
            profilePage.clickMyCards();
            assertTrue(webDriver.getCurrentUrl().startsWith("https://card.wargaming.net/cards"));
            javascriptExecutor.executeScript("window.history.go(-1)");
        });
    }

    @Test
    public void subscriptionTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            if (!profilePage.isAccountButtonExist()) {
                mainPage.clickLogin();
                Init.loginPage.inputLogin(login);
                Init.loginPage.inputPassword(password);
                Init.loginPage.clickSubmit();
            }
            profilePage.clickUserMenuHolder();
            profilePage.goToPersonalArea();
            profilePage.clickSubscribe();
            assertEquals("https://ru.wargaming.net/personal/subscriptions/", webDriver.getCurrentUrl());
            assertTrue(profilePage.getStatusCheckboxAccount());
            profilePage.setCheckboxAccount();
            assertFalse(profilePage.getStatusCheckboxAccount());
            assertTrue(profilePage.getStatusCheckboxEvents());
            profilePage.setCheckboxEvents();
            assertFalse(profilePage.getStatusCheckboxEvents());
            profilePage.clickSaveSubscribeButton();
            webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            assertFalse(profilePage.getStatusCheckboxEvents());
            assertFalse(profilePage.getStatusCheckboxAccount());
            javascriptExecutor.executeScript("window.history.go(-1)");
        });
    }

    @Test
    public void bonusCodeTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            if (!profilePage.isAccountButtonExist()) {
                mainPage.clickLogin();
                Init.loginPage.inputLogin(login);
                Init.loginPage.inputPassword(password);
                Init.loginPage.clickSubmit();
            }
            profilePage.clickUserMenuHolder();
            profilePage.clickBonusCode();
            wait.until(ExpectedConditions.urlMatches("https://ru.wargaming.net/shop/redeem/"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://ru.wargaming.net/shop/redeem/"));
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
