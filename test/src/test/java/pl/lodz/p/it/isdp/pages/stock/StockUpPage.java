package pl.lodz.p.it.isdp.pages.stock;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StockUpPage {

    private final SearchContext context;
    public StockUpPage(SearchContext context) {
        this.context = context;
    }

    public Select getContractorNumberSelect() {
        return new Select(context.findElement(By.id("StockUpForm:contractorNumber")));
    }

    public void setContractor(String id) {
        getContractorNumberSelect().selectByValue(id);
    }

    public Select getProductSymbolSelect() {
        return new Select(context.findElement(By.id("StockUpForm:productSymbol")));
    }

    public void setProduct(String id) {
        getProductSymbolSelect().selectByValue(id);
    }

    public WebElement getQuantityInput() {
        return context.findElement(By.id("StockUpForm:quantity"));
    }

    public void setQuantity(int quantity) {
        getQuantityInput().sendKeys(Integer.toString(quantity));
    }

    public Select getLocationSelect() {
        return new Select(context.findElement(By.id("StockUpForm:locationSymbol")));
    }

    public void setLocation(String id) {
        getLocationSelect().selectByValue(id);
    }

    public WebElement getAddStockButton() {
        return context.findElement(By.id("StockUpForm:add-to-stock"));
    }

    public WebElement getConfirmButton() {
        return context.findElement(By.id("StockUp2Form:confirm"));
    }

    public void add() {
        getAddStockButton().click();
        getConfirmButton().click();
    }

}
