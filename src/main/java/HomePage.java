import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By makeAppointment = By.id("btn-make-appointment");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickMakeAppointment(){
        getDriver().findElement(makeAppointment).click();
    }
}
