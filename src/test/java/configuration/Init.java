package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Init {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static ClanPage clanPage;
    public static ProfilePage profilePage;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static CommunityPage communityPage;
    public static RatingPage ratingPage;
    public static GamePage gamePage;
    public static MediaPage mediaPage;
    public static BattlePassPage battlePassPage;
    public static RegistrationPage registrationPage;
    public static JavascriptExecutor javascriptExecutor;

    public static void initElement(WebDriver driver){

        wait = new WebDriverWait(driver, (30));
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        communityPage = new CommunityPage(driver);
        clanPage = new ClanPage(driver);
        ratingPage = new RatingPage(driver);
        mediaPage = new MediaPage(driver);
        gamePage = new GamePage(driver);
        registrationPage = new RegistrationPage(driver);
        battlePassPage = new BattlePassPage(driver);
        javascriptExecutor = (JavascriptExecutor) driver;

        driver.get("https://worldoftanks.ru/");
    }

    public static  List<WebDriver> initWebDriver() {
        List<WebDriver> driverList = new ArrayList<>();

        if (ConfigurationProvider.getProperty("main_driver").equals("CHROME") || ConfigurationProvider.getProperty("main_driver").equals("BOTH") ) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--no-sandbox"); // Bypass OS security model
            WebDriver driver = new ChromeDriver(options);
            System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));
            driverList.add(driver);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        if (ConfigurationProvider.getProperty("main_driver").equals("FIREFOX") || ConfigurationProvider.getProperty("main_driver").equals("BOTH")) {
            FirefoxOptions options = new FirefoxOptions();
            System.setProperty("webdriver.gecko.driver", ConfigurationProvider.getProperty("mozilla_driver_path"));
            WebDriver driver = new FirefoxDriver(options);
            driverList.add(driver);
        }

        return driverList;
    }
}
