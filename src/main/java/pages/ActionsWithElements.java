package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input " + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(elementName + " element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    public void scrollHoverAndClickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            Actions action = new Actions(webDriver);

            // Scroll to the element
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Hover over the element
            action.moveToElement(element).perform();

            // Click the element
            element.click();

            logger.info("Element " + elementName + " was clicked after hovering and scrolling");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void hoverAndClickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            Actions action = new Actions(webDriver);
            action.moveToElement(element).click().build().perform();
            logger.info("Element " + elementName + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectDateOfBirth(WebElement input, String birthDate) {
        // Click on the input field to open the date picker
        input.click();

        // Find the date picker element (you may need to adjust the selector)
        WebElement datePicker = webDriver.findElement(By.className("react-datepicker"));

        // Split the desired date into day, month, and year
        String[] dateParts = birthDate.split(" ");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        // Locate and click on the year/month dropdowns
        WebElement yearDropdown = datePicker.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.click();

        WebElement monthDropdown = datePicker.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.click();

        // Locate and click on the desired year and month
        WebElement yearOption = yearDropdown.findElement(By.xpath("//option[@value='" + year + "']"));
        yearOption.click();

        WebElement monthOption = monthDropdown.findElement(By.xpath("//option[contains(text(), '" + month + "')]"));
        monthOption.click();

        // Locate and click on the desired day
        WebElement dayElement = datePicker.findElement(By.xpath("//div[text()='" + day + "']"));
        dayElement.click();

        logger.info("Date of birth was selected: " + birthDate);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info(getElementName(element) + " element is displayed");
            } else {
                logger.info(getElementName(element) + " element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(getElementName(element) + " element is not displayed");
            return false;
        }
    }

    public void checkIsElementDisplayed(WebElement element) {
        Assert.assertTrue(getElementName(element) + " element is not displayed", isElementDisplayed(element));
    }

    public void checkIsElementNotDisplayed(WebElement element) {
        Assert.assertFalse(getElementName(element) + " element is displayed", isElementDisplayed(element));
    }

    public void alertAccept() {
        webDriverWait10.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        logger.info(alertText);
        alert.accept();
    }
}
