/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.isdp.pages;

import pl.lodz.p.it.isdp.pages.product.ProductMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author th7nder
 */
public class MainMenuPage {
    private final SearchContext context;
    
    public MainMenuPage(SearchContext context) {
        this.context = context;
    }
    
    public WebElement getSignInButton() {
        return context.findElement(By.cssSelector("#myNavbar .login"));
    }
    
    public void goToSignIn() {
        getSignInButton().click();
    }
    
    public ProductMenu getProductMenu() {
        return new ProductMenu(context.findElement(By.className("product")));
    }

    public WebElement getRegisterButton() { return context.findElement(By.cssSelector("#myNavbar .register")); }

    public void goToRegister() { getRegisterButton().click(); }
}
