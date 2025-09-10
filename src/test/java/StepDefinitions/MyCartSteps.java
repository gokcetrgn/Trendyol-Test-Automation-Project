package StepDefinitions;

import Pages.Header;
import Pages.MyCartPage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class MyCartSteps {
    WebDriver driver = DriverFactory.getDriver();
    MyCartPage myCart = new MyCartPage(driver);

    @Step("Select item and delete from my cart page")
    public void deleteItem() {
        myCart.delete();
    }

    @Step("User increases the item")
    public void increaseItem() {
        myCart.increase();
    }

    @Step("User decreases the item")
    public void decreaseItem() {
        myCart.decrease();
    }

    @Step("User is in Payment Page")
    public void paymentPageRoute() {
        myCart.paymentRoute();
    }
}
