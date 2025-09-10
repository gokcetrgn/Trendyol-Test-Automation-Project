package Util;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;

    @BeforeScenario
    public void beforeScenario() {
        properties = ConfigReaders.initialize_Properties();
        String browser = properties.getProperty("browser", "Chrome"); // yoksa Chrome seç
        driver = DriverFactory.initalize_Driver(browser);
    }

    @AfterScenario
    public void afterScenario() {
        if (driver != null) {
            // driver.quit();
        }
    }
}
