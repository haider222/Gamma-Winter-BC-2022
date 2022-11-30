package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages_sample.EditMyAccountInfoPage;
import pages_sample.LoginPage;
import pages_sample.MyAccountPage;
import pages_sample.RegistrationPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static stepDefinitions.Hooks.wait;


public class MyAccountSteps {


    private WebDriver driver;

    static MyAccountPage myAccountPage;
    static EditMyAccountInfoPage editMyAccountInfoPage;

    static RegistrationPage registrationPage;

    static LoginPage loginPage;


    public MyAccountSteps() {

        this.driver = stepDefinitions.Hooks.driver;

        myAccountPage = PageFactory.initElements(stepDefinitions.Hooks.driver, MyAccountPage.class);
        editMyAccountInfoPage = PageFactory.initElements(stepDefinitions.Hooks.driver, EditMyAccountInfoPage.class);
        registrationPage = PageFactory.initElements(stepDefinitions.Hooks.driver, RegistrationPage.class);
        loginPage = PageFactory.initElements(stepDefinitions.Hooks.driver, LoginPage.class);


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


    @Given("I am logged in to the shop")
    public void iAmLoggedInToTheShop() throws Exception {

        driver.get(loginPage.getUrl());

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginEmail().getAttribute("id"))));
        loginPage.inputLoginEmail("mari.test@yahoo.com");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginPassword().getAttribute("id"))));
        loginPage.inputLoginPassword("MariTest1");


//        String path = loginPage.getWebElementSelector(loginPage.getLoginButton());
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
        loginPage.clickLoginButton();
        Thread.sleep(1000);


    }

    @And("I check that no subscribe button is selected")
    public void iCheckThatNoSubscribeButtonIsSelected() {

        registrationPage.noRadioButtonIsSelected();
    }

    @When("I click navigation menu item My Account")
    public void iClickNavigationMenuItemMyAccount() throws Exception {

//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#top-links > ul > li.dropdown > a")));
        String text = myAccountPage.getNavMenuItemMyAccount().toString();
        String substr = text.substring(text.indexOf("#"), text.length() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(substr)));

//       driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
        myAccountPage.clickNavMenuItemMyAccount();

    }

    @And("I click sub menu item My Account")
    public void iClickSubMenuItemMyAccount() throws Exception {

//        String text = myAccountPage.getSubMenuItemMyAccount().toString();
//        String path= text.substring(text.indexOf("//"), text.length()-1);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(myAccountPage.
                getWebElementXPath(myAccountPage.getSubMenuItemMyAccount()))));
//        driver.findElement(xpath).click();

        myAccountPage.clickSubMenuItemMyAccount();
        Thread.sleep(2000);

    }

    @Then("I see menu in form of table column on the right side of screen")
    public void iSeeMenuInFormOfTableColumnOnTheRightSideOfScreen(List<String> listExpected) {
        System.out.println("listExpected: " + listExpected);
        List<String> listTableOnScreen = new ArrayList<>();
        for (WebElement tableItem : myAccountPage.getListTableLinks()) {
            assertTrue(tableItem.isDisplayed());
            listTableOnScreen.add(tableItem.getText());
//            System.out.println(tableItem.getText());
        }
        System.out.println("listTableOnScreen: " + listTableOnScreen);
        assertTrue(listExpected.containsAll(listTableOnScreen));
    }

    @Then("I click on the Privacy Policy")
    public void iClickOnThePrivacyPolicy() {
        registrationPage.privatePolicyClick();
    }


    @And("I click continue button")
    public void iClickContinueButton() {
        registrationPage.clicContinuekButton();
    }


    @When("I click My Account menu in form of table on the right of screen")
    public void iClickMyAccountMenuInFormOfTableOnTheRightOfScreen() throws Exception {
        myAccountPage.clickMyAccountTableLink();
        Thread.sleep(2000);

    }

    @And("I click \"Edit your account information\" on the left of screen under My Account title")
    public void iClickEditYourAccountInformationOnTheLeftOfScreenUnderMyAccountTitle() throws  Exception{
        myAccountPage.clickEditYourAccountInfoTextLink();
        Thread.sleep(2000);
    }


    @Then("I click Continue button to save changes")
    public void iClickContinueButtonToSaveChanges() {
        editMyAccountInfoPage.clickContinueButton();
    }

    @Then("I see <oldFirstName> in First Name field and change it to <newFirstName>")
    public void iSeeOldFirstNameInFirstNameFieldAndChangeItToNewFirstName( String oldFirstName, String newFirstName) {

    }
}
