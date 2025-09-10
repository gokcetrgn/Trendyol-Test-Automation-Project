package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ProductListingPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By cart = By.xpath("(//*[@class='p-card-chldrn-cntnr card-border'])[2]");
    By brandFilter = By.cssSelector("input[placeholder='Marka ara']");
    By minNum = By.cssSelector("input[placeholder='En Az']");
    By maxNum = By.cssSelector("input[placeholder='En Çok']");
    By search = By.cssSelector(".fltr-srch-prc-rng-srch");

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickCartofProduct() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(cart));
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        elementHelper.findElement(cart);
        elementHelper.click(cart);


    }

    public void writeBrandName(String brandName) {
        By brandText = By.xpath("//div[@class='fltr-item-text' and normalize-space(text())='" + brandName + "']");

        elementHelper.click(brandFilter);
        elementHelper.sendKey(brandFilter,brandName);

        elementHelper.click(brandText);
    }

    public void scrollBrands() {

        List<String> markalar = Arrays.asList("Galatasaray", "Eastpak");

        // Doğru scroll alanı: ReactVirtualized__Grid
        WebElement scrollArea = driver.findElement(By.cssSelector(".ReactVirtualized__Grid"));

        Set<String> bulunanMarkalar = new HashSet<>();
        int maxDeneme = 10;

        for (int i = 0; i < maxDeneme; i++) {
            for (String marka : markalar) {
                try {
                    WebElement markaElement = driver.findElement(
                            By.xpath("//div[@class='fltr-item-text' and normalize-space(text())='" + marka + "']")
                    );
                    if (!bulunanMarkalar.contains(marka)) {
                        markaElement.click();
                        bulunanMarkalar.add(marka);
                        System.out.println(marka + " bulundu ve seçildi!");
                    }
                } catch (NoSuchElementException e) {
                }
            }

            if (bulunanMarkalar.containsAll(markalar)) {
                break;
            }

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollTop = arguments[0].scrollTop + 400", scrollArea);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (!bulunanMarkalar.containsAll(markalar)) {
            System.out.println("Bazı markalar bulunamadı!");
        }
    }

    public void choosePriceRange() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fiyatTitle = driver.findElement(
                By.xpath("//div[@class='fltr-cntnr-ttl' and text()='Fiyat']")
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fiyatTitle);

        fiyatTitle.click();

        List<WebElement> fiyatFilterleri = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[div[@class='fltr-cntnr-ttl' and text()='Fiyat']]/following-sibling::div//div[@class='fltr-item-text']")
                )
        );

        if (fiyatFilterleri.size() >= 3) {
            fiyatFilterleri.get(2).click();
        } else {
            System.out.println("Yeterli sayıda fiyat filtresi yok!");
        }
    }

    public void writePriceRange(String min, String max) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fiyatTitle = driver.findElement(
                By.xpath("//div[@class='fltr-cntnr-ttl' and text()='Fiyat']")
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fiyatTitle);

        fiyatTitle.click();

        elementHelper.click(minNum);
        elementHelper.sendKey(minNum, min);

        elementHelper.click(maxNum);
        elementHelper.sendKey(maxNum, max);

        elementHelper.click(search);

    }
}
