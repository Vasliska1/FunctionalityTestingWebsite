package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "//a[@class=\"cm-link cm-link__register cm-link__no-decoration js-cm-event js-cm-login-link js-cm-link-ignore-target\"]")
    private WebElement login;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/a/span")
    private WebElement gameSubmenu;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/div/ul/li[1]/a")
    private WebElement downloadGameDropDownButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/a")
    private WebElement gameButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[6]/a")
    private WebElement communityButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[6]/a/span")
    private WebElement communitySubmenu;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[6]/div/ul/li[5]/a")
    private WebElement mediaDropDownButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/div/ul/li[5]/a")
    private WebElement raitingButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[3]/a")
    private WebElement contentGuideButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[5]/a")
    private WebElement tournamentsButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[4]/a")
    private WebElement clanwars;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[4]/a[2]/span")
    private WebElement battlePassButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a[2]")
    private WebElement createAccountButton;

    public void clickMediaDropDownButton() {
        mediaDropDownButton.click();
    }

    public void clickClanwarsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Кланы\")]")));
        clanwars.click();
    }

    public void clickCommunitySubmenu() {
        communitySubmenu.click();
    }

    public void clickTournamentsButton() {
        tournamentsButton.click();
    }

    public void clickGameSubmenu() {
        gameSubmenu.click();
    }

    public void clickDownloadGameDropDownButton() {
        downloadGameDropDownButton.click();
    }

    public void clickGameButton() {
        gameButton.click();
    }

    public void clickContentGuide() {
        contentGuideButton.click();
    }

    public void clickBattlePassButton() {
        battlePassButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"cm-link cm-link__register cm-link__no-decoration js-cm-event js-cm-login-link js-cm-link-ignore-target\"]")));
        login.click();
    }

    public boolean isLoginButtonExist() {
        try {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a[1]"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickCommunityButton() {
        communityButton.click();
    }

    public void clickRaitingButton() {
        raitingButton.click();
    }
}
