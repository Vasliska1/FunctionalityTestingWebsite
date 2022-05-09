package configuration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CommunityPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

import java.util.concurrent.TimeUnit;

public class ConfigurationSetUpTest {
    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static CommunityPage communityPage;
    @BeforeAll
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getProperty("chrome_driver_path"));
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        communityPage = new CommunityPage(driver);
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://worldoftanks.ru/");
    }
}
