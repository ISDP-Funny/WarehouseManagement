package pl.lodz.p.it.isdp;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.lodz.p.it.isdp.pages.MainMenuPage;
import pl.lodz.p.it.isdp.pages.product.ProductCreatePage;
import pl.lodz.p.it.isdp.pages.product.ProductListPage;
import pl.lodz.p.it.isdp.pages.SignInPage;
import pl.lodz.p.it.isdp.pages.product.ProductDeleteConfirmPage;

public class ITOfficeUseCase extends DriverBase {

    @Test
    public void createAndDeleteProduct() {
        WebDriver driver = getDriver();
        driver.get(getAppUrl());
        
        new MainMenuPage(driver).goToSignIn();
        new SignInPage(driver).signInAsOffice();
        
        new MainMenuPage(driver).getProductMenu()
                .open()
                .goToProductCreate();
        
        ProductCreatePage productCreatePage = new ProductCreatePage(driver);
        long productSymbol = ThreadLocalRandom.current().nextLong(1_000_000_000_000L, 9_000_000_000_000L);
        productCreatePage.setProductSymbol(productSymbol);
        productCreatePage.setDescription("Opis " + UUID.randomUUID().toString());
        productCreatePage.setPrice(20.0);
        productCreatePage.setWeight(150);
        productCreatePage.create();

        
        new MainMenuPage(driver).getProductMenu()
                .open()
                .goToProductList();
        
        new ProductListPage(driver).findProductBySymbol(productSymbol)
                .goToDelete();
        
        new ProductDeleteConfirmPage(driver).confirm();
    }


}
