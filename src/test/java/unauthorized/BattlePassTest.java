package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class BattlePassTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void clickBattlePassGuideBattleTest() {
        mainPage.clickBattlePassButton();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/battle-pass"));
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        battlePassPage.clickBattlePassGuideBattle();
    }

    @Test
    public void extendButtonTest() {
        mainPage.clickBattlePassButton();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        battlePassPage.clickBattlePassGuideBattle();
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        battlePassPage.clickExpandButton();
        Assertions.assertTrue(battlePassPage.isSomeExtendButton());
    }

    @Test
    public void changeCountVehicles() {
        mainPage.clickBattlePassButton();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        battlePassPage.clickBattlePassGuideBattle();
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        battlePassPage.clickPlusCountVehicles();
        Assertions.assertNotEquals(0, battlePassPage.getCountVehiclesText());

    }
}
