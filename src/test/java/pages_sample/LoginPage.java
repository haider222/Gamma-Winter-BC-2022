package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID, using = "input-email")
    private WebElement loginEmail;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement loginPassword;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement loginButton;

    public WebElement getLoginEmail() {
        return loginEmail;
    }

    public WebElement getLoginPassword() {
        return loginPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void inputLoginEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void inputLoginPassword(String password){
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getUrl(){
        return "http://www.demoshop24.com/index.php?route=account/login";
    }

    public String getWebElementSelector(WebElement webElement){
        String text = webElement.toString();
        return text.substring(text.indexOf("selector:") + 10, text.length()-1);
    }
}
