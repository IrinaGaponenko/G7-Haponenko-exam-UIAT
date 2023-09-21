package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.TestData.LOGIN_DEFAULT;

public class BookStorePage extends ParentPage {

    public BookStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    String expectedHeader = "Book Store";

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    private WebElement headerTitle;

    @FindBy(xpath = "//div[@class='ReactTable -striped -highlight']")
    private WebElement tableBooks;

    @FindBy(xpath = "//li[@class='btn btn-light active' and @id='item-2']")
    private WebElement activeButtonBookStore;

    @FindBy(xpath = "//button[@id='submit' and text()='Log out']")
    private WebElement buttonLogOut;

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement userName;

    @FindBy(xpath = "//div[@class='mb-3 input-group']//input[@id='searchBox']")
    private WebElement inputBookSearch;

    @FindBy(xpath = "//div[@class='mb-3 input-group']//div[@class='input-group-append']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//span[@id='see-book-Designing Evolvable Web APIs with ASP.NET']")
    private WebElement linkDesigningBook;

    @Override
    protected String getRelativeUrl() {
        return "/books";
    }

    public BookStorePage checkIsRedirectBookStorePage() {
        checkUrlWithPattern();
        return this;
    }

    public String checkHeaderTitle() {
        checkIsElementDisplayed(headerTitle);
        logger.info(String.format("Header title is %s", headerTitle.getText()));
        Assert.assertEquals("Page header is not matched", expectedHeader, headerTitle.getText());
        return headerTitle.getText();
    }

    public BookStorePage checkIsActiveButtonBookStore() {
        checkIsElementDisplayed(activeButtonBookStore);
        return this;
    }

    public BookStorePage checkIsTableBooksVisible() {
        checkIsElementDisplayed(tableBooks);
        return this;
    }

    // checkIsTableBooksNotEmpty
    public void checkIsTableBooksNotEmpty() {
        checkIsTableBooksVisible();
        Assert.assertTrue("Table is empty", tableBooks.getText().length() > 0);
    }

    public void checkIsButtonLogOutVisible() {
        checkIsElementDisplayed(buttonLogOut);
    }

    public String checkUserName() {
        checkIsElementDisplayed(userName);
        logger.info(String.format("User name is %s", userName.getText()));
        Assert.assertEquals("User name is not matched", LOGIN_DEFAULT, userName.getText());
        return userName.getText();
    }

    public void checkIsInputBookSearchVisible() {
        checkIsElementDisplayed(inputBookSearch);
    }

    public void checkIsButtonSearchVisible() {
        checkIsElementDisplayed(buttonSearch);
    }

    public BookStorePage openBookStorePage() {
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.openProfilePage();
        profilePage.clickOnButtonRedirectToBookStore();
        checkIsRedirectToBookStorePage();
        return this;
    }

    public BookStorePage checkIsRedirectToBookStorePage() {
        checkUrlWithPattern();
        return this;
    }

    public BookDetailsPage clickOnLinkDesigningBook() {
        scrollHoverAndClickOnElement(linkDesigningBook);
        return new BookDetailsPage(webDriver);
    }
}
