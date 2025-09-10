package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Header {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By loginButton = By.cssSelector(".link.account-user");
    By login = By.cssSelector(".login-button");
    By signup = By.xpath("//div[@class='signup-button signup-button-container']");
    By myAccount = By.cssSelector("div[class='link account-user'] p[class='link-text']");
    By search = By.cssSelector("[data-testid=\"suggestion\"]");
    By searchIcon = By.cssSelector(".ft51BU2r");
    By popularProductOne = By.cssSelector("div[id='header'] a:nth-child(1) div:nth-child(1) span:nth-child(1)");
    By cancelIcon = By.cssSelector(".icon-cancel-flat");
    By logOut = By.xpath("//a[@class='loggedin-account-item']//p[normalize-space()='Çıkış Yap']");
    By menuIcon = By.cssSelector(".i-navigation-menu");
    By myCart = By.cssSelector("a[class='link account-basket'] p[class='link-text']");
    By favorites = By.xpath("//*[contains(@class,'link-text') and normalize-space()='Favorilerim']");
    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public void clickLoginButton() {
        elementHelper.hover(loginButton);
        elementHelper.click(login);
    }

    public void searchProduct(String product) {
        elementHelper.sendKey(search, product);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".q-loader")));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(search).click();
                    return true;
                });
    }

    public void clickSearchIcon() {
        elementHelper.click(searchIcon);
    }

    public void popularSearch() {
        elementHelper.click(popularProductOne);
    }

    public void clickMenuIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elementHelper.click(menuIcon);
                    return true;
                });
    }

    public void chooseCategoryName(String categoryName) {
        By categoryElement = By.xpath("//div[@class='left-side-container']//span[@class='category-title' and normalize-space()='" + categoryName + "']");
        WebElement categoryBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(categoryElement));
        categoryBtn.click();

    }

    public void choosesSubCategory(String subcategory) {
        By subCategoryElement = By.xpath("//nav//*[normalize-space(text())='" + subcategory + "']");
        WebElement subCategoryBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(subCategoryElement));
        subCategoryBtn.click();
    }

    public void myAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elementHelper.click(myAccount);
                    return true;
                });

    }

    public void logOut() {
        elementHelper.click(logOut);
    }

    public void clickSignUpButton() {
        elementHelper.hover(loginButton);
        elementHelper.click(signup);
    }

    public void favoritesPage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.q-loader")));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elementHelper.click(favorites);
                    return true;
                });
    }

    public void myCartPage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.q-loader")));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elementHelper.click(myCart);
                    return true;
                });
    }
}
