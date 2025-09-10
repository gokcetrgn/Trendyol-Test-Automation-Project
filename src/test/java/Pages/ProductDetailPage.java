package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By addToCardButton = By.cssSelector("[data-testid=\"add-to-cart-button\"]");
    By selectOkeyButton = By.cssSelector("._button_65101ec._md_56119da._contained_7fc71b7._contained-primary_df66b41.apply-button");
    By heart = By.cssSelector("div[class='product-actions-fragment'] i[class='_icon_ed56b9e _dark-gray_f6bc31d i-heart _icon-sm_88e1034 favorite-button-icon']");
    By comments = By.cssSelector("a[class='reviews-summary-reviews-detail'] span");

    By addCollection = By.cssSelector("._body_03c70b5._left_b388a23._align-left_def5d71.collection-button-text");
    By collectionButton = By.cssSelector("._icon_ed56b9e._white_829a6af.i-plus-ds._icon-sm_88e1034");
    By form = By.cssSelector("#ui-kit-input-1");

    By createCollection = By.cssSelector("._button_65101ec._lg_d463ab3._contained_7fc71b7._contained-primary_df66b41._fluid_f013a80.add-new-collection-popup-create-collection-button");


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void addToCard() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCardButton));
        elementHelper.click(addToCardButton);
    }

    public void selectAddress() {

        WebElement selectAddressButton = driver.findElement(By.xpath("//button[normalize-space()='Konum Seçin']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectAddressButton);
        selectAddressButton.click();

        List<WebElement> dropdowns = driver.findElements(By.className("location-item-dropdown"));
        WebElement cityDropdown = dropdowns.get(0);
        cityDropdown.click();

        elementHelper.findElement(By.xpath("//div[contains(@class,'dropdown-option') and text()='İstanbul']")).click();

        WebElement townDropdown = dropdowns.get(1);
        townDropdown.click();

        elementHelper.findElement(By.xpath("//div[contains(@class,'dropdown-option') and text()='Gaziosmanpaşa']")).click();

        elementHelper.click(selectOkeyButton);
    }

    public void switchPages() {
        String mainTab = driver.getWindowHandle();

        // yeni sekmeye geç
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void addFavorite() {
        elementHelper.click(heart);
    }

    public void readComments() {
        elementHelper.click(comments);
    }

    public void addCollection() {
        elementHelper.click(addCollection);
    }

    public void writeCollectionName(String name) {
        elementHelper.click(collectionButton);

        elementHelper.click(form);

        elementHelper.sendKey(form, name);

        elementHelper.click(createCollection);
    }

    public void existingCollection() {
        By secondCollection = By.xpath("(//button[contains(@class,'collections-popup-collection-button')])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(secondCollection));
        element.click();
    }
}
