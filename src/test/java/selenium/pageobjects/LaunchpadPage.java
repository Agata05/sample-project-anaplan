package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class LaunchpadPage extends Pages {

    public LaunchpadPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "labelText")
    private WebElement supplyTitle;

    public SupplyChainPage navigateToSupplyChainPage() {
        clickJs(supplyTitle);
        log.info("Clicked on Supply Chain - For tests title");
        return new SupplyChainPage(driver).waitTillPageLoaded();
    }


}
