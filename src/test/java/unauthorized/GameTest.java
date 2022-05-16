package unauthorized;

import configuration.ConfigurationProvider;
import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void downloadGameButtonTest(WebDriver newDriver){
        driver = newDriver;
        mainPage.clickGameSubmenu();
        mainPage.clickDownloadGameDropDownButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gamePage.clickToDownloadGameButton();
        assertEquals("Спасибо за загрузку!", gamePage.getSuccessDownloadText());
    }
    private static Stream<Arguments> generator() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));

        return Stream.of(
                Arguments.of(driver),
                Arguments.of(driver)
        );
    }
    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
