package selenium.testcases;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageobjects.StartPage;

public class GoogleTest extends BaseTest {

    @BeforeClass
    public void setup() {
        startPage = new StartPage(getDriver())
                .open();
    }

    @Test
    public void checkIfSearchInputIsDisplayed() {

        val isSearchInputDisplayed = startPage.isSearchInputDisplayed();
        Assert.assertTrue(isSearchInputDisplayed, "Is search input displayed?");

    }
}
