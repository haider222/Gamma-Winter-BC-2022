package stepDefinitions;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages_sample.*;

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

    static AddEditAddressPage addEditAddressPage;

    static  AddressListPage addressListPage;

    static List<String> updatedAccountInfo;


    public MyAccountSteps() {

        this.driver = stepDefinitions.Hooks.driver;

        myAccountPage = PageFactory.initElements(stepDefinitions.Hooks.driver, MyAccountPage.class);
        editMyAccountInfoPage = PageFactory.initElements(stepDefinitions.Hooks.driver, EditMyAccountInfoPage.class);
        registrationPage = PageFactory.initElements(stepDefinitions.Hooks.driver, RegistrationPage.class);
        loginPage = PageFactory.initElements(stepDefinitions.Hooks.driver, LoginPage.class);
        addEditAddressPage = PageFactory.initElements(stepDefinitions.Hooks.driver, AddEditAddressPage.class);
        addressListPage = PageFactory.initElements(stepDefinitions.Hooks.driver, AddressListPage.class);


    }

    @Given("I am on register page")
    public void iAmOnRegisterPage() {
        driver.get(registrationPage.getPageUrl());

    }


//    @When("I enter valid firstname")
//    public void iEnterValidFirstname() {
//        registrationPage.enterFirstName("John");
//    }
//
//    @Then("I enter valid lastname")
//    public void iEnterValidLastname() {
//        registrationPage.enterLastName("Doe");
//    }
//
//    @And("I enter valid Email")
//    public void iEnterValidEmail() {
//        registrationPage.enterEmail("john.doe@ggmaill.com");
//    }
//
//    @And("I enter valid telephone")
//    public void iEnterValidTelephone() {
//        registrationPage.enterTelephoneNumber("1234567");
//    }
//
//    @Then("I enter valid password")
//    public void iEnterValidPassword() {
//        registrationPage.enterPassword("qwerty");
//    }
//
//    @And("I enter valid password confirmation")
//    public void iEnterValidPasswordConfirmation() {
//        registrationPage.enterConfirmPassword("qwerty");
//    }


    @Given("I am logged in to the shop")
    public void iAmLoggedInToTheShop() throws Exception {

        driver.get(loginPage.getUrl());

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginEmail().getAttribute("id"))));
        loginPage.inputLoginEmail("Test_email@test.com");
//        loginPage.inputLoginEmail("mari.test@yahoo.com");

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
    public void iClickContinueButton() throws  Exception{
        registrationPage.clicContinuekButton();
        Thread.sleep(3000);
    }


    @When("I click My Account menu in form of table on the right of screen")
    public void iClickMyAccountMenuInFormOfTableOnTheRightOfScreen() throws Exception {
        myAccountPage.clickMyAccountTableLink();
        Thread.sleep(1000);

    }

    @And("I click \"Edit your account information\" on the left of screen under My Account title")
    public void iClickEditYourAccountInformationOnTheLeftOfScreenUnderMyAccountTitle() throws  Exception{
        myAccountPage.clickEditYourAccountInfoTextLink();
        Thread.sleep(1000);
    }


    @Then("I click Continue button to save data")
    public void iClickContinueButtonToSaveData() {
        editMyAccountInfoPage.clickContinueButton();
    }

    @Then("I change data in form fields:")
    public void iChangeDataInFormFields(Map<String, String> accountData) throws Exception {
        editMyAccountInfoPage.changeFirstName(accountData.get("firstName"));
        editMyAccountInfoPage.changeLastName(accountData.get("lastName"));
        editMyAccountInfoPage.changeEmail(accountData.get("eMail"));
        editMyAccountInfoPage.changeTelephone(accountData.get("telephone"));

        List<String> inputValues = new ArrayList<>(accountData.values());
        System.out.println("inputValues: " + inputValues);

        updatedAccountInfo = editMyAccountInfoPage.actualAccountInfo();

//        System.out.println("updatedAccountInfo: " + updatedAccountInfo);

        Thread.sleep(1000);
    }

    @When("I enter valid firstname {string}")
    public void iEnterValidFirstname(String firstname) {
        registrationPage.enterFirstName(firstname);
    }

    @Then("I enter valid lastname {string}")
    public void iEnterValidLastname(String lastname) {
        registrationPage.enterLastName(lastname);
    }

    @And("I enter valid Email {string}")
    public void iEnterValidEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @And("I enter valid telephone {string}")
    public void iEnterValidTelephone(String number) {
        registrationPage.enterTelephoneNumber(number);
    }

    @Then("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @And("I enter valid password confirmation {string}")
    public void iEnterValidPasswordConfirmation(String confpassword) {
        registrationPage.enterConfirmPassword(confpassword);
    }


    @And("I click on Register")
    public void iClickOnRegister() {
        myAccountPage.clickOnRegister();
    }

    @When("I am on Login page")
    public void iAmOnLoginPage() {
        loginPage.getUrl();
    }

    @Then("I enter registered Email {string}")
    public void iEnterRegisteredEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginEmail().getAttribute("id"))));
        loginPage.inputLoginEmail(email);
    }

    @And("I enter registered password {string}")
    public void iEnterRegisteredPassword(String password) {
        loginPage.inputLoginPassword(password);
    }

    @Then("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }
    @When("I am logged in with {string} and {string} and click Login")
    public void iAmLoggedInp(String email, String password) throws Exception {

        driver.get(loginPage.getUrl());

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginEmail().getAttribute("id"))));
        loginPage.inputLoginEmail(email);

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPage.getLoginPassword().getAttribute("id"))));
        loginPage.inputLoginPassword(password);


