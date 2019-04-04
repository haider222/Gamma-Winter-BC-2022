package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on Enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter: \"([^\"]*)\"$")
    public void iEnterEnter(String arg0) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(arg0);
    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

//    @Then("^I see alert with result: \"([^\"]*)\"$")
//    public void iSeeAlertWithResult(String arg0) throws Throwable {
//        Alert alert = driver.switchTo().alert();
//        assertEquals(arg0, alert.getText());
//    }

    @Then("^I see alert with message: \"(.*)\"$")
    public void iSeeAlertWithResult(String arg0) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(arg0, alert.getText());
    }
}
