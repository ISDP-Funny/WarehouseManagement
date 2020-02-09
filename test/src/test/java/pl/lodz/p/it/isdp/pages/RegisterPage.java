package pl.lodz.p.it.isdp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final SearchContext context;

    public RegisterPage(SearchContext context) {
        this.context = context;
    }

    public WebElement getRegisterButton() { return this.context.findElement(By.cssSelector("[id$=register-account-button]")); }

    public void register() {
        this.getRegisterButton().click();
    }

    public WebElement getNameField() { return this.context.findElement(By.id("RegisterForm:name")); }

    public void setNameField(String name) { getNameField().sendKeys(name); }

    public WebElement getSurnameField() { return this.context.findElement(By.id("RegisterForm:surname")); }

    public void setSurnameField(String surname) { getSurnameField().sendKeys(surname); }

    public WebElement getEmailField() { return this.context.findElement(By.id("RegisterForm:email")); }

    public void setEmailField(String email) { getEmailField().sendKeys(email); }

    public WebElement getLoginField() { return this.context.findElement(By.id("RegisterForm:login")); }

    public void setLoginField(String login) { getLoginField().sendKeys(login); }

    public WebElement getPasswordField() { return this.context.findElement(By.id("RegisterForm:password")); }

    public void setPasswordField(String pass) { getPasswordField().sendKeys(pass); }

    public WebElement getConfirmPasswordField() { return this.context.findElement(By.id("RegisterForm:passwordRepeat")); }

    public void setConfirmPasswordField(String pass) { getConfirmPasswordField().sendKeys(pass); }

    public WebElement getQuestionField() { return this.context.findElement(By.id("RegisterForm:question")); }

    public void setQuestionField(String question) { getQuestionField().sendKeys(question); }

    public WebElement getAnswerField() { return this.context.findElement(By.id("RegisterForm:answer")); }

    public void setAnswerField(String answer) { getAnswerField().sendKeys(answer); }

    public void fillForm(String name, String surname, String email, String login, String password, String question,
                         String answer) {
        setNameField(name);
        setSurnameField(surname);
        setEmailField(email);
        setLoginField(login);
        setPasswordField(password);
        setConfirmPasswordField(password);
        setQuestionField(question);
        setAnswerField(answer);
    }
}
