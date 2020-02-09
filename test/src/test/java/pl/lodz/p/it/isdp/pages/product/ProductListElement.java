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
public class ProductListElement {

    private final SearchContext context;
    public ProductListElement(SearchContext context) {
        this.context = context;
        
    }

    public WebElement getDeleteButon() {
        return context.findElement(By.className("delete-product"));
    }
    
    public void goToDelete() {
        getDeleteButon().click();
    }
    
}
