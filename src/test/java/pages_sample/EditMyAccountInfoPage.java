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


}
