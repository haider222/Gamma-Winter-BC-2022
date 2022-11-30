package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EditMyAccountInfoPage;
import pages_sample.MyAccountPage;
import pages_sample.RegistrationPage;

public class MyAccountSteps {


    private WebDriver driver;

    static MyAccountPage myAccountPage;


    static RegistrationPage registrationPage;

    public MyAccountSteps() {
        this.driver = stepDefinitions.Hooks.driver;

        myAccountPage = PageFactory.initElements(stepDefinitions.Hooks.driver, MyAccountPage.class);


        registrationPage = PageFactory.initElements(stepDefinitions.Hooks.driver, RegistrationPage.class);
    }


    @Given("I am on register page")
    public void iAmOnRegisterPage() {
        driver.get(registrationPage.getPageUrl());
    }


    @When("I enter valid firstname")
    public void iEnterValidFirstname() {
        registrationPage.enterFirstName("John");
    }

    @Then("I enter valid lastname")
    public void iEnterValidLastname() {
        registrationPage.enterLastName("Doe");
    }

    @And("I enter valid Email")
    public void iEnterValidEmail() {
        registrationPage.enterEmail("john.doe@ggmaill.com");
    }

    @And("I enter valid telephone")
    public void iEnterValidTelephone() {
        registrationPage.enterTelephoneNumber("1234567");
    }

    @Then("I enter valid password")
    public void iEnterValidPassword() {
        registrationPage.enterPassword("qwerty");
    }

    @And("I enter valid password confirmation")
    public void iEnterValidPasswordConfirmation() {
        registrationPage.enterConfirmPassword("qwerty");
    }

    @And("I check that no subscribe button is selected")
    public void iCheckThatNoSubscribeButtonIsSelected() {

        registrationPage.noRadioButtonIsSelected();
    }

    @Then("I click on the Privacy Policy")
    public void iClickOnThePrivacyPolicy() {
        registrationPage.privatePolicyClick();
    }


    @And("I click continue button")
    public void iClickContinueButton() {
        registrationPage.clicContinuekButton();
    }


}


