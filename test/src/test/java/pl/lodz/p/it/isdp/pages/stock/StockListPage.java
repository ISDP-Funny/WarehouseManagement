package pl.lodz.p.it.isdp.pages.stock;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StockListPage {

    private final SearchContext context;
    public StockListPage(SearchContext context) {
        this.context = context;
    }

    public Select getProductSelect() {
        return new Select(context.findElement(By.cssSelector("[id$=productSymbol]")));
    }

    public WebElement getViewStockButton() {
        return context.findElement(By.cssSelector("[id$=view-stock]"));
    }

    public WebElement getStockIssueButton() {
        return context.findElement(By.cssSelector("[id$=issue-stock]"));
    }

}
