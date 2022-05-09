package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a[1]")
    private WebElement login;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/a/span")
    private WebElement gameDropDownButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[2]/div/ul/li[1]/a")
    private WebElement downloadGameDropDownButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div/div[3]/div[2]/a[1]")
    private WebElement downloadGameButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div[2]/strong")
    private WebElement successDownloadText;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[6]/a")
    private WebElement communityButton;

    public void clickToGameDropDown() {
        gameDropDownButton.click();
    }

    public void clickToDownloadGameDropDownButton() {
        downloadGameDropDownButton.click();
    }

    public void clickToDownloadGameButton(){
        downloadGameButton.click();
    }

    public String getSuccessDownloadText(){
        return successDownloadText.getText();
    }

    public void clickLogin(){
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"cm-link cm-link__register cm-link__no-decoration js-cm-event js-cm-login-link js-cm-link-ignore-target\"]")));
        login.click();
    }

    public boolean isLoginButtonExist(){
        try {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a[1]"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickCommunityButton(){
        communityButton.click();
    }
}
