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
public class ProductListPage {

    private final SearchContext context;
    public ProductListPage(SearchContext context) {
        this.context = context;   
    }
    
    public ProductListElement findProductBySymbol(long productSymbol) {
        return new ProductListElement(context.findElement(
                By.xpath(String.format("//*[contains(text(), '%d')]/parent::*", productSymbol))
        ));
    }
}
