package utils;

import org.testng.annotations.DataProvider;

import static utils.ProjectConstant.*;

public class TestData {

    @DataProvider(name = "NavigationBarTestData")
    public static Object[][] topMenuTestDataProvider() {
        return new Object[][]{
                {"nav a[href='/forHim']", FOR_HIM_URL, FOR_HIM_TITLE},
                {"nav a[href='/forHer']", BASE_URL + "forHer", "AJ Shop | For Her"},
                {"nav a[href='/']", BASE_URL, BASE_TITLE}
        };
    }


}
