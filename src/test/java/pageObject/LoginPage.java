package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div[1]/span/form/div/span[1]/fieldset/div[1]/input")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div[1]/span/form/div/fieldset[1]/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div[1]/span/form/div/fieldset[2]/span[1]/button")
    private WebElement submit;


    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submit.click();
    }
}
