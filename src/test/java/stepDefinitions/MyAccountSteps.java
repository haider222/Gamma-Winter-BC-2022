package stepDefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import pages_sample.EditMyAccountInfoPage;
import pages_sample.MyAccountPage;

import static org.junit.Assert.*;

public class MyAccountSteps {


    private WebDriver driver;

    static MyAccountPage myAccountPage;
    static EditMyAccountInfoPage editMyAccountInfoPage;

    public MyAccountSteps(WebDriver driver) {
        this.driver = Hooks.driver;

        myAccountPage = PageFactory.initElements(Hooks.driver, MyAccountPage.class);
        editMyAccountInfoPage = PageFactory.initElements(Hooks.driver, EditMyAccountInfoPage.class);
    }

    @Given("^I am on My Account page$")
    public void iAmOnMyAccountPage() {
    }
}

