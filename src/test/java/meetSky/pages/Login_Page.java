package meetSky.pages;

import meetSky.utiliies.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BasePage {

    @FindBy (css = "[id = 'user']")
    public WebElement userNameInput;

    @FindBy (css = "[id = 'password']")
    public WebElement passwordinput;

    @FindBy (css = "[href=\"http://app.meetsky.net/index.php/login\"]")
    public WebElement clickLoginButton;

    @FindBy (css = "[class = 'warning wrongPasswordMsg']")
    public WebElement warningMessage;

    public void login (String userName, String password){

        userNameInput.sendKeys(userName);
        passwordinput.sendKeys(password, Keys.ENTER);
    }

    public void clickLogin(){
        clickLoginButton.click();
    }

    public void warningMassage(){
        String warningMessageText = warningMessage.getText();
    }



}
