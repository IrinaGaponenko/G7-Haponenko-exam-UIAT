package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends ParentPage {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/automation-practice-form";
    }

    @FindBy(id = "firstName")
    private WebElement inputFirstName;

    @FindBy(id = "lastName")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@value='Female']")
    private WebElement radiobuttonGenderFemale;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement inputMobile;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement inputBirthDate;

    @FindBy(id = "submit")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='header-text' and text()='Elements']")
    private WebElement leftMenuElements;

    public void showEntireRegForm() {
        clickOnElement(leftMenuElements);
    }

    public void selectDateOfBirth(String birthDate) {
        selectDateOfBirth(inputBirthDate, birthDate);
    }

    public void openRegistrationPage() {
        webDriver.get(BASE_URL + getRelativeUrl());
    }

    public void enterTextIntoInputFirstName(String firstName) {
        enterTextIntoInput(inputFirstName, firstName);
    }

    public void enterTextIntoInputLastName(String lastName) {
        enterTextIntoInput(inputLastName, lastName);
    }

    public void enterTextIntoInputEmail(String email) {
        enterTextIntoInput(inputEmail, email);
    }

    public void enterTextIntoInputMobile(String mobile) {
        enterTextIntoInput(inputMobile, mobile);
    }

    public void clickOnRadiobuttonGenderFemale() {
        hoverAndClickOnElement(radiobuttonGenderFemale);
    }

    public void clickOnButtonSubmit() {
        scrollHoverAndClickOnElement(buttonSubmit);
    }

    public void checkIsModalDialogRegistrationShown() {
        PageProvider.getModalDialogRegistration(webDriver).checkIsModalDialogRegistrationShown();
    }

    public void checkIsStudentNameShown(){
        PageProvider.getModalDialogRegistration(webDriver).checkIsStudentNameShown();
    }

    //check is username in modal dialog matches firstName + " " + lastName from registration form
    public void checkIsStudentNameMatches(String firstName, String lastName){
        String studentName = PageProvider.getModalDialogRegistration(webDriver).getStudentName();
        Assert.assertEquals("Student name in modal dialog does not match", firstName + " " + lastName, studentName);
    }

    public void closeModalDialogRegistration() {
        PageProvider.getModalDialogRegistration(webDriver).clickOnButtonClose();
    }
}
