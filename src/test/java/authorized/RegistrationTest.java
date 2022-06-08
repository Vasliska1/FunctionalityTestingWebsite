package authorized;

import configuration.Init;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static configuration.Init.*;

public class RegistrationTest {
    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @ParameterizedTest
    @CsvSource("WhyDontYAskCaptcha12@mail.ru,WhyDontYAskCaptcha12,TestPassword")
    public void registerSuccessTest(String email, String username, String password) {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickCreateAccountButton();
            registrationPage.inputEmail(email);
            registrationPage.inputPassword(password);
            registrationPage.inputNickName(username);
            javascriptExecutor.executeScript("arguments[0].click();", registrationPage.clickAgreeCheckBox());
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            registrationPage.clickRegButton();
            wait.until(ExpectedConditions.urlMatches("https://ru.wargaming.net/registration/ru/download"));
            Assertions.assertTrue(webDriver.getCurrentUrl().startsWith("https://ru.wargaming.net/registration/ru/download"));
        });
    }
}
