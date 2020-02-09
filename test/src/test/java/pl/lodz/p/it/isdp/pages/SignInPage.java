/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.isdp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 *
 * @author th7nder
 */
public class SignInPage {
    private final SearchContext context;
    private static String userPassword = "P@ssw0rd";
    
    public SignInPage(SearchContext context) {
        this.context = context;
    }
    
    public WebElement getUsernameInput() {
        return context.findElement(By.name("j_username"));
    }
    
    public WebElement getPasswordInput() {
        return context.findElement(By.name("j_password"));
    }
    
    public WebElement getLoginButton() {
        return context.findElement(By.cssSelector("input[type=submit]"));
    }
    
    public void signIn(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
    
    public void signInAsOffice() {
        signIn("LRey", userPassword);
    }
    
    public void signInAsAdmin() {
        signIn("DMitchell", userPassword);
    }
    
    public void signInAsWarehouse() {
        signIn("JDoe", userPassword);
    }
}
