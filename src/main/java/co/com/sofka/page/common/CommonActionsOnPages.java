package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(CommonActionsOnPages.class);

    private WebDriver driver;

    //Constructor
    public CommonActionsOnPages(WebDriver driver) {
        try {
            if (driver == null) {
                LOGGER.warn("El driver es nulo.");
            }
            this.driver = driver;

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Funcionalidades Genéricas

    protected void clearOn(By locator){
        driver.findElement(locator).clear();
    }

    protected void clearOn(WebElement webElement){
        webElement.clear();
    }

    protected void clickOn(By locator){
        driver.findElement(locator).click();
    }

    protected void clickOn(WebElement webElement){
        webElement.click();
    }

    protected void typeOn(By locator, CharSequence... keysToSend){
        driver.findElement(locator).sendKeys(keysToSend);
    }

    protected void typeOn(WebElement webElement, CharSequence... keysToSend){
        webElement.sendKeys(keysToSend);
    }

    protected void scrollOn(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void scrollOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void clickWithJseOn(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    protected void clickWithJseOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", webElement);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement webElement){
        return webElement.getText();
    }
}
