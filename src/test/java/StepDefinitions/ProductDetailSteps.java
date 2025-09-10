package StepDefinitions;

import Pages.LoginPage;
import Pages.ProductDetailPage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class ProductDetailSteps {
    WebDriver driver = DriverFactory.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    @Step("User click Add To Card button")
    public void addToCard() {
        productDetailPage.addToCard();
    }

    @Step("Select address")
    public void selectAddress() {
        productDetailPage.selectAddress();
    }

    @Step("Switch with other page")
    public void swithPages() {
        productDetailPage.switchPages();
    }

    @Step("Click heart to add favorities")
    public void addFavorities() {
        productDetailPage.addFavorite();
    }

    @Step("Click comments")
    public void readComments() {
        productDetailPage.readComments();
    }

    @Step("User clicks add collection button")
    public void addCollection() {
        productDetailPage.addCollection();
    }

    @Step("User writes <name> of collection")
    public void writeNameCollection(String name) {
        productDetailPage.writeCollectionName(name);
    }

    @Step("User chooses existing collection")
    public void existingCollection() {
        productDetailPage.existingCollection();
    }
}
