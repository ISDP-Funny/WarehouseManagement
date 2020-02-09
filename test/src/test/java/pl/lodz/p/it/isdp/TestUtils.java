package pl.lodz.p.it.isdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestUtils {
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        if (System.getenv("BUILD_ID") != null) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        }
        return new ChromeDriver(options);
    }

    public static String getAppUrl() {
        return System.getProperty("baseUrl");
    }
}
