package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditMyAccountInfoPage {

    @FindBy(how = How.ID, using = "#input-firstname")
    private WebElement inputFirstName;

    @FindBy(how = How.ID, using = "#input-lastname")
    private WebElement inputLastName;

    @FindBy(how = How.ID, using = "#input-email")
    private WebElement inputEmail;

    @FindBy(how = How.ID, using = "#input-telephone")
    private WebElement inputTelephone;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement continueButton;

    @FindBy(how = How.CSS, using = "//a[text()=\"Back\"]")
    private WebElement backButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/fieldset/div[@class=\"form-group required has-error\"]/" +
            "div[@class=\"col-sm-10\"]/div[@class=\"text-danger\" and contains(text(), \"First Name\")]")
    private WebElement dangerTextFirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/fieldset/div[@class=\"form-group required has-error\"]/" +
            "div[@class=\"col-sm-10\"]/div[@class=\"text-danger\" and contains(text(), \"Last Name\")]")
    private WebElement dangerTextLastName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/fieldset/div[@class=\"form-group required has-error\"]/" +
            "div[@class=\"col-sm-10\"]/div[@class=\"text-danger\" and contains(text(), \"E-Mail\")]")
    private WebElement dangerTextEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/fieldset/div[@class=\"form-group required has-error\"]/" +
            "div[@class=\"col-sm-10\"]/div[@class=\"text-danger\" and contains(text(), \"Telephone\")]")
    private WebElement dangerTextTelephone;


    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickBackButton() {
        backButton.click();
    }
    public void textInNameInput() {
        inputFirstName.getText();
    }
    public void textInLastNameInput() {
        inputLastName.getText();
    }
    public void textInEmailInput() {
        inputEmail.getText();
    }
    public void textInTelephoneInput() {
        inputTelephone.getText();
    }



}
