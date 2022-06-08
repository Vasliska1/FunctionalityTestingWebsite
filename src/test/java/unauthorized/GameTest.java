package unauthorized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static configuration.Init.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void downloadGameButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mainPage.clickGameSubmenu();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mainPage.clickDownloadGameDropDownButton();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/game/download/"));
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            gamePage.clickToDownloadGameButton();
            assertEquals("Спасибо за загрузку!", gamePage.getSuccessDownloadText());
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
