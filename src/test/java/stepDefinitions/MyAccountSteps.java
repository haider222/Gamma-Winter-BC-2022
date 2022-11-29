package stepDefinitions;



import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EditMyAccountInfoPage;
import pages_sample.MyAccountPage;
import pages_sample.RegistrationPage;
import java.util.Map;



public class MyAccountSteps {


    private WebDriver driver;

    static MyAccountPage myAccountPage;
    static EditMyAccountInfoPage editMyAccountInfoPage;

    static RegistrationPage registrationPage;

    public MyAccountSteps() {
        this.driver = stepDefinitions.Hooks.driver;

        myAccountPage = PageFactory.initElements(stepDefinitions.Hooks.driver, MyAccountPage.class);
        editMyAccountInfoPage = PageFactory.initElements(stepDefinitions.Hooks.driver, EditMyAccountInfoPage.class);
        registrationPage = PageFactory.initElements(stepDefinitions.Hooks.driver, RegistrationPage.class);
    }

    @Given("I am on My Account page")
    public void iAmOnMyAccountPage() throws Exception {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
        Thread.sleep(2000);
    }

//    driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
//    public void iAmOnMyAccountPage() {
//    }

//    @Given("I am on my account register page")
//    public void iAmOnMyAccountRegisterPage() {
//    }
}


