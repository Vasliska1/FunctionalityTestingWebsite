package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BattlePassTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void changeCountVehicles() {

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        battlePassPage.clickPlusCountVehicles();
        Assertions.assertNotEquals(0, battlePassPage.getCountVehiclesText());

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



    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
