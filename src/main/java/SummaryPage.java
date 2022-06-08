import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{

     private By facility = By.id("facility");
     private By hospitalReadmission = By.id("hospital_readmission");
     private By healthcareProgram = By.id("program");
     private By visitDate = By.id("visit_date");
     private By comment = By.id("comment");
     private By goToHomepageBtn = By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");
     private By appointmentConfirmationMessage = By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

           public String getFacility(){
       return getDriver().findElement(facility).getText();
           }

           public boolean isApplyForHospitalReadmissionChecked(){
       return  getDriver().findElement(hospitalReadmission).isSelected();
           }
         public String getHealthcareProgram(){

        return getDriver().findElement(healthcareProgram).getText();
         }

         public String getVisitDate(){
         return getDriver().findElement(visitDate).getText();
         }
         public String getComment(){

        return getDriver().findElement(comment).getText();
         }

         public void clickGoToHomepageBtn(){
        getDriver().findElement(goToHomepageBtn).click();
         }

         public boolean isAppointmentMessageDisplayed(){
        return getDriver().findElement(appointmentConfirmationMessage).isDisplayed();
         }
}
