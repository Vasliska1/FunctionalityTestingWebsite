package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SectionCommunityTests extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickCommunityButton();
    }

    @Test
    public void openForumTest() {
        communityPage.clickForum();
        wait.until(ExpectedConditions.urlMatches("http://forum.worldoftanks.ru/"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("http://forum.worldoftanks.ru/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openYouTubeTest() {
        communityPage.clickYouTube();
        wait.until(ExpectedConditions.urlMatches("https://www.youtube.com/user/WorldOfTanks"));
        Assertions.assertEquals("https://www.youtube.com/user/WorldOfTanks", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openDiscordTest() {
        communityPage.clickDiscord();
        wait.until(ExpectedConditions.urlMatches("https://discord.com/invite/wotcis"));
        Assertions.assertEquals("https://discord.com/invite/wotcis", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openFunTest() {
        communityPage.clickFunSuite();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/soft/fan-pages/"));
        Assertions.assertEquals("https://worldoftanks.ru/ru/soft/fan-pages/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openWotreplaysTest() {
        communityPage.clickWarspot();
        wait.until(ExpectedConditions.urlMatches("http://wotreplays.ru/"));
        Assertions.assertEquals("http://wotreplays.ru/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openWgmodsTest() {
        communityPage.clickModes();
        wait.until(ExpectedConditions.urlMatches("https://wgmods.net/"));
        Assertions.assertEquals("https://wgmods.net/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openWikiTest() {
        communityPage.clickWiki();
        wait.until(ExpectedConditions.urlMatches("https://wiki.wargaming.net/ru/Tank:World_of_Tanks"));
        Assertions.assertEquals("https://wiki.wargaming.net/ru/Tank:World_of_Tanks", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openVolunteersTest() {
        communityPage.clickVolunteers();
        wait.until(ExpectedConditions.urlMatches("http://wg-volunteers.ru/"));
        Assertions.assertEquals("http://wg-volunteers.ru/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openClanwarsTest() {
        communityPage.clickClanwars();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/clanwars/"));
        Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
