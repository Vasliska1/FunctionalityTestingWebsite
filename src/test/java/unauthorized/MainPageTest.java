package unauthorized;

import configuration.ConfigurationProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    ChromeDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("--no-sandbox"); // Bypass OS security model

        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        driver.get("https://worldoftanks.ru/");
    }

    @Test
    public void testDownloadGameDropDownButton(){
        mainPage.clickToGameDropDown();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickToDownloadGameDropDownButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(driver.getCurrentUrl().contains("https://worldoftanks.ru/ru/game/download/"));
    }

    @Test
    public void testDownloadGameButton(){
        mainPage.clickToGameDropDown();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickToDownloadGameDropDownButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickToDownloadGameDropDownButton();
        assertEquals("Спасибо за загрузку!", mainPage.getSuccessDownloadText());
    }



}
