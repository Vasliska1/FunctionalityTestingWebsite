package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MediaPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//h2[@class=\"b-composite-heading_title\"]")
    private WebElement title;

    @FindBy(xpath = "//a[@class=\"nav-submenu_link\"]")
    private WebElement logo;

    @FindBy(xpath = "//span[@class=\"b-icon-video\"]")
    private List<WebElement> videos;

    @FindBy(xpath = "//a[@class=\"b-img-signature_link\"]")
    private List<WebElement> arts;


    @FindBy(xpath = "//div[@class=\"b-content\"]/p/a")
    private WebElement link;


    public MediaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    public String getTitle(){
        return title.getText();
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nav-submenu_link\"]")));
        logo.click();
    }

    public void clickVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b-icon-video\"]")));
        videos.get(0).click();
    }

    public void clickArt(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"b-img-signature_link\"]")));
        arts.get(7).click();
    }

    public void clickModel(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b-img-signature_img\"]")));
        arts.get(13).click();
    }

    public void clickLink() {
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
    }

    public void clickComic(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b-img-signature_img\"]")));
        arts.get(19).click();
    }

}
