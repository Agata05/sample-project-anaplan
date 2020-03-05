package selenium.testcases;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.pageobjects.LaunchpadPage;
import selenium.pageobjects.StartPage;
import selenium.pageobjects.SupplyChainPage;

public class AnaplanTest extends BaseTest {

    @BeforeClass
    public void setup() {
        startPage = new StartPage(getDriver())
                .open();
    }

    static final String ANAPLAN_CHAIN_TITLE = "Anaplan - Supply Chain - For tests";
    static final String DETAILED_DEMAND_REVIEW_TITLE = "Detailed Demand Review";
    SupplyChainPage supplyChainPage;

    @Test(priority = 1)
    public void checkAnaplanSupplyChainTitle() {

        startPage.enterLoginEmail(getTestConfig().getLogin());
        startPage.enterPassword(getTestConfig().getPassword());
        LaunchpadPage launchpadPage = startPage.navigateToLaunchpadPage();
        supplyChainPage = launchpadPage.navigateToSupplyChainPage();
        val supplyChainPageTitle = supplyChainPage.getSupplyChainPageTitle();

        Assert.assertEquals(supplyChainPageTitle, ANAPLAN_CHAIN_TITLE, "Anaplan - Supply Chain title: ");
    }

    @Test(priority = 2)
    public void checkDetailedDemandReviewTitle() {

        supplyChainPage.openContentsIfClosed();
        supplyChainPage.navigateToDetailedDemandReviewTab();
        val detailedDemandReviewTabTitle = supplyChainPage.getDetailedDemandReviewTabTitle();

        Assert.assertEquals(detailedDemandReviewTabTitle, DETAILED_DEMAND_REVIEW_TITLE, "Detailed Demand Review title: ");

    }

    @Test(priority = 3)
    public void checkFinalForecast() {

        Assert.fail("Test not implemented due to time constraint.");
    }


}