//        String path = loginPage.getWebElementSelector(loginPage.getLoginButton());
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
        loginPage.clickLoginButton();
        Thread.sleep(1000);
    }


    @And("I see filled inputs with registration info")
    public void iSeeFilledInputsWithRegistrationInfo() {
        editMyAccountInfoPage.textInNameInput();
//        editMyAccountInfoPage.textInLastNameInput();
//        editMyAccountInfoPage.textInEmailInput();
//        editMyAccountInfoPage.textInTelephoneInput();

    }

    @Then("I go to the My Account Information page")
    public void iGoToTheMyAccountInformationPage() {
        myAccountPage.clickEditYourAccountInfoTextLink();
    }

//    @And("I see message \'Success: Your account has been successfully updated.\' in My Account page")
//    public void iSeeMessageSuccessYourAccountHasBeenSuccessfullyUpdatedInMyAccountPage() {
//        System.out.println(myAccountPage.getAccountUpdateSuccessMessage().getText());
//        System.out.println(myAccountPage.getAccountUpdateSuccessMessage().getCssValue("background-color"));
//        System.out.println(myAccountPage.getAccountUpdateSuccessMessage().getCssValue("color"));
//
//    }

    @And("I see message {string} in My Account page")
    public void iSeeMessageInMyAccountPage(String expectedMessage) {
        String actualMessage = myAccountPage.getAccountUpdateSuccessMessage().getText();
        assertEquals(expectedMessage, actualMessage);

//        System.out.println("expectedMessage: " + expectedMessage);
//        System.out.println("actualMessage: " + actualMessage);
    }

    @And("I see message is in filled light-green box {string} with dark-green font {string}")
    public void iSeeMessageIsInFilledLightGreenBoxWithDarkGreenFont(String expectedBoxColor, String expectedFontColor) {
        String actualBoxColor = myAccountPage.getAccountUpdateSuccessMessage().getCssValue("background-color");
        String actualFontColor = myAccountPage.getAccountUpdateSuccessMessage().getCssValue("color");
        assertEquals(expectedBoxColor,actualBoxColor);
        assertEquals(expectedFontColor, actualFontColor);

//        System.out.println("expectedBoxColor:" + expectedBoxColor);
//        System.out.println("expectedFontColor:" + expectedFontColor);
//        System.out.println("actualBoxColor: " + actualBoxColor);
//        System.out.println("actualFontColor: " + actualFontColor);
    }

    @Then("I see previously updated data in form fields:")
    public void iSeePreviouslyUpdatedDataInFormFields(Map<String, String> accountData) throws Exception {

        List<String> expectedValues = new ArrayList<>(accountData.values());

        List<String> actualValues = new ArrayList<>(editMyAccountInfoPage.actualAccountInfo());

        assertTrue(actualValues.containsAll(expectedValues));

//        System.out.println("expectedValues: " + expectedValues);
//        System.out.println("actualValues: " + actualValues);

        Thread.sleep(2000);
    }

    @When("I click Edit Account menu, in form of table on the right of the screen")
    public void iClickEditAccountMenuInFormOfTableOnTheRightOfTheScreen() throws Exception{
        myAccountPage.clickEditAccountTableLink();
        Thread.sleep(1000);

    }

    @And("Click Back button to avoid changes")
    public void clickBackButtonToAvoidChanges() throws Exception{
        editMyAccountInfoPage.clickBackButton();
        Thread.sleep(2000);
    }


    @Then("I do not see any message on top of My Account title on My Account page")
    public void iDoNotSeeAnyMessageOnTopOfMyAccountTitleOnMyAccountPage() {
        assertFalse(myAccountPage.checkAccountUpdateSuccessMessageIsPresent());

    }

    @Then("I change data in form fields one more time:")
    public void iChangeDataInFormFieldsOneMoreTime(Map<String, String> accountData) throws Exception {
        editMyAccountInfoPage.changeFirstName(accountData.get("firstName"));
        editMyAccountInfoPage.changeLastName(accountData.get("lastName"));
        editMyAccountInfoPage.changeEmail(accountData.get("eMail"));
        editMyAccountInfoPage.changeTelephone(accountData.get("telephone"));

//        List<String> inputValues = new ArrayList<>(accountData.values());
//        System.out.println("inputValues: " + inputValues);

//        temporaryUpdatedAccountInfo = editMyAccountInfoPage.updatedAccountInfo();
//
//        System.out.println("temporaryUpdatedAccountInfo: " + temporaryUpdatedAccountInfo);

//        assertTrue(temporaryUpdatedAccountInfo.containsAll(inputValues));

        Thread.sleep(1000);
    }

    @Then("I do not see data from the last update")
    public void iDoNotSeeDataFromTheLastUpdate(Map<String, String> accountData) throws Exception {
        List<String> notExpectedValues = new ArrayList<>(accountData.values());
        List<String> actualValues = new ArrayList<>(editMyAccountInfoPage.actualAccountInfo());

        assertFalse(actualValues.containsAll(notExpectedValues));

//        System.out.println("notExpectedValues: " + notExpectedValues);
//        System.out.println("actualValues: " + actualValues);

        Thread.sleep(1000);

    }

    @And("Instead I see data from earlier update")
    public void insteadISeeDataFromEarlierUpdate(Map<String, String> accountData) throws Exception {
        List<String> expectedValues = new ArrayList<>(accountData.values());

        List<String> actualValues = new ArrayList<>(editMyAccountInfoPage.actualAccountInfo());

        assertTrue(actualValues.containsAll(expectedValues));

//        System.out.println("expectedValues: " + expectedValues);
//        System.out.println("actualValues: " + actualValues);

        Thread.sleep(2000);
    }


    @And("I see confirmation page with message {string}")
    public void iSeeConfirmationPageWithMessage(String messageTitle) {
        assertTrue(registrationPage.getAccountHasBeenCreatedMessageHeading().isDisplayed());
//        System.out.println(registrationPage.getAccountHasBeenCreatedMessageHeading().getText());
    }

    @And("I click continue button to complete registration")
    public void iClickContinueButtonToCompleteRegistration() {
        registrationPage.clickContinueAfterRegistrationButton();
    }

    @And("I see My Account heading in large font on the left side of the screen")
    public void iSeeMyAccountHeadingInLargeFontOnTheLeftSideOfTheScreen() {
        assertTrue(myAccountPage.getMyAccountHeading().isDisplayed());
    }
}
