package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait webDriverWait;

    Actions actions;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebElement presenceElement(By key){
        return
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public WebElement findElement(By key){
        WebElement element = presenceElement(key);
        return element;
    }

    public void hover(By key){
        WebElement webElement = findElement(key);
        actions.moveToElement(webElement).perform();
    }

    public void click(By key) {
        findElement(key).click();
    }
    public void sendKey(By key, String txt){
        findElement(key).sendKeys(txt);
    }

    public void checkMessage(By key) {
        webDriverWait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    public void controlMessage(By locator, String expectedError) {
        WebElement element = driver.findElement(locator);
        String actualError = element.getText();
        Assert.assertEquals(actualError, expectedError, "Hata mesajı beklenenden farklı!");
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
