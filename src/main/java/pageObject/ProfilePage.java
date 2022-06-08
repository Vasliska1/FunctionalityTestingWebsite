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

public class ProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h2")
    private WebElement nicknameField;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div[3]/ul/li[1]/a/span")
    private WebElement linkToPersonalArea;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[2]/p[1]")
    private WebElement mail;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div[3]/div/div/a")
    private WebElement changeNicknameButton;

    @FindBy(xpath = "//*[@id=\"common_menu\"]/div/div[1]/div[1]/a[2]/span[3]")
    private WebElement userMenuHolder;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[3]/div/div[2]/div/div/a")
    private WebElement subscribeLink;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/fieldset/ul/li[1]/input")
    private WebElement checkboxAccount;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/fieldset/ul/li[2]/input")
    private WebElement checkboxEvents;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[3]/div/div[3]/div/div/a")
    private WebElement securityData;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[3]/div/div[4]/div/ul/li[2]/a")
    private WebElement myCards;

    @FindBy(xpath = "//span[contains(text(), \"Активировать код Wargaming\")]")
    private WebElement linkToBonusCode;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/a")
    private WebElement passwordEditorButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/form/div/fieldset[1]/div[1]/input")
    private WebElement passwordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/form/div/fieldset[2]/div/input")
    private WebElement passwordRepeatInput;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/form/div/fieldset[3]/button")
    private WebElement passwordSubmit;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/p")
    private WebElement successChangePassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/fieldset/a")
    private WebElement finishChanges;

    @FindBy(xpath =  "//a[@class=\"cm-footer-logout_link js-cm-event js-cm-link-ignore-target\"]")
    private WebElement logOutButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/fieldset/div[2]/button")
    private WebElement saveSubscribeButton;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }

    public void clickLogOutButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logOutButton.click();
    }

    public void clickSaveSubscribeButton(){
        saveSubscribeButton.click();
    }

    public String getNickname() {
        return nicknameField.getText();
    }

    public void clickUserMenuHolder(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"common_menu\"]/div/div[1]/div[1]/a[2]/span[3]")));
        userMenuHolder.click();
    }

    public void goToPersonalArea() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div[3]/ul/li[1]/a/span")));
        linkToPersonalArea.click();
    }

    public String getMessageSuccessChangePassword(){
        return successChangePassword.getText();
    }

    public String getMail() {
        return mail.getText();
    }

    public void clickChangeNickName(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        changeNicknameButton.click();
    }

    public void clickSubscribe(){
        subscribeLink.click();
    }

    public void setCheckboxAccount(){
        checkboxAccount.click();
    }

    public void setCheckboxEvents(){
        checkboxEvents.click();
    }

    public boolean getStatusCheckboxAccount(){
        return checkboxAccount.isSelected();
    }

    public boolean getStatusCheckboxEvents(){
        return checkboxEvents.isSelected();
    }

    public void clickSecurityData() {
        securityData.click();
    }

    public void clickMyCards() {
        myCards.click();
    }

    public void clickBonusCode() {
        linkToBonusCode.click();
    }

    public void clickPasswordEditorButton(){
        passwordEditorButton.click();
    }

    public void changePassword(String password) {
        passwordInput.sendKeys(password);
        passwordRepeatInput.sendKeys(password);
    }

    public void submitPassword() {
        passwordSubmit.click();
    }

    public void clickFinishChange(){
        finishChanges.click();
    }

    public boolean isAccountButtonExist() {
        try {
            driver.findElement(By.xpath("//*[@id=\"common_menu\"]/div/div[1]/div[1]/a[2]/span[3]"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
