package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConfigurationSetUpTest {
    public static MainPage mainPage;
    public static ClanPage clanPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static CommunityPage communityPage;
    public static RatingPage ratingPage;
    public static GamePage gamePage;
    public static MediaPage mediaPage;
    public static BattlePassPage battlePassPage;
    public static RegistrationPage registrationPage;

    @BeforeAll
    public static void setup() {
        initWebDriver();
        wait = new WebDriverWait(driver, 30);
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
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://worldoftanks.ru/");
    }

    public static void initWebDriver() {
        if (ConfigurationProvider.getProperty("main_driver").equals("CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--no-sandbox"); // Bypass OS security model
            driver = new ChromeDriver(options);
            System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));

        } else if (ConfigurationProvider.getProperty("main_driver").equals("FIREFOX")) {
          //  System.setProperty("webdriver.firefox.bin", "home/vasilisa/Videos/firefox/firefox");
            System.setProperty("webdriver.gecko.driver", ConfigurationProvider.getProperty("mozilla_driver_path"));

      //     WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
           // FirefoxBinary binary = new FirefoxBinary(new File("/usr/lib/firefox/firefox"));
       //     options.setBinary("/usr/lib/firefox/firefox");

            driver = new FirefoxDriver(options);
            //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            //driver = new FirefoxDriver(options);
        }
    }
}
