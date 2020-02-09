package pl.lodz.p.it.isdp.pages.stock;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class StockIssuePage {

    private final SearchContext context;
    public StockIssuePage(SearchContext context) {
        this.context = context;
    }

    public WebElement getQuantityInput() {
        return context.findElement(By.id("StockIssueForm:quantityToIssue"));
    }

    public WebElement getApproveInput() {
        return context.findElement(By.id("StockIssueForm:approve"));
    }

}
