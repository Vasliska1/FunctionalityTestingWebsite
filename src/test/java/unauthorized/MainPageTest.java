package unauthorized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static configuration.Init.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }


    @Test
    public void gameButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickGameButton();
            Assertions.assertEquals("https://worldoftanks.ru/ru/game/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void gameDownloadButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickGameSubmenu();
            mainPage.clickDownloadGameDropDownButton();
            Assertions.assertEquals("https://worldoftanks.ru/ru/game/download/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void contentGuideButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickContentGuide();
            Assertions.assertEquals("https://worldoftanks.ru/ru/content/guide/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void tournamentsButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickTournamentsButton();
            Assertions.assertEquals("https://worldoftanks.ru/ru/tournaments/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void communityButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            Assertions.assertEquals("https://worldoftanks.ru/ru/community/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void clanwarsButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickClanwarsButton();
            assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/clanwars/"));
        });
    }

    @Test
    public void mediaDropDownButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunitySubmenu();
            mainPage.clickMediaDropDownButton();
            Assertions.assertEquals("https://worldoftanks.ru/ru/media/", webDriver.getCurrentUrl());
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
