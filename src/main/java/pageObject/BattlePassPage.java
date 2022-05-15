package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BattlePassPage {
    WebDriver driver;

    public BattlePassPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/section/div/div/div/div[3]/a")
    private WebElement battlePassGuideButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div/div/article/div[1]/a")
    private WebElement expandButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div/div/article/div[12]/div/div[2]/div[3]/div[1]/div[2]/div[2]")
    private WebElement plusCountVehicles;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div/div/article/div[12]/div/div[2]/div[7]/div[2]/div[2]")
    private WebElement countVehiclesText;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div/div/article/div[1]/h2")
    private WebElement hiddenText;

    public String getCountVehiclesText() {
        return countVehiclesText.getText();
    }

    public void clickPlusCountVehicles() {
        plusCountVehicles.click();
    }

    public void clickBattlePassGuideBattle() {
        battlePassGuideButton.click();
    }

    public void clickExpandButton() {
        System.out.println(countVehiclesText.getText());
        expandButton.click();
    }

    public boolean isSomeExtendButton() {
        return hiddenText.getText() != null;
    }

}
