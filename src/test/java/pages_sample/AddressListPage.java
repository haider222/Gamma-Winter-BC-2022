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


    public void clickAddressEditButton(Map<String, String> accountData) throws Exception {
        String name = "text()=\"" + accountData.get("firstName") + " " + accountData.get("lastName") + "\"";
//        String lastName = "text()=\"" + accountData.get("lastName")+ "\"";
        String address = "text()=\"" + accountData.get("address") + "\"";
        String city = "text()=\"" + accountData.get("city") + " " + accountData.get("postCode") + "\"";
//        String postCode = "text()=\"" + accountData.get("postCode") + "\"";
        String country = "text()=\"" + accountData.get("country") + "\"";
        String region = "text()=\"" + accountData.get("region") + "\"";

        String search = String.join(" and ", name, address, city,  country, region);
        String xPath = "//td[" + search + "]/following-sibling::td/a[@class=\"btn btn-info\"]";

        System.out.println(String.format("%s %s %s %s %s",name, address, city, country, region));

        System.out.println(search);
        System.out.println(xPath);
        //td[text()="Adresas1" and text()="Imone"]/following-sibling::td/a[@class="btn btn-info"]
        //td[text()="MyName" and text()="MyLastName" and text()="MyAddress" and text()="MyCity" and text()="myPostCode" and text()="China" and text()="Gansu"]/following-sibling::td/a[@class="btn btn-info"]
//td[text()="MyName MyLastName" and text()="MyAddress ir kazkas" and text()="MyCity myPostCode" and text() = "Gansu" and text() = "China"]/following-sibling::td/a[@class="btn btn-info"]
//td[text()="MyName MyLastName" and text()="MyAddress" and text()="MyCity myPostCode" and text()="China" and text()="Gansu"]/following-sibling::td/a[@class="btn btn-info"]

    }



//    public void clickAddressEditButton(String name, String lastName, String address1, String city, String country, String region) {
//        WebElement addressInList = new RemoteWebElement() {
//        };
//        for (WebElement address : addressList) {
//            if (address.getText().contains(name) && address.getText().contains(lastName) && address.getText().contains(address1) &&
//                    address.getText().contains(city) && address.getText().contains(country) && address.getText().contains(region)) {
//                addressInList = address.findElement(By.cssSelector(".a.btn.btn-info"));
//            }
//        }
//        addressInList.click();
//
//    }



//     for (WebElement row : tableRows) {
//
//        String companyNameXPath = "td[2]";
//        WebElement companyName = row.findElement(By.xpath(companyNameXPath));
//        if (companyName.getText().equals(company)) {
//            valueString = row.findElement(By.xpath("td[4]")).getText();
//            break;
//        }
//    }  driver.findElement(By.xpath("//td[text()='company2']/following-sibling::td[2]")).getText();

//    driver.findElement(By.xpath("//td[text()='company2']/following-sibling::td[2]")).getText();

//    //td[text()='Adresas1' and text()='Imone']/following-sibling::td[text()="//a[@class="btn btn-info"]"]

//    //td[2]/a[@class="btn btn-info"]


//    final result  //td[text()='Adresas1' and text()='Imone']/following-sibling::td[1]/a[@class="btn btn-info"]

//  better final for edit   //td[text()="Adresas1" and text()="Imone"]/following-sibling::td/a[@class="btn btn-info"]
//  better final for delete   //td[text()="Adresas1" and text()="Imone"]/following-sibling::td/a[@class="btn btn-danger"]



}
