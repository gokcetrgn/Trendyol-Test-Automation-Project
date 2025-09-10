package StepDefinitions;

import Pages.LoginPage;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPageSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Step("User is in Trendyol login page")
    public void setLoginPage() {
        driver.get("https://www.trendyol.com/giris?cb=%2F");
    }

    @Step("User clicks login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("User writes <email> on email textfield")
    public void setEmail(String email) {
        loginPage.setEmail(email);
    }

    @Step("User writes <password> on password textfield")
    public void setPassword(String password) {
        loginPage.setPassword(password);
    }

    @Step("User has an <error> error")
    public void showError(String error) {
        loginPage.errorMsg(error);
    }

    @Step("User clicks X button about categories")
    public void categoryXButton() {
        loginPage.categoryXButton();
    }
}
