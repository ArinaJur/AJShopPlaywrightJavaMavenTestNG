import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

import static utils.ProjectConstant.BASE_TITLE;
import static utils.ProjectConstant.BASE_URL;

public class NavigationTest extends BaseTest {

    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        Assert.assertEquals(getPage().url(), BASE_URL);
        Assert.assertEquals(getPage().title(), BASE_TITLE);
    }

    @Test(
            dataProvider = "NavigationBarTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected"
    )
    public void testNavBarMenu_NavigatesTo_CorrespondedPage(String cssSelector, String expectedUrl, String expectedTitle) {
        String logoCss = "nav a[href='/']";

        getPage().locator(cssSelector).click();

        String actualUrl = getPage().url();
        String actualTitle = getPage().title();

        if(!cssSelector.equals(logoCss)) {
            Assert.assertNotEquals(BASE_URL, actualUrl);
            Assert.assertNotEquals(BASE_TITLE, actualTitle);
        }

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
