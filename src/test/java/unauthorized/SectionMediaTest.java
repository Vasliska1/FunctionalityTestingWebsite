package unauthorized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static configuration.Init.*;

public class SectionMediaTest {
    private static JavascriptExecutor javascriptExecutor;

    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void openVideo() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunitySubmenu();
            mainPage.clickMediaDropDownButton();
            mediaPage.clickVideo();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/9/"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/9/"));
        });
    }

    @Test
    public void openArt() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunitySubmenu();
            mainPage.clickMediaDropDownButton();
            mediaPage.clickArt();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/1/"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/1/"));
        });
    }

    @Test
    public void openModel() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunitySubmenu();
            mainPage.clickMediaDropDownButton();
            mediaPage.clickModel();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/10"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/10"));
        });
    }

    @Test
    public void openComic() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunitySubmenu();
            mainPage.clickMediaDropDownButton();
            mediaPage.clickComic();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/12"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/12"));
        });
    }

    @AfterAll
    public static void quit() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            webDriver.close();
        });
    }
}
