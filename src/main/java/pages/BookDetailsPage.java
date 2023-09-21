package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookDetailsPage extends ParentPage {
    public BookDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='ISBN-wrapper']//div[@class='col-md-9 col-sm-12']")
    private WebElement bookISBN;

    @FindBy(xpath = "//div[@id='title-wrapper']//label[@id='userName-value']")
    private WebElement bookTitle;

    @FindBy(xpath = "//div[@id='subtitle-wrapper']//label[@id='userName-value']")
    private WebElement bookSubtitle;

    @FindBy(xpath = "//div[@id='author-wrapper']//label[@id='userName-value']")
    private WebElement bookAuthor;

    @FindBy(xpath = "//div[@id='publisher-wrapper']//label[@id='userName-value']")
    private WebElement bookPublisher;

    @FindBy(xpath = "//div[@id='pages-wrapper']//label[@id='userName-value']")
    private WebElement bookPages;

    @FindBy(xpath = "//div[@id='description-wrapper']//label[@id='userName-value']")
    private WebElement bookDescription;

    @FindBy(xpath = "//div[@id='website-wrapper']//label[@id='userName-value']")
    private WebElement bookWebsiteLink;

    @FindBy(xpath = "//button[@id='addNewRecordButton' and text()='Back To Book Store']")
    private WebElement buttonBackToBookStore;

    @FindBy(xpath = "//button[@id='addNewRecordButton' and text()='Add To Your Collection']")
    private WebElement buttonAddToYourCollection;

    @FindBy(xpath = "//div[@class='ReactTable -striped -highlight']")
    private WebElement tableBooks;

    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement menuButtonProfile;

    @Override
    protected String getRelativeUrl() {
        return "/books\\?book=.*";
    }

    public BookDetailsPage checkIsRedirectToBookDetailsPage() {
        checkUrlWithPattern();
        return this;
    }

    public void checkIsBookISBNPresent() {
        checkIsElementDisplayed(bookISBN);
        logger.info(String.format("Book ISBN is %s", bookISBN.getText()));
    }

    public void checkIsBookTitlePresent() {
        checkIsElementDisplayed(bookTitle);
        logger.info(String.format("Book title is %s", bookTitle.getText()));
    }

    public void checkIsBookSubtitlePresent() {
        checkIsElementDisplayed(bookSubtitle);
        logger.info(String.format("Book subtitle is %s", bookSubtitle.getText()));
    }

    public void checkIsBookAuthorPresent() {
        checkIsElementDisplayed(bookAuthor);
        logger.info(String.format("Book author is %s", bookAuthor.getText()));
    }

    public void checkIsBookPublisherPresent() {
        checkIsElementDisplayed(bookPublisher);
        logger.info(String.format("Book publisher is %s", bookPublisher.getText()));
    }

    public void checkIsBookTotalPagesPresent() {
        checkIsElementDisplayed(bookPages);
        logger.info(String.format("Number of pages is %s", bookPages.getText()));
    }

    public void checkIsBookDescriptionPresent() {
        checkIsElementDisplayed(bookDescription);
        logger.info(String.format("Book description is %s", bookDescription.getText()));
    }

    public void checkIsBookWebsiteLinkPresent() {
        checkIsElementDisplayed(bookWebsiteLink);
        logger.info(String.format("Book website link is %s", bookWebsiteLink.getText()));
    }

    public void checkIsButtonBackToBookStorePresent() {
        checkIsElementDisplayed(buttonBackToBookStore);
    }

    public void checkIsButtonAddToYourCollectionPresent() {
        checkIsElementDisplayed(buttonAddToYourCollection);
    }

    public void checkIsListOfBooksNotPresent() {
        checkIsElementNotDisplayed(tableBooks);
    }

    public BookDetailsPage openBookDetailsPage() {
        BookStorePage bookStorePage = new BookStorePage(webDriver);
        bookStorePage.openBookStorePage();
        bookStorePage.clickOnLinkDesigningBook();
        checkIsRedirectToBookDetailsPage();
        return this;
    }

    public BookDetailsPage clickOnButtonAddToYourCollection() {
        scrollHoverAndClickOnElement(buttonAddToYourCollection);
        return this;
    }


    public ProfilePage clickOnButtonProfile() {
        hoverAndClickOnElement(menuButtonProfile);
        return new ProfilePage(webDriver);
    }
}
