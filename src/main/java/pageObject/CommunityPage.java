package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommunityPage {


    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/a")
    private WebElement logo;

    @FindBy(xpath = "//a[@class=\"community-page-block\"]")
    private List<WebElement> communityBlocks;

    @FindBy(xpath = "//a[@class=\"community-page-block_small\"]")
    private List<WebElement> communitySmallBlocks;

    public CommunityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[4]/div[1]/a")));
        logo.click();
    }

    public void clickForum() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block\"]")));
        communityBlocks.get(0).click();
    }

    public void clickYouTube() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block\"]")));
        communityBlocks.get(1).click();
    }

    public void clickDiscord() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block\"]")));
        communityBlocks.get(2).click();
    }

    public void clickFunSuite() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(0).click();
    }

    public void clickWarspot() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(1).click();
    }

    public void clickModes() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(2).click();
    }

    public void clickWiki() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(3).click();
    }

    public void clickVolunteers() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(4).click();
    }

    public void clickClanwars() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"community-page-block_small\"]")));
        communitySmallBlocks.get(5).click();
    }


}
