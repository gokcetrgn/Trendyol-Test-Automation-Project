package StepDefinitions;

import Pages.LoginPage;
import Pages.SignUpPage;
import Util.DriverFactory;
import Util.TempMail;
import com.mailslurp.clients.ApiException;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

public class SignUpPageSteps {
    WebDriver driver = DriverFactory.getDriver();
    SignUpPage sign = new SignUpPage(driver);

    TempMail tempMail;

    @Step("User is in Trendyol Sign Up page")
    public void signUpPage() {
        driver.get("https://www.trendyol.com/uyelik?cb=%2F");
    }

    @Step("User chooses <gender> for gender")
    public void chooseGender(String gender) {
        sign.chooseGender(gender);
    }

    @Step("User writes email on email textfield and writes password on password textfield")
    public void signup() throws ApiException {
        tempMail = sign.createInbox();
        // Formu doldur
        sign.signup(tempMail.emailAddress, "987321654gG.");
    }

    @Step("User clicks sign up button")
    public void clickSignUp() {
        sign.clickSignUpButton();
    }

    @Step("User gets verification code from email and enters it")
    public void getsVerificationCode() throws ApiException {
        sign.enterVerificationCode(tempMail.inboxId);
    }
}
