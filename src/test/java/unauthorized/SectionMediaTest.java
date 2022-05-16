package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class SectionMediaTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupMedia(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickCommunitySubmenu();
        mainPage.clickMediaDropDownButton();
    }

    @Test
    public void openVideo(){
        mediaPage.clickVideo();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/9"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/9"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openModel() {
        mediaPage.clickModel();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/10"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/10"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openComic(){
        mediaPage.clickComic();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/media/12"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
