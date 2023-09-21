package pages.elements;

import libs.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ActionsWithElements;

public class ModalDialogDeleteBook extends ActionsWithElements {

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modalDialog;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement buttonClose;

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    private WebElement buttonOk;

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    private WebElement buttonCancel;

    public ModalDialogDeleteBook(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsModalDialogVisible() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(modalDialog));
        checkIsElementDisplayed(modalDialog);
    }

    public void clickOnButtonClose() {
        hoverAndClickOnElement(buttonClose);
    }

    public void clickOnButtonOk() {
//Util (wait a bit) замість try/catch
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Util.waitABit(1);
        hoverAndClickOnElement(buttonOk);
    }

    public void clickOnButtonCancel() {
        hoverAndClickOnElement(buttonCancel);
    }
}