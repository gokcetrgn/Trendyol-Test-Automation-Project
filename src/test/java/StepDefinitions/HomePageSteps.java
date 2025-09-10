package StepDefinitions;

import Pages.HomePage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);


    @Step("User is in Trendyol home page")
    public void goToHomePage() {
        driver.get("https://www.trendyol.com/");
    }


    @Step("User clicks Accept Cookies")
    public void acceptCookies() {
        homePage.acceptCookies();
    }
}
