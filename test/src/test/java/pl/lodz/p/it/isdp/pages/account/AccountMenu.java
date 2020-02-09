package pl.lodz.p.it.isdp.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountMenu {
    private final WebElement context;

    public AccountMenu(WebElement context) {
        this.context = context;
    }

    public AccountMenu open() {
        this.context.click();
        return this;
    }

    public WebElement getNewAccounts() {
        return this.context.findElement(By.className("accounts--new"));
    }

    public WebElement getAuthorizedAccounts() {
        return this.context.findElement(By.className("accounts--authorized"));
    }

    public void goToNewAccounts() {
        getNewAccounts().click();
    }

    public void goToAuthorizedAccounts() {
        getAuthorizedAccounts().click();
    }


}
