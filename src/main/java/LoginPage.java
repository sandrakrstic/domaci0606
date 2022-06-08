import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginBtn = By.id("btn-login");
    private By infoMessage = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterUsername(String username) {
        getDriver().findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        getDriver().findElement(this.password).sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    public boolean isLoginButtonEnabled (){
        return getDriver().findElement(loginBtn).isEnabled();
    }

     public void clickLoginButton() {
        getDriver().findElement(loginBtn).click();
     }

     public String getInfoMessage() {
        return getDriver().findElement(infoMessage).getText();
     }

}
