package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By nameTxt = By.cssSelector("input[placeholder='Adınızı Giriniz']");
    By surnameTxt = By.cssSelector("input[placeholder='Soyadınızı Giriniz']");
    By phone = By.cssSelector("input[value='0 (___) ___ __ __']");

    By addressTxt = By.cssSelector("textarea[placeholder='Cadde, mahalle sokak ve diğer bilgileri giriniz.']");
    By addressTitleTxt = By.cssSelector("input[placeholder='Adres Başlığı Giriniz']");

    By codeTxt = By.cssSelector("ty-bg-beige.ty-input.ty-textbox.ty-bordered.ty-input-small");
    By saveButton = By.cssSelector("button[type='submit']");
    By submitButton = By.cssSelector(".ty-font-w-semi-bold.ty-button.ty-bordered.ty-transition.ty-input-small.ty-primary");

    By cardNumber = By.cssSelector("#card-number");
    By cardMonth = By.cssSelector("#card-date-month");
    By cardYear = By.cssSelector("#card-date-year");

    By cardCVV = By.cssSelector("#card-cvv");

    By paymentButton = By.cssSelector(".approve-button.ty-primary-btn.ty-btn-large");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void personalInfo(String name, String surname, String phoneNumber) {
        elementHelper.click(nameTxt);
        elementHelper.sendKey(nameTxt, name);

        elementHelper.click(surnameTxt);
        elementHelper.sendKey(surnameTxt, surname);

        elementHelper.click(phone);
        elementHelper.sendKey(phone, phoneNumber);
    }

    public void chooseCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Dropdown'u aç
        WebElement dropdown = driver.findElement(By.name("cityId"));
        dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ty-select-option")));

        // Tüm seçenekleri al
        List<WebElement> options = driver.findElements(By.cssSelector(".ty-select-option"));

        // Bursa'yı bulup tıkla
        for (WebElement option : options) {
            if (option.getText().trim().equals(city)) {
                option.click();
                break;
            }
        }
    }

    public void chooseDistrictNeighborhood(String district, String neighborhood) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // District dropdown
        WebElement dropdownDistrict = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("districtId"))
        );
        dropdownDistrict.click();

        // District options -> sadece district dropdown içinden al
        WebElement districtOptionsBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[name='districtId'] .ty-select-options")
                )
        );
        List<WebElement> districtOptions = districtOptionsBox.findElements(By.cssSelector(".ty-select-option"));

        for (WebElement option : districtOptions) {
            if (option.getText().trim().equals(district)) {
                option.click();
                break;
            }
        }

        // Neighborhood dropdown
        WebElement dropdownNeighborhood = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("neighborhoodId"))
        );
        dropdownNeighborhood.click();

        // Neighborhood options -> sadece neighborhood dropdown içinden al
        WebElement neighborhoodOptionsBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[name='neighborhoodId'] .ty-select-options")
                )
        );
        List<WebElement> neighborhoodOptions = neighborhoodOptionsBox.findElements(By.cssSelector(".ty-select-option"));

        for (WebElement option : neighborhoodOptions) {
            if (option.getText().trim().equals(neighborhood)) {
                option.click();
                break;
            }
        }

    }

    public void writeAddress(String address, String addressTitle) {
        elementHelper.click(addressTxt);
        elementHelper.sendKey(addressTxt , address);

        elementHelper.click(addressTitleTxt);
        elementHelper.sendKey(addressTitleTxt, addressTitle);

    }

    public void saveAddress() {
        elementHelper.click(saveButton);
        elementHelper.click(codeTxt);
        elementHelper.sendKey(codeTxt, "123455"); // örnek kod girdik
        elementHelper.click(submitButton);
    }

    public void addCardNumbers(String card) {
        elementHelper.click(cardNumber);
        elementHelper.sendKey(cardNumber, card);
    }

    public void addDateCVV(String months, String years, String cvv) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement monthsDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(cardMonth)
        );

        Select selectMonth = new Select(monthsDropdown);

        selectMonth.selectByValue(months);   // value attribute'a göre seçer

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement yearDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(cardYear)
        );

        Select selectYear = new Select(yearDropdown);

        selectYear.selectByValue(years);

        elementHelper.click(cardCVV);
        elementHelper.sendKey(cardCVV, cvv);
    }

    public void clickCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='check'][type='checkbox']"));
        checkbox.click();
    }

    public void pay() {
        elementHelper.click(paymentButton);
    }
}
