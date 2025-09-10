package Pages;

import Util.ElementHelper;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By emailTxt = By.cssSelector("#login-email");
    By passwordTxt = By.cssSelector("#login-password-input");
    By loginButton = By.cssSelector("button[type='submit']");
    By message = By.cssSelector(".message");
    By categoryXButton = By.cssSelector(".i-cancel");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public void setEmail(String email) {
        elementHelper.click(emailTxt);
        elementHelper.waitForSeconds(5);
        elementHelper.sendKey(emailTxt, email);
    }
    public void setPassword(String password) {
        elementHelper.click(passwordTxt);
        elementHelper.waitForSeconds(5);
        elementHelper.sendKey(passwordTxt, password);
    }

    public void clickLoginButton() {
        elementHelper.waitForSeconds(5);
        elementHelper.click(loginButton);
    }

    public void errorMsg(String error) {
        elementHelper.controlMessage(message, error);
    }

    public void categoryXButton() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement categoryXBtn = wait.until(ExpectedConditions.presenceOfElementLocated(categoryXButton));
            if (categoryXBtn.isDisplayed()) {
                categoryXBtn.click();
            }
        } catch (TimeoutException e) {
            System.out.println(e);
        }
    }
}
