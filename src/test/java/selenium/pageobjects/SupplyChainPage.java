package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class SupplyChainPage extends Pages {

    private static final int LOAD_TIMEOUT = 10;

    public SupplyChainPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dojoxExpandoTitleNode")
    private WebElement contentsTitle;

    @FindBy(className = "dojoxExpandoIcon dojoxExpandoIconLeft qa-button-toc")
    private WebElement arrow;

    @FindBy(xpath = "//a[contains(text(),'Detailed Demand Review')]")
    private WebElement detailedDemandReviewTab;

    @FindBy(className = "valueContainer")
    private WebElement detailedDemandReviewTabTitle;

    public SupplyChainPage waitTillPageLoaded() {
        waitForElement(contentsTitle, LOAD_TIMEOUT);
        return this;
    }

    public SupplyChainPage waitTillDetailedDemandReviewTabLoaded() {
        waitForElement(contentsTitle, LOAD_TIMEOUT);
        return this;
    }

    public String getSupplyChainPageTitle() {
        return driver.getTitle();
    }

    public String getDetailedDemandReviewTabTitle() {
        return detailedDemandReviewTabTitle.getText();
    }

    public void openContentsIfClosed() {
        if (!contentsTitle.isDisplayed()) {
            clickJs(arrow);
        }
    }

    public SupplyChainPage navigateToDetailedDemandReviewTab() {
        detailedDemandReviewTab.click();
        log.info("Detailed Demand Review tab clicked.");
        waitTillDetailedDemandReviewTabLoaded();
        log.info("Navigated to Detailed Demand Review tab");
        return this;
    }


}
