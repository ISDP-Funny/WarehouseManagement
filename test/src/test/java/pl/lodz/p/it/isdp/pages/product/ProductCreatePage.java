/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.isdp.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 *
 * @author th7nder
 */
public class ProductCreatePage {

    private final SearchContext context;
    public ProductCreatePage(SearchContext context) {
        this.context = context.findElement(By.id("CreateProductForm"));
    }
    
    private WebElement getProductSymbolInput() {
        return context.findElement(By.id("CreateProductForm:productSymbol"));
    }
    
    private WebElement getDescriptionInput() {
        return context.findElement(By.id("CreateProductForm:description"));
    }
    
    private WebElement getPriceInput() {
        return context.findElement(By.id("CreateProductForm:price"));
    }
    
    private WebElement getWeightInput() {
        return context.findElement(By.id("CreateProductForm:weight"));
    }
    
    private WebElement getCreateButton() {
        return context.findElement(By.cssSelector("#CreateProductForm .create"));
    }
    

    public void setProductSymbol(long productSymbol) {
        getProductSymbolInput().sendKeys(Long.toString(productSymbol));
    }

    public void setDescription(String description) {
        getDescriptionInput().sendKeys(description);
    }

    public void setPrice(double d) {
        getPriceInput().sendKeys(String.format("%.2f", d));
    }

    public void setWeight(int i) {
        getWeightInput().sendKeys(Keys.BACK_SPACE, Integer.toString(i));
    }

    public void create() {
        getCreateButton().click();
    }
}
