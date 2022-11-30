package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    @FindBy(how = How.ID, using = "input-firstname")
    WebElement firstNameInput;
    @FindBy(how = How.ID, using = "input-lastname")
    WebElement lastNameInput;
    @FindBy(how = How.ID, using = "input-email")
    WebElement emailInput;
    @FindBy(how = How.ID, using = "input-telephone")
    WebElement telephoneInput;
    @FindBy(how = How.ID, using = "input-password")
    WebElement passwordInput;
    @FindBy(how = How.ID, using = "input-confirm")
    WebElement passwordConfirmInput;
    @FindBy(how = How.CSS, using = "input[value=\"0\"][type=\"radio\"]")
    WebElement noRadioButton;
    @FindBy(how = How.CSS, using = "[name=\"agree\"]")
    WebElement privacyPlolicyRadioButton;
    @FindBy(how = How.CSS, using = "input[value=\"Continue\"][type=\"submit\"]")
    WebElement continueButton;

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
