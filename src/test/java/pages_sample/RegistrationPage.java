package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage {
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailInput;
    @FindBy(how = How.ID, using = "input-telephone")
    private WebElement telephoneInput;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordInput;
    @FindBy(how = How.ID, using = "input-confirm")
    private WebElement passwordConfirmInput;
    @FindBy(how = How.CSS, using = "input[value=\"0\"][type=\"radio\"]")
    private WebElement noRadioButton;
    @FindBy(how = How.CSS, using = "[name=\"agree\"]")
    private WebElement privacyPlolicyRadioButton;
    @FindBy(how = How.CSS, using = "input[value=\"Continue\"][type=\"submit\"]")
    private WebElement continueButton;
    @FindBy(how = How.CSS, using = "#content>h1")
    private WebElement accountHasBeenCreatedMessageHeading;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement continueAfterRegistrationButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"match\")]")
    private WebElement dangerTextConfPassword;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"Password\")]")
    private WebElement dangerTextPassword;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"Telephone\")]")
    private WebElement dangerTextTelephone;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"E-Mail\")]")
    private WebElement dangerTextEmail;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"Last Name\")]")
    private WebElement dangerTextLastname;
    @FindBy(how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"First Name\")]")
    private WebElement dangerTextFirstname;
    @FindBy(how = How.XPATH, using = "//*[text()=' Warning: You must agree to the Privacy Policy!']")
    private WebElement dangerTextPrivacyPolicy;
    public void errorTelephone() {
        assertEquals("Telephone must be between 3 and 32 characters!", dangerTextTelephone.getText());
    }
    public void errorPassword() {
        assertEquals("Password must be between 4 and 20 characters!", dangerTextPassword.getText());
    }
    public void errorConfPassword() {
        assertEquals("Password confirmation does not match password!", dangerTextConfPassword.getText());
    }
    public void validDataWrongEmail(String email) {
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Travolta");
        emailInput.sendKeys(email);
        telephoneInput.sendKeys("1234567");
        passwordInput.sendKeys("qwerty");
        passwordConfirmInput.sendKeys("qwerty");
        privatePolicyClick();
    }
    public void validDataWrongTelephone(String number) {
        emailInput.clear();
        emailInput.sendKeys("john.travolta@gmail.com");
        telephoneInput.clear();
        telephoneInput.sendKeys(number);
    }
    public void validDataWrongTelephoneTwo(String number) {
        telephoneInput.clear();
        telephoneInput.sendKeys(number);
    }
    public void validDataWrongPassword(String pass) {
        telephoneInput.clear();
        telephoneInput.sendKeys("1234567");
        passwordInput.clear();
        passwordInput.sendKeys(pass);
    }
    public void validDataWrongConfPassword(String pass) {
        passwordInput.clear();
        passwordInput.sendKeys("qwerty");
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(pass);
    }

    public void errorLastnameText() {
        assertEquals("Last Name must be between 1 and 32 characters!", dangerTextLastname.getText());
    }
    public void errorPrivacyPolicyText() {
        assertEquals("Warning: You must agree to the Privacy Policy!", dangerTextPrivacyPolicy.getText());
    }
    public void errorFirstnameText() {
        assertEquals("First Name must be between 1 and 32 characters!", dangerTextFirstname.getText());
    }
    public void errorEmailText() {
        assertEquals("E-Mail Address does not appear to be valid!", dangerTextEmail.getText());
    }
    public void errorTelephoneText() {
        assertEquals("Telephone must be between 3 and 32 characters!", dangerTextTelephone.getText());
    }
    public void errorConfPasswordText() {
        assertEquals("Password confirmation does not match password!", dangerTextConfPassword.getText());
    }
    public void errorPasswordText() {
        assertEquals("Password must be between 4 and 20 characters!", dangerTextPassword.getText());
    }
    public void inputDataExceptPrivacyPolicy() {
        firstNameInput.sendKeys("Albert");
        lastNameInput.sendKeys("Einstein");
        emailInput.sendKeys("a.einstein@physics.com");
        telephoneInput.sendKeys("123456789");
        passwordInput.sendKeys("E=mc2");
        passwordConfirmInput.sendKeys("E=mc2");
    }
    public void inputDataExceptConfPassword() {
        passwordInput.sendKeys("E=mc2");
        passwordConfirmInput.clear();
    }
    public void inputDataExceptPassword() {
        telephoneInput.sendKeys("123456789");
        passwordInput.clear();
    }
    public void inputDataExceptTelephone() {
        emailInput.sendKeys("a.einstein@physics.com");
        telephoneInput.clear();
    }
    public void inputDataExceptFirstname() {
        privatePolicyClick();
        firstNameInput.clear();
    }
    public void inputDataExceptLastname() {
        firstNameInput.sendKeys("Albert");
        lastNameInput.clear();
    }
    public void inputDataExceptEmail() {
        lastNameInput.sendKeys("Einstein");
        emailInput.clear();
    }




//    Your Account Has Been Created!

    public WebElement getAccountHasBeenCreatedMessageHeading(){
        return accountHasBeenCreatedMessageHeading;
    }

    public void clickContinueAfterRegistrationButton(){
        continueAfterRegistrationButton.click();
    }

    public String getPageUrl() {

        return "http://www.demoshop24.com/index.php?route=account/register";
    }


    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterTelephoneNumber(String number) {
        telephoneInput.sendKeys(number);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {

        passwordConfirmInput.sendKeys(password);
    }


    public void noRadioButtonIsSelected() {

        assertTrue(noRadioButton.isSelected());
    }

    public void privatePolicyClick() {
        assertFalse(privacyPlolicyRadioButton.isSelected());
        privacyPlolicyRadioButton.click();
    }

    public void clicContinuekButton() {
        continueButton.click();
    }



}
