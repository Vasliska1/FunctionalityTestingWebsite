package unauthorized;

import configuration.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static configuration.Init.*;

public class ClanTest{

    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void testClan() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickClanwarsButton();
            String window = webDriver.getWindowHandle();
            clanPage.clickFindClan();
            wait.until(web -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
            Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", webDriver.getCurrentUrl());
            webDriver.switchTo().window(window);
            clanPage.setInputFindClan();
            clanPage.submit();
            wait.until(web -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
            Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", webDriver.getCurrentUrl());
            webDriver.switchTo().window(window);
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
