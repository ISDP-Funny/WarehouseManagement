package pl.lodz.p.it.isdp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public abstract class DriverBase {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private String url;

    public DriverBase() {
        url = TestUtils.getAppUrl();
    }

    @BeforeClass
    public static void setupDriver() {
        threadDriver.set(TestUtils.getDriver());
    }

    protected WebDriver getDriver() {
        return threadDriver.get();
    }

    protected String getAppUrl() {
        return url;
    }

    @AfterClass
    public static void closeDriver() {
        threadDriver.get().close();
    }
}
