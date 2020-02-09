package pl.lodz.p.it.isdp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public class ITAdminUseCase extends DriverBase {

    @Test
    public void testAdmin() {
        WebDriver driver = getDriver();
        driver.get(getAppUrl()+"/faces/common/signIn.xhtml");
        driver.findElement(By.name("j_username")).sendKeys("DMitchell");
        driver.findElement(By.name("j_password")).sendKeys("P@ssw0rd" + Keys.ENTER);
        String footerTest = driver.findElement(By.className("footer")).getText();
        Assert.assertTrue(footerTest.contains("Authenticated user: DMitchell"));
        driver.get(getAppUrl()+"/faces/common/registerAccount.xhtml");
        driver.findElement(By.id("RegisterForm:name")).sendKeys("Yan");
        driver.findElement(By.id("RegisterForm:surname")).sendKeys("Kovalsky");
        driver.findElement(By.id("RegisterForm:email")).sendKeys("kovalsky@example.com");
        driver.findElement(By.id("RegisterForm:login")).sendKeys("YKovalsky");
        driver.findElement(By.id("RegisterForm:password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("RegisterForm:passwordRepeat")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("RegisterForm:question")).sendKeys("Favorite number?");
        driver.findElement(By.id("RegisterForm:answer")).sendKeys("1" + Keys.ENTER);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("index.xhtml"));
        driver.get(getAppUrl()+"/faces/account/listNewAccounts.xhtml");
        Optional<WebElement> row = getUserTableRow("YKovalsky");
        Assert.assertTrue(row.isPresent());
        row.get().findElement(By.cssSelector("[id$=delete-account-button]")).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("deleteNewRegisteredAccount.xhtml"));
        String userName = driver.findElement(By.id("DeleteNewAccountForm:login")).getText();
        Assert.assertEquals("YKovalsky", userName);
        driver.findElement(By.name("DeleteNewAccountForm:delete-account-button")).click();
        row = getUserTableRow("YKovalsky");
        Assert.assertFalse(row.isPresent());
    }

    private Optional<WebElement> getUserTableRow(String name) {
        return getDriver().findElement(By.tagName("table")).findElements(By.tagName("tr"))
                .stream().filter(e -> {
                    List<WebElement> list = e.findElements(By.tagName("td"));
                    return !list.isEmpty() && list.get(0).getText().equals(name);
                }).findFirst();
    }

}
