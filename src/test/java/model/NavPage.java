package model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public abstract class NavPage extends BasePage {
    private final Locator logoLocator = getPage().getByRole(AriaRole.LINK).getByRole(AriaRole.IMG, new Locator.GetByRoleOptions().setName("logo"));
    private final Locator aboutMenuLocator = getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About"));

    public NavPage(Page page) {
        super(page);
    }

    public Locator getLogoLocator() {
        return logoLocator;
    }

    public void clickLogo() {
        logoLocator.click();
    }

    public void clickAboutMenu() {
        aboutMenuLocator.click();
    }

}
