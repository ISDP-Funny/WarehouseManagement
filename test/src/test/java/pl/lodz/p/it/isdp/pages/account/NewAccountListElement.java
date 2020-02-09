package pl.lodz.p.it.isdp.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class NewAccountListElement {
    private final SearchContext context;

    public NewAccountListElement(SearchContext context) {
        this.context = context;
    }

    public WebElement getDeleteButton() {
        return context.findElement(By.cssSelector("[id$=delete-account-button]"));
    }
    public void goToDeletePage() {
        getDeleteButton().click();
    }
}
