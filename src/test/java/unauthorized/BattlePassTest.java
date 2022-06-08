package unauthorized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static configuration.Init.*;

public class BattlePassTest {
    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void clickBattlePassGuideBattleTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickBattlePassButton();
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/battle-pass"));
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            battlePassPage.clickBattlePassGuideBattle();
        });
    }

    @Test
    public void extendButtonTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickBattlePassButton();
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            battlePassPage.clickBattlePassGuideBattle();
            String oldTab = webDriver.getWindowHandle();
            ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
            newTab.remove(oldTab);
            webDriver.switchTo().window(newTab.get(0));
            battlePassPage.clickExpandButton();
            Assertions.assertTrue(battlePassPage.isSomeExtendButton());
        });
    }

    @Test
    public void changeCountVehicles() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickBattlePassButton();
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            battlePassPage.clickBattlePassGuideBattle();
            String oldTab = webDriver.getWindowHandle();
            ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
            newTab.remove(oldTab);
            webDriver.switchTo().window(newTab.get(0));
            battlePassPage.clickPlusCountVehicles();
            Assertions.assertNotEquals(0, battlePassPage.getCountVehiclesText());
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
