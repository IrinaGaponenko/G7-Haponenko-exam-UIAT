package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class ModalDialogRegistration extends ActionsWithElements {
    public ModalDialogRegistration(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modalDialog;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
    private WebElement buttonClose;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//tr[.//td[contains(text(),'Student Name')]]//td[2]")
    private WebElement studentName;

    public void checkIsModalDialogRegistrationShown() {
        checkIsElementDisplayed(modalDialog);
    }

    public void checkIsStudentNameShown(){
        checkIsElementDisplayed(studentName);
    }

    public String getStudentName(){
        return studentName.getText();
    }

    public void clickOnButtonClose() {
        hoverAndClickOnElement(buttonClose);
    }
}
