package authorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends ConfigurationSetUpTest {
    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @ParameterizedTest
    @CsvSource("WhyDontYAskCaptcha3@mail.ru,WhyDontYAskCaptcha3,TestPassword")
    public void registerSuccessTest(String email, String username, String password) {
        mainPage.clickCreateAccountButton();
        registrationPage.clickRegButton();

        // registrationPage.clickNewPlayerButton();
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputNickName(username);
        // driver.findElement(By.id("id_eula")).click();
        registrationPage.clickRegButton();
        javascriptExecutor.executeScript("arguments[0].click();", registrationPage.clickAgreeCheckBox());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        registrationPage.clickRegButton();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/registration/ru/download"));
    }
}
