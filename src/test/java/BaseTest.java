import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static utils.ProjectConstant.BASE_URL;

public abstract class BaseTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    protected void beforeSuite() {
        playwright = Playwright.create();
    }

    @BeforeTest
    protected void beforeTest() {
        browser = playwright.chromium()
                .launch(
                        new BrowserType
                                .LaunchOptions()
                                .setHeadless(false)
                );
    }

    @BeforeMethod
    protected void beforeMethod() {
        context = browser.newContext();
        page = context.newPage();

        page.navigate(BASE_URL);
    }

    @AfterMethod
    protected void afterMethod() {
        context.close();
    }

    @AfterSuite
    protected void afterSuits() {
        playwright.close();
    }

    protected Page getPage() {
        return page;
    }
}
