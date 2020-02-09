package pl.lodz.p.it.isdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestUtils {
    private static boolean isRemote = System.getenv("BUILD_ID") != null;
    
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        if (isRemote) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        } else {
            options.addArguments("--ignore-certificate-errors");
        }
        return new ChromeDriver(options);
    }

    public static String getAppUrl() {
        return System.getProperty("baseUrl");
    }
}
