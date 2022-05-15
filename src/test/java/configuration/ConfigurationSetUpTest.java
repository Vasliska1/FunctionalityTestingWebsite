package configuration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;

import java.io.File;
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
    public static void setup(){
        driver = initWebDriver();
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
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://worldoftanks.ru/");
    }

    public static WebDriver initWebDriver() {
        System.out.println(2);
        if (ConfigurationProvider.getProperty("main_driver").equals("CHROME")) {
            System.out.println(1);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--no-sandbox"); // Bypass OS security model
            driver = new ChromeDriver(options);
            System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));

           } else if (ConfigurationProvider.getProperty("main_driver").equals("FIREFOX")) {
           
            System.setProperty("webdriver.firefox.driver", ConfigurationProvider.getProperty("mozilla_driver_path"));
            FirefoxOptions options = new FirefoxOptions();
           // System.out.println(options.getBinary());
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--no-sandbox"); // Bypass OS security model
            FirefoxBinary binary = new FirefoxBinary(new File("Downloads/firefox-portable-95.0/app/firefox"));
            options.setBinary(binary);

            //File browserAppPath = new File("/snap/firefox/1300/usr/lib/firefox/firefox-bin");
            driver = new FirefoxDriver(options);
        }
        return driver;
    }
}
