package model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends NavPage {

    public HomePage(Page page) {
        super(page);
    }

    public Page page() {
        return getPage();
    }




}
