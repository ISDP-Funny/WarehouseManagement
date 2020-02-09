package pl.lodz.p.it.isdp.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class NewAccountsListPage {
    private final SearchContext context;

    public NewAccountsListPage(SearchContext context) {
        this.context = context;
    }

    public NewAccountListElement findAccountByLogin(String login) {
        return new NewAccountListElement(context.findElement(
                By.xpath(String.format("//td[contains(text(), '%s')]/parent::tr", login))
        ));
    }

}
