package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[2]/div/div[2]/div[1]/button")
    private WebElement newPlayerButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[6]/form/fieldset[1]/div/input")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[6]/form/fieldset[2]/div/input")
    private WebElement nickNameField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[6]/form/fieldset[3]/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[6]/form/fieldset[4]/div/input")
    private WebElement passwordRepeatField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement agreeCheckBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[6]/form/fieldset[8]/button")
    private WebElement regButton;

    @FindBy(xpath = "//*[@id=\"id_eula\"]")
    private WebElement agreeCheckbox;


    public void clickNewPlayerButton() {
        newPlayerButton.click();
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputNickName(String nick) {
        nickNameField.sendKeys(nick);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
        passwordRepeatField.sendKeys(password);
    }

    public WebElement clickAgreeCheckBox() {
        return agreeCheckbox;
    }

    public void clickRegButton() {
        regButton.click();
    }
}
