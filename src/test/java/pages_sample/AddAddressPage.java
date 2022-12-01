package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddAddressPage {
    @FindBy (how = How.CSS, using = "#input-firstname")
    private WebElement firstName;

    @FindBy (how = How.CSS, using = "#input-lastname")
    private WebElement lastName;

    @FindBy (how = How.CSS, using = "#input-company")
    private WebElement company;

    @FindBy (how = How.CSS, using = "#input-address-1")
    private WebElement address1;

    @FindBy (how = How.CSS, using = "#input-address-2")
    private WebElement address2;

    @FindBy (how = How.CSS, using = "#input-city")
    private WebElement cityy;

    @FindBy (how = How.CSS, using = "#input-postcode")
    private WebElement postCode;

    @FindBy (how = How.CSS, using = "#input-country")
    private WebElement country;

    @FindBy (how = How.CSS, using = "#input-zone")
    private WebElement zone;

    @FindBy (how = How.CSS, using = "#input[type=\"radio\"]")
    private List<WebElement> defaultAddress;

    @FindBy (how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement continueButton;

    @FindBy (how = How.CSS, using = "a.btn.btn-default")
    private WebElement backButton;

    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and starts-with(text(),\"First Name\")]")
    private WebElement textDangerFirstName;

    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and starts-with(text(),\"Last Name\")]")
    private WebElement textDangerLastName;

    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and starts-with(text(),\"Address\")]")
    private WebElement textDangerAddress;

    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and starts-with(text(),\"City\")]")
    private WebElement textDangerLCity;

    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"country\")]")
    private WebElement textDangerCountry;
    @FindBy (how = How.CSS, using = "input[value='1']")
    private WebElement yesRadioButton;
    public void clickContinueButton() {
        continueButton.click();
    }
    public void fieldsAreAvailiable() {
        firstName.isDisplayed();
        lastName.isDisplayed();
        address1.isDisplayed();
        cityy.isDisplayed();
        postCode.isDisplayed();
        country.isDisplayed();
        zone.isDisplayed();
    }
    public void clickYesRadioButton() {
        yesRadioButton.click();
    }
    public void chooseCountryOption(String mycountry) {
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText(mycountry);
    }
    public void chooseRegionOption(String region) {
        Select dropDownOne = new Select(zone);
        dropDownOne.selectByVisibleText(region);
    }
    public void addCityAndPostcode(String city, String postcode){
        cityy.sendKeys(city);
        postCode.sendKeys(postcode);
    }
    public void addAddres(String address) {
        address1.sendKeys(address);
    }
    public void addName(String firstname) {
        firstName.sendKeys(firstname);

    }
    public void addLastname(String lastname) {
        lastName.sendKeys(lastname);
    }





}
