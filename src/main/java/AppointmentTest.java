import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private  SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Sandra\\kurs_qa\\hromdriver\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver,driverWait);
        appointmentPage = new AppointmentPage(driver,driverWait);
        summaryPage = new SummaryPage(driver,driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @BeforeMethod
    public void beforeEachTest() {
        driver.navigate().refresh();
    }

   @Test (priority = 1)
    public void verifyThatMakeAppointmentBtnWorks(){
       homePage.clickMakeAppointment();
   }

   @Test (priority = 2)
    public void verifyThatLoginWorks(){
   loginPage.login("John Doe", "ThisIsNotAPassword");
   Assert.assertTrue(loginPage.isLoginButtonEnabled());
   loginPage.clickLoginButton();
   Assert.assertTrue(appointmentPage.isFormPresented());

   }

   @Test (priority = 3)
    public void setAppointmentTest() {
      appointmentPage.selectFacility();
      appointmentPage.applyForHospitalReadmission();
      appointmentPage.selectHealthcareProgram();
      appointmentPage.enterVisitDate("21/09/2022");
      appointmentPage.enterComment("my comment");
      appointmentPage.clickBookAppointment();
      Assert.assertTrue(summaryPage.isAppointmentMessageDisplayed());

}

   @Test (priority = 4)
    public void checkingFacility() {
       Assert.assertEquals(summaryPage.getFacility(), "Tokyo CURA Healthcare Center");

   }

    @Test (priority = 5)
     public void checkingIsApplyForHospitalReadmissionChecked() {
        Assert.assertTrue(summaryPage.isApplyForHospitalReadmissionChecked());
       }

    @Test (priority = 6)
    public void checkingHealthcareProgram(){
        Assert.assertEquals(summaryPage.getHealthcareProgram(),"Medicare");
    }

    @Test(priority = 7)
    public void checkingVisitDate(){
        Assert.assertEquals(summaryPage.getVisitDate(),"21/09/2022" );
    }

    @Test (priority = 8)
    public void checkingComment(){
        Assert.assertEquals(summaryPage.getComment(), "my comment");
    }

   }


