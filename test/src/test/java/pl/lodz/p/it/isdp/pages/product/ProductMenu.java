/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.isdp.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 *
 * @author th7nder
 */
public class ProductMenu {

    private final WebElement context;

    public ProductMenu(WebElement context) {
        this.context = context;
    }
    
    public ProductMenu open() {
        this.context.click();
        return this;
    }
    
    public WebElement getCreateItem() {
        return this.context.findElement(By.className("product--create"));
    }
    
    public WebElement getListItem() {
        return this.context.findElement(By.className("product--list"));
    }
    
    public void goToProductCreate() {
        getCreateItem().click();
    }

    public void goToProductList() {
        getListItem().click();
    }
    
    
}
