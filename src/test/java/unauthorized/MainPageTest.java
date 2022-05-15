package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void gameButtonTest() {
        mainPage.clickGameButton();
        Assertions.assertEquals("https://worldoftanks.ru/ru/game/", driver.getCurrentUrl());
    }

    @Test
    public void gameDownloadButtonTest() {
        mainPage.clickGameSubmenu();
        mainPage.clickDownloadGameDropDownButton();
        Assertions.assertEquals("https://worldoftanks.ru/ru/game/download/", driver.getCurrentUrl());
    }

    @Test
    public void contentGuideButtonTest(){
        mainPage.clickContentGuide();
        Assertions.assertEquals("https://worldoftanks.ru/ru/content/guide/", driver.getCurrentUrl());
    }

    @Test
    public void tournamentsButtonTest(){
        mainPage.clickTournamentsButton();
        Assertions.assertEquals("https://worldoftanks.ru/ru/tournaments/", driver.getCurrentUrl());
    }

    @Test
    public void communityButtonTest(){
        mainPage.clickCommunityButton();
        Assertions.assertEquals("https://worldoftanks.ru/ru/community/", driver.getCurrentUrl());
    }

    @Test
    public void clanwarsButtonTest(){
        mainPage.clickClanwarsButton();
        assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/clanwars/"));
    }

    @Test
    public void mediaDropDownButtonTest(){
        mainPage.clickCommunitySubmenu();
        mainPage.clickMediaDropDownButton();
        Assertions.assertEquals("https://worldoftanks.ru/ru/media/", driver.getCurrentUrl());
    }
    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
