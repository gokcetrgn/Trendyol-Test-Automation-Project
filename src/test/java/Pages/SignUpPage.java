package Pages;

import Util.ElementHelper;
import Util.TempMail;
import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class SignUpPage {
    WebDriver driver;
    ElementHelper elementHelper;
    ApiClient mailslurpClient;
    WebDriverWait wait;
    InboxControllerApi inboxController;
    WaitForControllerApi waitForController;

    By emailTxt = By.cssSelector("#register-email");
    By passwordTxt = By.cssSelector("#register-password-input");
    By signUpButton = By.cssSelector("button[type='submit']");

    By captcha = By.cssSelector(".recaptcha-checkbox-border");
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.mailslurpClient = Configuration.getDefaultApiClient();
        this.mailslurpClient.setApiKey("5caa231b08e681835655f9ffe5d4bbdca589915b3e96133aa720eb23de0e8318");

        this.inboxController = new InboxControllerApi(mailslurpClient);
        this.waitForController = new WaitForControllerApi(mailslurpClient);
    }

    public TempMail createInbox() throws ApiException {
        InboxDto inbox = inboxController.createInbox().execute();
        System.out.println("Geçici Mail: " + inbox.getEmailAddress());
        return new TempMail(inbox.getId(), inbox.getEmailAddress());
    }

    public void signup(String email, String password) {
        elementHelper.click(emailTxt);
        elementHelper.sendKey(emailTxt, email);

        elementHelper.click(passwordTxt);
        elementHelper.sendKey(passwordTxt, password);

        clickCheckbox(By.xpath("(//div[contains(@name,'new-co-privacy-statement-for-ty')])[1]"));
        clickCheckbox(By.xpath("(//div[contains(@name,'new-co-privacy-statement-for-ty')])[3]"));


    }


    public void chooseGender(String gender) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement genderButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[span[text()='" + gender + "']]")
                )
        );

        genderButton.click();
    }

    public String waitForEmail(UUID inboxId) throws ApiException {
        Email email = waitForController.waitForLatestEmail()
                .inboxId(inboxId)
                .timeout(60000L)
                .unreadOnly(true)
                .execute();

        System.out.println("Konu: " + email.getSubject());
        System.out.println("İçerik: " + email.getBody());

        String body = email.getBody();
        return extractCode(body); // sadece kodu döndürüyoruz
    }

    private String extractCode(String body) {
        // 4-6 haneli rakam dizisini bulur (ör: 123456)
        String regex = "\\b\\d{4,6}\\b";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public void clickSignUpButton() {
        elementHelper.click(captcha);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.click(signUpButton);
    }

    public void enterVerificationCode(UUID inboxId) throws ApiException {
        // 1. Mailden kodu al
        String code = waitForEmail(inboxId);

        // 2. Kod alanına gir ve gönder
        By verificationCodeInput = By.id("verificationCode");
        By submitButton = By.id("submitButton");

        elementHelper.sendKey(verificationCodeInput, code);
        elementHelper.click(submitButton);
    }

    public void clickCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }
}
