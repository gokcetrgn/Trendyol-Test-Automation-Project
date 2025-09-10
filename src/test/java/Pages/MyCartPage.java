package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCartPage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By confirm = By.xpath("//a[contains(@class,'ty-link-btn-primary') and span[text()='Sepeti Onayla']]");



    public MyCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void delete() {
        driver.findElement(
                By.xpath("(//button[@aria-label='Ürünü sepetten çıkartma'])[1]")
        ).click();
    }

    public void increase() {
        driver.findElement(
                By.xpath("(//button[@aria-label='Ürün adedi arttırma'])[1]")
        ).click();
    }

    public void decrease() {
        driver.findElement(
                By.xpath("(//button[@aria-label='Ürün adedi azaltma'])[2]")
        ).click();
    }

    public void paymentRoute() {
        elementHelper.click(confirm);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement continueButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector(".ty-button.ty-secondary.ty-plus-continue-without-add")
                    )
            );
            continueButton.click();
            System.out.println("Buton bulundu ve tıklandı.");
        } catch (TimeoutException e) {
            System.out.println("Buton görünmedi, devam edildi.");
        }
    }
}
