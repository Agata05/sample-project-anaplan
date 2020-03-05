package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
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

    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement logInButton;

    public void enterLoginEmail(String login) {
        loginInput.sendKeys(login);
        log.info("Logged in with email: " + login);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
        log.info("Logged in with password: " + password);
    }

    public LaunchpadPage navigateToLaunchpadPage() {
        logInButton.click();
        log.info("Navigated to Launchpad Page");
        return new LaunchpadPage(driver);
    }


}
