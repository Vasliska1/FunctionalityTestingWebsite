package authorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ClanTest extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupSectionClan(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickClanwarsButton();
    }

    @Test
    public void testClan() {
        String window = driver.getWindowHandle();
        clanPage.clickFindClan();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", driver.getCurrentUrl());
        driver.switchTo().window(window);
        clanPage.setInputFindClan();
        clanPage.submit();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", driver.getCurrentUrl());
        driver.switchTo().window(window);
    }
}
