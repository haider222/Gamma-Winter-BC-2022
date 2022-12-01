package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private WebElement city;

    @FindBy (how = How.CSS, using = "#input-postcode")
    private WebElement postCode;

    @FindBy (how = How.CSS, using = "#input-country")
    private WebElement country;

    @FindBy (how = How.CSS, using = "#input-zone")
    private WebElement region;

//    @FindBy (how = How.CSS, using = "#input[type=\"radio\"]")
//    private List<WebElement> defaultAddress;

    @FindBy (how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement continueButton;

//    @FindBy (how = How.CSS, using = "a.btn.btn-default")
//    private WebElement backButton;

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
    @FindBy (how = How.XPATH, using = "//*[@class=\"text-danger\" and contains(text(),\"state\")]")
    private WebElement textDangerRegion;
    @FindBy (how = How.CSS, using = "input[value='1'][type=\"radio\"]")
    private WebElement yesRadioButton;

    @FindBy (how = How.CSS, using = "input[value='0'][type=\"radio\"]")
    private WebElement noRadioButton;

    @FindBy (how = How.CSS, using = "#content>h2")
    private WebElement editPageHeading;



    public void clickContinueButton() {
        continueButton.click();
    }

    public WebElement getNoRadioButton(){ return noRadioButton; }

    public WebElement getEditPageHeading() { return editPageHeading; }

    public void fieldsAreAvailiable() {
        firstName.isDisplayed();
        lastName.isDisplayed();
        address1.isDisplayed();
        city.isDisplayed();
        postCode.isDisplayed();
        country.isDisplayed();
        region.isDisplayed();
    }
    public void clickYesRadioButton() {
        yesRadioButton.click();
    }
    public void chooseCountryOption(String mycountry) {
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText(mycountry);
    }
    public void chooseRegionOption(String region) {
        Select dropDownOne = new Select(this.region);
        dropDownOne.selectByVisibleText(region);
    }
    public void addCityAndPostcode(String city, String postcode){
        this.city.sendKeys(city);
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
    public String getPageUrl() {
        return "http://www.demoshop24.com/index.php?route=account/address";
    }
    public void inputDataExceptName() {
        lastName.sendKeys("Mozart");
        address1.sendKeys("Domgrasse 5");
        city.sendKeys("Vienna");
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText("Austria");
        Select dropDownTwo = new Select(region);
        dropDownTwo.selectByVisibleText("Wien");
    }
    public void errorNameText() {
        assertEquals("First Name must be between 1 and 32 characters!", textDangerFirstName.getText());
    }
    public void errorLastnameText() {
        assertEquals("Last Name must be between 1 and 32 characters!", textDangerLastName.getText());
    }
    public void errorAddressText() {
        assertEquals("Address must be between 3 and 128 characters!", textDangerAddress.getText());
    }
    public void errorCityText() {
        assertEquals("City must be between 2 and 128 characters!", textDangerLCity.getText());
    }
    public void errorCountryText() {
        assertEquals("Please select a country!", textDangerCountry.getText());
    }
    public void errorRegionText() {
        assertEquals("Please select a region / state!", textDangerRegion.getText());
    }
    public void inputDataExceptLastName() {
        firstName.sendKeys("Wolfgang");
        lastName.clear();
    }

    public void inputDataExceptAddress() {
        lastName.sendKeys("Mozart");
        address1.clear();
    }
    public void inputDataExceptCity() {
        address1.sendKeys("Domgrasse 5");
        city.clear();
    }
    public void inputDataExceptCountry() {
        city.sendKeys("Vienna");
        Select dropDown = new Select(country);
        dropDown.selectByIndex(0);
    }
    public void inputDataExceptRegion() {
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText("Austria");
    }

    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastName.getAttribute("value");
    }

    public String getCompanyValue() {
        return company.getAttribute("value");
    }

    public String getAddress1Value() {
        return address1.getAttribute("value");
    }

    public String getCityValue() {
        return city.getAttribute("value");
    }

    public String getPostCodeValue() {
        return postCode.getAttribute("value");
    }

    public String getCountryValue() {
        Select select = new Select(country);
        return select.getFirstSelectedOption().getText();
    }

    public String getRegionValue() {
        Select select = new Select(region);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getActualAddressData() {
        List<String>  actualInfoList;

        String firstName = getFirstNameValue();
        String lastName = getLastNameValue();
        String address = getAddress1Value();
        String city = getCityValue();
        String postCode = getPostCodeValue();
        String country = getCountryValue();
        String region = getRegionValue();

        actualInfoList = Arrays.asList(firstName, lastName, address, city, postCode, country, region);

//        System.out.println("actualInfoList:" + actualInfoList);
        return actualInfoList;
    }

}
