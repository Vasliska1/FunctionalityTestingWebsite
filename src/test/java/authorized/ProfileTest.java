package authorized;

import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickLogin();
        ConfigurationSetUpTest.loginPage.inputLogin("v.lisitsina@gmail.com");
        ConfigurationSetUpTest.loginPage.inputPassword("Vasilisa2023");
        ConfigurationSetUpTest.loginPage.clickSubmit();
        profilePage.clickUserMenuHolder();
        profilePage.goToPersonalArea();
    }


    @Test
    public void testCheckSomeLinkInUserMenu(){
        profilePage.clicChangeNickName();
        assertEquals("https://ru.wargaming.net/personal/nickname_change/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        profilePage.clickSecurityData();
        assertEquals("https://ru.wargaming.net/personal/privacy/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        profilePage.clickMyCards();
        assertTrue(driver.getCurrentUrl().startsWith("https://card.wargaming.net/cards"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void testSubscription(){
        profilePage.clickSubscribe();
        assertEquals("https://ru.wargaming.net/personal/subscriptions/", driver.getCurrentUrl());
        assertTrue(profilePage.getStatusCheckboxAccount());
        profilePage.setCheckboxAccount();
        assertFalse(profilePage.getStatusCheckboxAccount());
        assertTrue(profilePage.getStatusCheckboxEvents());
        profilePage.setCheckboxEvents();
        assertFalse(profilePage.getStatusCheckboxEvents());
        profilePage.setCheckboxEvents();
        profilePage.setCheckboxAccount();
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void testChangePassword(){
        profilePage.clickUserMenuHolder();
        profilePage.goToPersonalArea();
        profilePage.clickPasswordEditorButton();
        profilePage.changePassword("Vasilisa2023");
        profilePage.submitPassword();
        assertEquals("Пароль для вашего аккаунта успешно изменён.", profilePage.getMessageSuccessChangePassword());
        profilePage.clickFinishChange();
    }

    @Test
    public void testBonusCode(){
        profilePage.clickUserMenuHolder();
        profilePage.clickBonusCode();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/shop/redeem/"));
    }
}
