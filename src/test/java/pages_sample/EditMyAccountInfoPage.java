package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Arrays;
import java.util.List;

public class EditMyAccountInfoPage {

//    @FindBy(how = How.ID, using = "#input-firstname")
//    private WebElement inputFirstName;
//    @FindBy(how = How.ID, using = "#input-lastname")
//    private WebElement inputLastName;
//    @FindBy(how = How.ID, using = "#input-email")
//    private WebElement inputEmail;
//    @FindBy(how = How.ID, using = "#input-telephone")
//    private WebElement inputTelephone;

    @FindBy(how = How.CSS, using = "input[name=\"firstname\"")
    private WebElement inputFirstName;

    @FindBy(how = How.CSS, using = "input[name=\"lastname\"]")
    private WebElement inputLastName;


    @FindBy(how = How.CSS, using = "input[name=\"email\"]")
    private WebElement inputEmail;

    @FindBy(how = How.CSS, using = "input[name=\"telephone\"]")
    private WebElement inputTelephone;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//a[text()=\"Back\"]")
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


    public void changeFirstName(String firstName){
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }
    public void changeLastName(String lastName){
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }
    public void changeEmail(String eMail){
        inputEmail.clear();
        inputEmail.sendKeys(eMail);
    }
    public void changeTelephone(String telephone){
        inputTelephone.clear();
        inputTelephone.sendKeys(telephone);
    }

    public String getFirstNameValue(){
        return inputFirstName.getAttribute("value");
    }

    public String getLastNameValue(){
        return inputLastName.getAttribute("value");
    }
    public String getEmailValue(){
        return inputEmail.getAttribute("value");
    }

    public String getTelephoneValue(){
        return inputTelephone.getAttribute("value");
    }



    public List<String> actualAccountInfo() {
        List<String>  updatedInfoList;

            String firstName = getFirstNameValue();
            String lastName = getLastNameValue();
            String eMail = getEmailValue();
            String telephone = getTelephoneValue();

        updatedInfoList = Arrays.asList(firstName, lastName, eMail, telephone);

//        System.out.println("updatedInfoList:" + updatedInfoList);
        return updatedInfoList;
    }


}
