package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void downloadGameButtonTest(){
        mainPage.clickGameSubmenu();
        mainPage.clickDownloadGameDropDownButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gamePage.clickToDownloadGameButton();
        assertEquals("Спасибо за загрузку!", gamePage.getSuccessDownloadText());
    }

    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
