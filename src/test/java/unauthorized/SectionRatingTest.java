package unauthorized;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static configuration.Init.*;

public class SectionRatingTest {

    public static List<WebDriver> driverList;

    @BeforeAll
    public static void setUp() {
        driverList = initWebDriver();
    }

    @Test
    public void ratingAchievementsTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            mainPage.clickGameSubmenu();
            mainPage.clickRaitingButton();
            ratingPage.clickRatingAchievements();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/ratings/achievements/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void ratingVehicleTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);

            mainPage.clickGameSubmenu();
            mainPage.clickRaitingButton();
            ratingPage.clickRatingVehicle();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/ratings/vehicles/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", webDriver.getCurrentUrl());
        });
    }

    @Test
    public void connectionBetweenRatingsTest() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);

            mainPage.clickGameSubmenu();
            mainPage.clickRaitingButton();
            ratingPage.clickRatingAchievements();
            ratingPage.moveToAnotherRating();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/ratings/vehicles/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", webDriver.getCurrentUrl());
            ratingPage.moveToAnotherRating();
            wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/ratings/achievements/"));
            Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", webDriver.getCurrentUrl());
        });
    }

    @AfterAll
    public static void quit() {
        driverList.forEach(webDriver -> {
            initElement(webDriver);
            webDriver.quit();
        });
    }
}