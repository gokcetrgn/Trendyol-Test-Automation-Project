package Pages;

import Util.ElementHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Favorites {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By addCollectionButton  = By.cssSelector("div[class='collections-buttons'] span:nth-child(2)");
    By message = By.cssSelector("div[class='basket-success-badge tr'] span");
    By routeCollections = By.cssSelector(".favorites-header-item.collection");
    By collectionTextfield = By.cssSelector("input[placeholder='Koleksiyon Adı Girin']");
    By xButton = By.cssSelector("div[role='button']");
    By saveButton = By.cssSelector(".p-button-wrapper.p-primary.p-large.p-fluid");
    public Favorites(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void delete() {
        By secondCloseIcon = By.xpath("(//div[contains(@class,'product-card-wrapper')]//div[contains(@class,'product-close-icon')])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(secondCloseIcon));
        closeBtn.click();
    }

    public void addToCart() {
        By addToCard = By.xpath("(//div[contains(@class, 'basket-buttons-container')]//button[contains(@class, 'basket-button')])[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCard));
        closeBtn.click();
    }

    public void message() {
        Assert.assertEquals("Sepetinize Eklendi", message, "Mesaj beklenenden farklı!");
    }

    public void collectionsPage() {
        elementHelper.click(routeCollections);
    }

    public void addCollectionButton() {
        elementHelper.click(addCollectionButton);
    }

    public void writeCollectionName(String name) {
        elementHelper.click(collectionTextfield);
        elementHelper.sendKey(collectionTextfield, name);
        elementHelper.click(saveButton);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elementHelper.click(xButton);
                    return true;
                });
    }
}
