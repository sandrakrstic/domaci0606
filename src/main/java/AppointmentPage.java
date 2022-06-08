import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage {

    private By facility = By.id("combo_facility");
    private By applyForHospitalReadmissionCheck = By.id("chk_hospotal_readmission");
    private By healthcareProgram = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");



    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void selectFacility()  {
        getDriver().findElement(facility).click();
        Select selectFacility = new Select(getDriver().findElement(this.facility));
        selectFacility.selectByValue("Tokyo CURA Healthcare Center");

    }

    public void applyForHospitalReadmission() {
         getDriver().findElement(applyForHospitalReadmissionCheck).click();

    }

    public void selectHealthcareProgram()  {
        Select selectHealthcareProgram = new Select(getDriver().findElement(this.healthcareProgram));
        selectHealthcareProgram.selectByValue("Medicare");


    }

    public void enterVisitDate(String visitDate){
         getDriver().findElement(this.visitDate).sendKeys(visitDate);
    }

    public void enterComment(String comment){
        getDriver().findElement(this.comment).sendKeys(comment);
    }

    public void clickBookAppointment(){
        getDriver().findElement(bookAppointmentBtn).click();
    }

    public boolean isFormPresented(){
        List<WebElement> elements = getDriver().findElements(By.id("appointment"));
        if(elements.size()==0) {
            return false;
        }
        return true;
    }
}


