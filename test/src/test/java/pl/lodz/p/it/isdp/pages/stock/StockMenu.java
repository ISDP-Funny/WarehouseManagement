package pl.lodz.p.it.isdp.pages.stock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StockMenu {

    private final WebElement context;

    public StockMenu(WebElement context) {
        this.context = context;
    }

    public StockMenu open() {
        this.context.click();
        return this;
    }

    public WebElement getUpItem() {
        return this.context.findElement(By.className("stock--up"));
    }

    public WebElement getViewItem() {
        return this.context.findElement(By.className("stock--list"));
    }

    public void goToStockUp() {
        getUpItem().click();
    }

    public void goToStockView() {
        getViewItem().click();
    }

}
