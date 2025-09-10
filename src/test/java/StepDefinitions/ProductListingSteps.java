package StepDefinitions;

import Pages.ProductListingPage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class ProductListingSteps {
    WebDriver driver = DriverFactory.getDriver();
    ProductListingPage searchResultsPage = new ProductListingPage(driver);

    @Step("User click cart of product")
    public void cartofProduct() {
        searchResultsPage.clickCartofProduct();
    }

    @Step("User writes <brandName> and click")
    public void writeBrandName(String brandName) {
        searchResultsPage.writeBrandName(brandName);
    }

    @Step("User chooses brands with scroll")
    public void brandScrolls() {
        searchResultsPage.scrollBrands();
    }

    @Step("User chooses a price range")
    public void choosePriceRange() {
        searchResultsPage.choosePriceRange();
    }

    @Step("User writes <min> number and <max> number")
    public void priceRangeFromUser(String min, String max) {
        searchResultsPage.writePriceRange(min, max);
    }
}
