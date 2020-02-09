package pl.lodz.p.it.isdp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.*;
import pl.lodz.p.it.isdp.pages.MainMenuPage;
import pl.lodz.p.it.isdp.pages.SignInPage;
import pl.lodz.p.it.isdp.pages.account.DeleteAccountPage;
import pl.lodz.p.it.isdp.pages.account.NewAccountsListPage;
import pl.lodz.p.it.isdp.pages.account.RegisterAccountPage;

public class ITAdminUseCase extends DriverBase {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAdmin() {
        WebDriver driver = getDriver();
        driver.get(getAppUrl());

        new MainMenuPage(driver)
                .goToSignIn();

        new SignInPage(driver)
                .signInAsAdmin();

        MainMenuPage mainPage = new MainMenuPage(driver);
        Assert.assertTrue(mainPage.getFooterText().getText().contains("DMitchell"));

        mainPage.goToRegisterAccount();

        RegisterAccountPage page = new RegisterAccountPage(driver);
        page.fillForm("Yan","Kovalski","kovalsky@example.com","YKovalsky",
                "P@ssw0rd","Favorite number?", "1");
        page.register();

        new MainMenuPage(driver)
                .getUserMenu()
                .open()
                .goToNewAccounts();

        new NewAccountsListPage(driver)
                .findAccountByLogin("YKovalsky")
                .goToDeletePage();

        DeleteAccountPage deletePage = new DeleteAccountPage(driver);
        Assert.assertEquals("YKovalsky", deletePage.getNameSpan().getText());

        deletePage.delete();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/listNewAccounts.xhtml"));

        exception.expect(NoSuchElementException.class);
        new NewAccountsListPage(driver).findAccountByLogin("YKovalsky");
    }

}
