package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    @FindBy(how = How.CSS, using = "[.radio-inline:nth-child(2)]")
    WebElement noRadioButton;






}
