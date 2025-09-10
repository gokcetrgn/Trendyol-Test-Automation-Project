package StepDefinitions;

import Pages.PaymentPage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class PaymentSteps {
    WebDriver driver = DriverFactory.getDriver();
    PaymentPage paymentPage = new PaymentPage(driver);

    @Step("User adds <name> for name, <surname> for surname and <phoneNumber> for mobile")
    public void personalInfo(String name, String surname, String phoneNumber) {
        paymentPage.personalInfo(name, surname, phoneNumber);
    }

    @Step("User choose <city> for city")
    public void chooseCity(String city) {
        paymentPage.chooseCity(city);
    }

    @Step("User choose <district> for district and <neighborhood> for neighborhood")
    public void chooseDistricteighborhood(String district, String neighborhood) {
        paymentPage.chooseDistrictNeighborhood(district, neighborhood);
    }

    @Step("User writes <address> for address and <addressTitle> for title")
    public void writeAddress(String address, String addressTitle) {
        paymentPage.writeAddress(address, addressTitle);
    }

    @Step("User saves his address")
    public void saveAddress() {
        paymentPage.saveAddress();
    }


    @Step("Add test <card numbers>")
    public void addCardNumbers(String card) {
        paymentPage.addCardNumbers(card);
    }

    @Step("Add <months> for months and <years> for years and <CVV>")
    public void addDateCVV(String months, String years, String cvv) {
        paymentPage.addDateCVV(months, years, cvv);
    }

    @Step("User clicks checkbox")
    public void clicksCheckbox() {
        paymentPage.clickCheckbox();
    }

    @Step("User clicks payment button")
    public void pay() {
        paymentPage.pay();
    }
}
