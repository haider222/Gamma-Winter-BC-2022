package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class MyAccountPage {

    @FindBy(how = How.CSS, using = "#top-links > ul > li.dropdown > a")
    private WebElement navMenuItemMyAccount;

    @FindBy(how = How.XPATH, using = "//ul[@class=\"list-inline\"]/li/ul/li/a[contains(text(), \"My Account\")]")
    private WebElement subMenuItemMyAccount;
    @FindBy(how = How.CSS, using = "div.list-group>a")
    private List<WebElement> listTableLinks;
    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"My Account\"]")
    private WebElement myAccountTableLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Edit Account\"]")
    private WebElement editAccountTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Password\"]")
    private WebElement passwordTableLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Address Book\"]")
    private WebElement addressBookTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Wish List\"]")
    private WebElement wishListTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Order History\"]")
    private WebElement orderHistoryTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Downloads\"]")
    private WebElement downloadsTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Recurring payments\"]")
    private WebElement recurringPaymentsTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Reward Points\"]")
    private WebElement rewardPointsTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Returns\"]")
    private WebElement returnsTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Transactions\"]")
    private WebElement transactionsTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Newsletter\"]")
    private WebElement newsLetterTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Logout\"]")
    private WebElement logoutTableLink;
    @FindBy(how = How.XPATH, using = "//a[text()=\"Edit your account information\"]")
    private WebElement editYourAccountInfoTextLink;
    @FindBy(how = How.XPATH, using = "//a[text()=\"Modify your address book entries\"]")
    private WebElement modifyYourAddressBookTextLink;
    @FindBy(how = How.CSS, using = "//*[text()='Register']")
    private WebElement registerButton;

    @FindBy(how = How.CSS, using = "#account-account>.alert-success")
    private WebElement accountUpdateSuccessMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[text()=\"My Account\"]")
    private WebElement myAccountHeading;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"account-account\"]/div[@class=\"alert alert-success alert-dismissible\"]")
//    private WebElement accountUpdateSuccessMessage;


    public WebElement getMyAccountHeading(){ return myAccountHeading; }

    public void clickOnRegister() {
        registerButton.click();
    }

    public void clickNavMenuItemMyAccount(){
        navMenuItemMyAccount.click();
    }

    public void clickSubMenuItemMyAccount(){
        subMenuItemMyAccount.click();
    }

    public void  clickEditYourAccountInfoTextLink(){
        editYourAccountInfoTextLink.click();
    }

    public void  clickModifyYourAddressBookTextLink(){
        modifyYourAddressBookTextLink.click();
    }

    public void  clickMyAccountTableLink(){
        myAccountTableLink.click();
    }

    public void  clickEditAccountTableLink(){
        editAccountTableLink.click();
    }

    public void  clickAddressBookTableLink(){
        addressBookTableLink.click();
    }

    public WebElement getNavMenuItemMyAccount() {
        return navMenuItemMyAccount;
    }

    public WebElement getSubMenuItemMyAccount() {
        return subMenuItemMyAccount;
    }

    public WebElement getAccountUpdateSuccessMessage(){
        return accountUpdateSuccessMessage;
    }

//    public String getWebElementSelector(WebElement webElement){
//        String text = webElement.toString();
//        return text.substring(text.indexOf("selector:") + 10, text.length()-1);
//
//    }

    public String getWebElementXPath(WebElement webElement){
        String text = webElement.toString();
        return text.substring(text.indexOf("xpath:") + 7, text.length()-1);
    }

    public List<WebElement> getListTableLinks(){
        return listTableLinks;
    }

    public boolean checkAccountUpdateSuccessMessageIsPresent() {

        List<WebElement> noElementFound = driver.findElements(By.cssSelector("#account-account>.alert-success"));
        if (noElementFound.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
