package StepDefinitions;


import Pages.Header;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class HeaderSteps {
    WebDriver driver = DriverFactory.getDriver();
    Header header = new Header(driver);


    @Step("User click the login button")
    public void clickLoginButton() {
        header.clickLoginButton();
    }

    @Step("User writes <product>")
    public void searchProduct(String product) {
        header.searchProduct(product);
    }

    @Step("User clicks search button")
    public void clickSearch() {
        header.clickSearch();
    }

    @Step("User clicks search icon")
    public void clickSearchIcon() {
        header.clickSearchIcon();
    }

    @Step("User click one of popular search")
    public void popularSearch() {
        header.popularSearch();
    }

    @Step("User clicks menu icon")
    public void clickMenuIcon() {
        header.clickMenuIcon();
    }

    @Step("User chooses <categoryName> category")
    public void choosesCategoryName(String categoryName) {
        header.chooseCategoryName(categoryName);
    }

    @Step("User chooses <subCategory> sub category")
    public void choosesSubCategory(String subcategory) {
        header.choosesSubCategory(subcategory);
    }

    @Step("User clicks My Account in Header")
    public void myAccountButton() {
        header.myAccountButton();
    }

    @Step("User clicks log out button")
    public void logOut() {
        header.logOut();
    }

    @Step("User click the signup button")
    public void clickSignUp() {
        header.clickSignUpButton();
    }

    @Step("User is in favorites page")
    public void favoritesPageRoute() {
        header.favoritesPage();
    }

    @Step("User is in my cart page")
    public void myCartPage() {
        header.myCartPage();
    }
}
