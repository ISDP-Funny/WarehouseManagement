package pl.lodz.p.it.isdp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.lodz.p.it.isdp.pages.MainMenuPage;
import pl.lodz.p.it.isdp.pages.RegisterPage;

import java.util.UUID;

public class ITNoRoleUseCase extends DriverBase {

    @Test
    public void register() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get(getAppUrl());

        new MainMenuPage(driver).goToRegister();
        RegisterPage page = new RegisterPage(driver);

        page.setNameField("Adam");
        page.setSurnameField("Grzegrzółka");
        page.setEmailField("adam@example.com");
        page.setLoginField("AGrz" + UUID.randomUUID().toString());
        page.setPasswordField("P@ssw0rd");
        page.setConfirmPasswordField("P@ssw0rd");
        page.setQuestionField("ASDFSGDS");
        page.setAnswerField("ASJFISJDIFJISDF");


        page.register();
    }


}
