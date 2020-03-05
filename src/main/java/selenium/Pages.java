package selenium;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.configurations.TypedProperties;

@Slf4j
public abstract class Pages extends SeleniumFunctions {


    private final static TypedProperties testConfig = new TypedProperties("/test_config.properties");


    public Pages(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String baseUrl = testConfig.getValue("base_url");


    protected void open(String path) {
        driver.get(baseUrl + path);
    }

    protected Pages open() {
        driver.get(baseUrl);
        return this;
    }

    public void clickJs(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }



}
