package pl.lodz.p.it.isdp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ITWarehouseUseCase extends DriverBase {

    @Test
    public void login() {
        WebDriver driver = getDriver();
        driver.get(getAppUrl());
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Strona główna"));
    }


}
