package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Map;

public class AddressListPage {
    @FindBy(how= How.CSS, using = ".table.table-bordered.table-hover>tbody")
    private List<WebElement> addressList;

    @FindBy (how = How.CSS, using = "a.btn.btn-primary")
    private WebElement newAddressButton;

    @FindBy (how = How.CSS, using = "a.btn.btn-default")
    private WebElement backButton;

// To be used for Edit button  a.btn.btn-info    or   //a[@class="btn btn-info"]    //td[text()='Adresas1' and text()='Imone']
// To be used for Delete button  a.btn.btn-danger
    public void clickNewAddressButton() {
        newAddressButton.click();
    }
    public void clickBackButton() {
        backButton.click();
    }


    public String getAddressEditButtonXPath(Map<String, String> accountData) throws Exception {
        String name = "text()=\"" + accountData.get("firstName") + " " + accountData.get("lastName") + "\"";
        String address = "text()=\"" + accountData.get("address") + "\"";
        String city = "text()=\"" + accountData.get("city") + " " + accountData.get("postCode") + "\"";
        String country = "text()=\"" + accountData.get("country") + "\"";
        String region = "text()=\"" + accountData.get("region") + "\"";

        String search = String.join(" and ", name, address, city,  country, region);
        String xPath = "//td[" + search + "]/following-sibling::td/a[@class=\"btn btn-info\"]";


        System.out.println(String.format("%s %s %s %s %s",name, address, city, country, region));
        System.out.println(search);
        System.out.println(xPath);

        return xPath;

    }







}
