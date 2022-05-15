package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RatingPage {

    @FindBy(xpath = "//h1[@class=\"heading-1 heading-1__uppercase\"]")
    private WebElement title;

    @FindBy(xpath = "//a[@class=\"nav-submenu_link\"]")
    private WebElement logo;

    @FindBy(xpath = "//a[@class=\"rating-link\"]")
    private WebElement ratingAchievements;

    @FindBy(xpath = "//a[@class=\"rating-link rating-link__type-2\"]")
    private WebElement ratingVehicles;

    @FindBy(xpath = "//a[@class=\"sub-button\"]")
    private WebElement сonnectionLink;

    private WebDriver driver;

    public RatingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle(){
        return title.getText();
    }

    public void clickLogo() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nav-submenu_link\"]")));
        logo.click();
    }

    public void clickRatingAchievements() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"rating-link\"]")));
        ratingAchievements.click();
    }

    public void clickRatingVehicle() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"rating-link rating-link__type-2\"]")));
        ratingVehicles.click();
    }

    public void moveToAnotherRating() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"sub-button\"]")));
        сonnectionLink.click();
    }

}