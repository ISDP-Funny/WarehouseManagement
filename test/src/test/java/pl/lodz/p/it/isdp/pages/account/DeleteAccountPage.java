package pl.lodz.p.it.isdp.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class DeleteAccountPage {
    private final SearchContext context;

    public DeleteAccountPage(SearchContext context) {
        this.context = context;
    }

    public WebElement getNameSpan() {
        return context.findElement(By.id("DeleteNewAccountForm:login"));
    }

    public WebElement getDeleteButton() {
        return context.findElement(By.name("DeleteNewAccountForm:delete-account-button"));
    }

    public void delete() {
        getDeleteButton().click();
    }
}
