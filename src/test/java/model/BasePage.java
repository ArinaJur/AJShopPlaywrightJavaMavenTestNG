package model;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {
    private Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected Page getPage() {
        return page;
    }

}
