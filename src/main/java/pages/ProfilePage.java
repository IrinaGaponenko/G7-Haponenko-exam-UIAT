package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static data.TestData.LOGIN_DEFAULT;

public class ProfilePage extends ParentPage {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    private WebElement headerTitle;

    @FindBy(xpath = "//li[@class='btn btn-light active' and @id='item-3']")
    private WebElement activeButtonProfile;

    @FindBy(xpath = "//div[@class='mb-3 input-group']//input[@id='searchBox']")
    private WebElement inputBookSearch;

    @FindBy(xpath = "//div[@class='mb-3 input-group']//div[@class='input-group-append']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement userName;

    @FindBy(xpath = "//button[@id='submit' and text()='Delete Account']")
    private WebElement buttonDeleteAccount;

    @FindBy(xpath = "//button[@id='submit' and text()='Log out']")
    private WebElement buttonLogOut;

    @FindBy(xpath = "//button[@id='gotoStore']")
    private WebElement buttonRedirectToBookStore;

    @FindBy(xpath = "//div[@class='text-right button di']//button[@id='submit' and text()='Delete All Books']")
    private WebElement buttonDeleteAllBooks;

    @FindBy(xpath = "//form[@id='userForm']")
    private WebElement loginForm;

    @FindBy(xpath = "//span[@id='see-book-Designing Evolvable Web APIs with ASP.NET']")
    private WebElement addedBook;

    @FindBy(xpath = "//span[@id='delete-record-undefined']")
    private WebElement buttonDeleteAddedBook;

    @FindBy(xpath = "//div[@role='row']//div[@role='gridcell']//div[@class='action-buttons']")
    private List<WebElement> tableBooksCellsWithActions;

    String expectedHeader = "Profile";

    @Override
    protected String getRelativeUrl() {
        return "/profile";
    }

    public ProfilePage openProfilePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCreds();
        checkIsRedirectToProfilePage();
        return this;
    }

    public ProfilePage checkIsRedirectToProfilePage() {
        checkUrlWithPattern();
        return this;
    }

    public String checkHeaderTitle() {
        checkIsElementDisplayed(headerTitle);
        logger.info(String.format("Header title is %s", headerTitle.getText()));
        Assert.assertEquals("Page header is not matched", expectedHeader, headerTitle.getText());
        return headerTitle.getText();
    }

    public ProfilePage checkIsActiveButtonProfile() {
        checkIsElementDisplayed(activeButtonProfile);
        return this;
    }

    public void checkIsInputBookSearchVisible() {
        checkIsElementDisplayed(inputBookSearch);
    }

    public void checkIsButtonSearchVisible() {
        checkIsElementDisplayed(buttonSearch);
    }

    public String checkUserName() {
        checkIsElementDisplayed(userName);
        logger.info(String.format("User name is %s", userName.getText()));
        Assert.assertEquals("User name is not matched", LOGIN_DEFAULT, userName.getText());
        return userName.getText();
    }

    public void checkIsButtonDeleteAccountVisible() {
        checkIsElementDisplayed(buttonDeleteAccount);
    }

    public void checkIsButtonLogOutVisible() {
        checkIsElementDisplayed(buttonLogOut);
    }

    public void checkIsButtonRedirectToBookStoreVisible() {
        checkIsElementDisplayed(buttonRedirectToBookStore);
    }

    public BookStorePage clickOnButtonRedirectToBookStore() {
        scrollHoverAndClickOnElement(buttonRedirectToBookStore);
        return new BookStorePage(webDriver);
    }

    public void checkIsButtonDeleteAllBooksVisible() {
        checkIsElementDisplayed(buttonDeleteAllBooks);
    }

    public void checkLoginFormIsNotShown(){
        checkIsElementNotDisplayed(loginForm);
    }


    public void checkAddedBookIsShown() {
        checkIsElementDisplayed(addedBook);
    }

    public void checkButtonDeleteAddedBookIsShown() {
        checkIsElementDisplayed(buttonDeleteAddedBook);
    }

    public ProfilePage clickOnButtonDeleteAddedBook() {
        scrollHoverAndClickOnElement(buttonDeleteAddedBook);
        return this;
    }

    public ProfilePage deleteAllBooks() {
        scrollHoverAndClickOnElement(buttonDeleteAllBooks);
        return this;
    }

    public void checkIsModalDialogVisible() {
        PageProvider.getModalDialogDeleteBook(webDriver).checkIsModalDialogVisible();
    }

    public void acceptModalDialog() {
        PageProvider.getModalDialogDeleteBook(webDriver).clickOnButtonOk();
    }

    public void checkIsBookDeleted() {
        checkIsElementNotDisplayed(addedBook);
    }

    public void checkIsTableBooksEmpty() {
        Assert.assertEquals("Table is not empty", 0, tableBooksCellsWithActions.size());
    }

    public void clickOnButtonLogOut() {
        hoverAndClickOnElement(buttonLogOut);
    }
}