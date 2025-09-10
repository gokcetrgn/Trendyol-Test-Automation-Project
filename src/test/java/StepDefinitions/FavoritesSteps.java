package StepDefinitions;

import Pages.Favorites;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class FavoritesSteps {
    WebDriver driver = DriverFactory.getDriver();
    Favorites favorites = new Favorites(driver);


    @Step("Delete from favorites page")
    public void deleteFromFavorites() {
        favorites.delete();
    }

    @Step("Add to cart from favorites page")
    public void addToCart() {
        favorites.addToCart();
    }

    @Step("Check the message")
    public void checkMsg() {
        favorites.message();
    }

    @Step("User is in collections page")
    public void collectionsPage() {
        favorites.collectionsPage();
    }

    @Step("Write collection <name> and save")
    public void writeCollectionName(String name) {
        favorites.writeCollectionName(name);
    }

    @Step("Click add collections button")
    public void addCollectionButton() {
        favorites.addCollectionButton();
    }
}
