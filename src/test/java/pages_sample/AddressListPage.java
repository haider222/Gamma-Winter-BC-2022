package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AddressListPage {
    @FindBy(how= How.CSS, using = ".table.table-bordered.table-hover>tbody")
    private List<WebElement> addressList;

    @FindBy (how = How.CSS, using = "a.btn.btn-primary")
    private WebElement newAddressButton;

    @FindBy (how = How.CSS, using = "a.btn.btn-default")
    private WebElement backButton;

// To be used for Edit button  a.btn.btn-info
// To be used for Delete button  a.btn.btn-danger
    public void clickNewAddressButton() {
        newAddressButton.click();
    }


//    public void clickAddressEditButton(String name, String job) {
//        WebElement personInList = new RemoteWebElement() {
//        };
//        for (WebElement person : listOfPeople) {
//            if (person.getText().contains(name) && person.getText().contains(job)) {
//                personInList = person.findElement(By.cssSelector(".editbtn"));
//            }
//        }
//        personInList.click();
//
//    }





}
