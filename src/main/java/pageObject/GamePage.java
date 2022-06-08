package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamePage {
    private WebDriverWait wait;
    private WebDriver driver;

    public GamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div/div[3]/div[2]/a[1]")
    private WebElement downloadGameButton;


    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div[2]/strong")
    private WebElement successDownloadText;


    public String getSuccessDownloadText(){
        return successDownloadText.getText();
    }

    public void clickToDownloadGameButton(){
        downloadGameButton.click();
    }
}
