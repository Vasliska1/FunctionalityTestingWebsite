package unauthorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.JavascriptExecutor;

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
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/9/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openArt(){
        mediaPage.clickArt();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/1/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openModel() {
        mediaPage.clickModel();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/10"));
        String window = driver.getWindowHandle();
        mediaPage.clickLink();
        driver.switchTo().window(window);
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openComic(){
        mediaPage.clickComic();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/12"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
