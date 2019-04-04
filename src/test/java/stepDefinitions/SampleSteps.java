package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @When("^I enter name: (.*)$")
    public void iEnterName2(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.cssSelector(".w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @And("^I should see some text$")
<<<<<<< Updated upstream
    public void iShouldSeeSomeText() {
=======
    public void iShouldSeeSomeText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
>>>>>>> Stashed changes
        assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

    @When("^I open styles page$")
<<<<<<< Updated upstream
    public void iOpenStylesPage() {
=======
    public void iOpenStylesPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
>>>>>>> Stashed changes
        driver.get("https://kristinek.github.io/site/examples/styles");
    }

    @Then("^correct header is seen$")
<<<<<<< Updated upstream
    public void correctHeaderIsSeen() {
        String actualText = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Lorem ipsum", actualText);
    }

    @Given("^I open action page$")
    public void iOpenActionPage() {
=======
    public void correctHeaderIsSeen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.className("w3-jumbo")).isDisplayed());
        assertEquals("Lorem ipsum", driver.findElement(By.className("w3-jumbo")).getText());
        System.out.println(driver.findElement(By.className("w3-jumbo")).isDisplayed());
    }

    @Given("^I open action page$")
    public void iOpenActionPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
>>>>>>> Stashed changes
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @And("^I enter number (\\d+) in number field$")
<<<<<<< Updated upstream
    public void iEnterNumberInNumberField(String num) {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(num);
    }

    @And("^I click Result$")
    public void iClickResult() {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see text: \"(.+)\"$")
    public void iSeeText(String expectedText) throws Throwable {
        String actualText = driver.findElement(By.id("result_number")).getText();
        assertEquals(expectedText, actualText);
    }
=======
    public void iEnterNumberInNumberField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(arg0);
    }

    @And("^I click Result$")
    public void iClickResult() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

//    @Then("^I see text: \"([^\"]*)\"(\\d+)\"([^\"]*)\"$")
//    public void iSeeText(String arg0, String arg1, String arg2) throws Throwable {
//        String expected = arg0 + "\"" + arg1 + "\"";
//        assertEquals(expected, driver.findElement(By.id("result_number")).getText());
//    }

    @Then("^I see text: \"(.*)\"$")
    public void iSeeText(String expected) throws Throwable {
        String actual = driver.findElement(By.id("result_number")).getText();
        assertEquals(expected, actual);
    }

    @And("^I enter number <number> in number field$")
    public void iEnterNumberNumberInNumberField(String num) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(num);
    }


>>>>>>> Stashed changes
}
