package Pages;

import Util.ElementHelper;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By acceptCookie = By.cssSelector("#onetrust-accept-btn-handler");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }



    public void acceptCookies() {
        try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookieBtn = wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookie));
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
            }
        } catch (TimeoutException e) {
            System.out.println(e);
        }
    }
}
