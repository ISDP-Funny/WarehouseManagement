package pl.lodz.p.it.isdp.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage {
    private final SearchContext context;

    public RegisterAccountPage(SearchContext context) {
        this.context = context;
    }
    public WebElement getNameInput() {
        return context.findElement(By.id("RegisterForm:name"));
    }
    public WebElement getSurnameInput() {
        return context.findElement(By.id("RegisterForm:surname"));
    }
    public WebElement getEmailInput() {
        return context.findElement(By.id("RegisterForm:email"));
    }
    public WebElement getLoginInput() {
        return context.findElement(By.id("RegisterForm:login"));
    }
    public WebElement getPasswordInput() {
        return context.findElement(By.id("RegisterForm:password"));
    }
    public WebElement getPasswordRepeatInput() {
        return context.findElement(By.id("RegisterForm:passwordRepeat"));
    }
    public WebElement getQuestionInput() {
        return context.findElement(By.id("RegisterForm:question"));
    }
    public WebElement getAnswerInput() {
        return context.findElement(By.id("RegisterForm:answer"));
    }
    public WebElement getRegisterButton() {
        return context.findElement(By.cssSelector("[id$=register-account-button]"));
    }
    public void setName(String input) {
        getNameInput().sendKeys(input);
    }
    public void setSurname(String input) {
        getSurnameInput().sendKeys(input);
    }
    public void setEmail(String input) {
        getEmailInput().sendKeys(input);
    }
    public void setLogin(String input) {
        getLoginInput().sendKeys(input);
    }
    public void setPassword(String input) {
        getPasswordInput().sendKeys(input);
    }
    public void setPasswordRepeat(String input) {
        getPasswordRepeatInput().sendKeys(input);
    }
    public void setQuestion(String input) {
        getQuestionInput().sendKeys(input);
    }
    public void setAnswer(String input) {
        getAnswerInput().sendKeys(input);
    }
    public void fillForm(String name, String surname, String email, String login, String password, String question,
                         String answer) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setLogin(login);
        setPassword(password);
        setPasswordRepeat(password);
        setQuestion(question);
        setAnswer(answer);
    }
    public void register() {
        getRegisterButton().click();
    }
}
