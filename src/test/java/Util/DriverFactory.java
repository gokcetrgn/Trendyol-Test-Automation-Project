package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initalize_Driver(String browser){
        properties = ConfigReaders.getProperties();
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        String url = properties.getProperty("url");
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));
        return getDriver();
    }
    public static WebDriver getDriver(){
        return driver;
    }

}
