import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        String expectedHomeURL = "http://localhost:3000/";
        String expectedHomeTitle = "AJ Shop | Timeless Clothing For Him and For Her";

        Assert.assertEquals(getPage().url(), expectedHomeURL);
        Assert.assertEquals(getPage().title(), expectedHomeTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuForHim_NavigatesTo_ForHimPage() {
        String expectedForHimUrl = "http://localhost:3000/forHim";
        String expectedForHimTitle = "AJ Shop | For Him";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav a[href='/forHim']").click();

        String forHimUrl = getPage().url();
        String forHimTitle = getPage().title();

        Assert.assertNotEquals(homeURL, forHimUrl);
        Assert.assertNotEquals(homeTitle, forHimTitle);

        Assert.assertEquals(forHimUrl, expectedForHimUrl);
        Assert.assertEquals(forHimTitle, expectedForHimTitle);
    }
}
