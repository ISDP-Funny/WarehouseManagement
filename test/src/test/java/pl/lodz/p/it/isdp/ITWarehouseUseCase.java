package pl.lodz.p.it.isdp;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.lodz.p.it.isdp.pages.MainMenuPage;
import pl.lodz.p.it.isdp.pages.SignInPage;
import pl.lodz.p.it.isdp.pages.stock.StockIssuePage;
import pl.lodz.p.it.isdp.pages.stock.StockListPage;
import pl.lodz.p.it.isdp.pages.stock.StockUpPage;

public class ITWarehouseUseCase extends DriverBase {

    @Test
    public void login() {
        WebDriver driver = getDriver();
        driver.get(getAppUrl());

        new MainMenuPage(driver).goToSignIn();
        new SignInPage(driver).signInAsWarehouse();

        new MainMenuPage(driver).getStockMenu()
                .open()
                .goToStockUp();

        StockUpPage upPage = new StockUpPage(driver);
        upPage.setContractor("0048422523923");
        upPage.setProduct("9788376266909");
        upPage.setQuantity(10);
        upPage.setLocation("AA-01-01-01");
        upPage.add();

        new MainMenuPage(driver).getStockMenu()
                .open()
                .goToStockView();

        StockListPage listPage = new StockListPage(driver);
        listPage.getProductSelect().selectByValue("9788376266909");
        listPage.getViewStockButton().click();

        listPage.getStockIssueButton().click();
        StockIssuePage issuePage = new StockIssuePage(driver);
        issuePage.getQuantityInput().sendKeys("10");
        issuePage.getApproveInput().click();
    }

}
