package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;

public class MyAccountPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[@class=\"dropdown open\"]/a/span[text()=\"My Account\"]")
    private WebElement topMenuMyAccount;

    @FindBy(how = How.CSS, using = "div.list-group")
    private List<WebElement> listTableLinks;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"My Account\"]")
    private WebElement myAccountTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Edit Account\"]")
    private WebElement editAccountTableLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[text()=\"Password\"]")
    private WebElement passwordTableLink;

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

}
