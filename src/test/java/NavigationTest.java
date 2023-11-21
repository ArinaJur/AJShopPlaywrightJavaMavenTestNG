import model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

import static utils.ProjectConstant.BASE_TITLE;
import static utils.ProjectConstant.BASE_URL;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest extends BaseTest {

    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        assertThat(getPage()).hasURL(BASE_URL);
        assertThat(getPage()).hasTitle(BASE_TITLE);
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

    @Test
    public void testLogo_NavigatesTo_HomePage() {
        HomePage homePage = new HomePage(getPage());

        homePage.clickLogo();

        assertThat(homePage.page()).hasURL(BASE_URL);
        assertThat(homePage.page()).hasTitle(BASE_TITLE);
    }

    @Test
    public void testAboutMenu_NavigatesTo_FooterSection() {
        HomePage homePage = new HomePage(getPage());

        homePage.clickAboutMenu();

        assertThat(homePage.page()).hasURL("http://localhost:3000/#footer-about");
        assertThat(homePage.page()).hasTitle(BASE_TITLE);
    }

//    @Test(
//            dataProvider = "NavigationBarTestData",
//            dataProviderClass = TestData.class,
//            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected"
//    )
//    public void testLogo1_NavigatesTo_HomePage(Locator logoLocator, String expectedUrl, String expectedTitle) {
//
//        logoLocator.click();
//
//        assertThat(getPage()).hasURL(expectedUrl);
//        assertThat(getPage()).hasTitle(expectedTitle);
//    }
}
