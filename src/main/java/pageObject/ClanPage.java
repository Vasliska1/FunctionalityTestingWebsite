package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClanPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//h1[@class=\"clan-heading\"]")
    private WebElement title;

    @FindBy(xpath = "//a[@class=\"nav-submenu_link\"]")
    private WebElement logo;

    @FindBy(xpath = "//a[@class=\"old-button\"]")
    private WebElement findClan;

    @FindBy(xpath = "//input[@class=\"clan-search_input js-clan-search\"]")
    private WebElement inputFindClan;

    @FindBy(xpath = "//input[@class=\"clan-search_btn\"]")
    private WebElement buttonSearch;

    public ClanPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    public String getTitle(){
        return title.getText();
    }

    public void clickLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nav-submenu_link\"]")));
        logo.click();
    }

    public void clickFindClan() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"old-button\"]")));
        findClan.click();
    }

    public void setInputFindClan(){
        inputFindClan.sendKeys("As");
    }

    public void submit(){
        buttonSearch.click();
    }
}
