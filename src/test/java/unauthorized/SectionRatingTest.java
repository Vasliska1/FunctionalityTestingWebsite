package unauthorized;


import configuration.ConfigurationSetUpTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class SectionRatingTest extends ConfigurationSetUpTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupRating() {
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickGameSubmenu();
        mainPage.clickRaitingButton();
    }

    @Test
    public void ratingAchievementsTest() {
        ratingPage.clickRatingAchievements();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void ratingVehicleTest() {
        ratingPage.clickRatingVehicle();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void connectionBetweenRatingsTest() {
        ratingPage.clickRatingAchievements();
        ratingPage.moveToAnotherRating();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", driver.getCurrentUrl());
        ratingPage.moveToAnotherRating();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-3)");
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}