package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class StartPage extends Pages {

    public StartPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public StartPage open() {
        super.open();
        return this;
    }

    @FindBy(name = "q")
    private WebElement searchInput;

    public boolean isSearchInputDisplayed() {
        val isSearchInputDisplayed = searchInput.isDisplayed();
        log.info("Navigate to Three Buttons Page");
        return isSearchInputDisplayed;
    }

}
