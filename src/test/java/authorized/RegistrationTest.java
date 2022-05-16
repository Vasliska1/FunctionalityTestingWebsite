package authorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @ParameterizedTest
    @CsvSource("WhyDontYAskCaptcha11@mail.ru,WhyDontYAskCaptcha11,TestPassword")
    public void registerSuccessTest(String email, String username, String password) {
        mainPage.clickCreateAccountButton();
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputNickName(username);
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        registrationPage.clickRegButton();
        javascriptExecutor.executeScript("arguments[0].click();", registrationPage.clickAgreeCheckBox());
        registrationPage.clickRegButton();
        wait.until(ExpectedConditions.urlMatches("https://ru.wargaming.net/registration/ru/download"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/registration/ru/download"));
    }

}
