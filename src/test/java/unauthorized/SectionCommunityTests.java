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

public class SectionCommunityTests {

    private static JavascriptExecutor javascriptExecutor;
    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void openForumTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickForum();
            wait.until(ExpectedConditions.urlMatches("http://forum.worldoftanks.ru/"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("http://forum.worldoftanks.ru/"));
        });
    }

    @Test
    public void openYouTubeTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickYouTube();
            wait.until(ExpectedConditions.urlMatches("https://www.youtube.com/user/WorldOfTanks"));
            Assertions.assertEquals("https://www.youtube.com/user/WorldOfTanks", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openDiscordTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickDiscord();
            wait.until(ExpectedConditions.urlMatches("https://discord.com/invite/wotcis"));
            Assertions.assertEquals("https://discord.com/invite/wotcis", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openFunTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickFunSuite();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/soft/fan-pages/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/soft/fan-pages/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openWotreplaysTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickWarspot();
            wait.until(ExpectedConditions.urlMatches("http://wotreplays.ru/"));
            Assertions.assertEquals("http://wotreplays.ru/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openWgmodsTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickModes();
            wait.until(ExpectedConditions.urlMatches("https://wgmods.net/"));
            Assertions.assertEquals("https://wgmods.net/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openWikiTest() {

        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickWiki();
            wait.until(ExpectedConditions.urlMatches("https://wiki.wargaming.net/ru/Tank:World_of_Tanks"));
            Assertions.assertEquals("https://wiki.wargaming.net/ru/Tank:World_of_Tanks", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openVolunteersTest() {

        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickVolunteers();
            wait.until(ExpectedConditions.urlMatches("http://wg-volunteers.ru/"));
            Assertions.assertEquals("http://wg-volunteers.ru/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void openClanwarsTest() {

        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCommunityButton();
            communityPage.clickClanwars();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/clanwars/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/", webDriver.getCurrentUrl());
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
