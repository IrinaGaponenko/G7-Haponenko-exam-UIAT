package actionsWithBooksTest;

import baseTest.BaseTest;
import org.junit.Test;

public class GetBookDetailsTest extends BaseTest {

    @Test
    public void getBookDetailsTest() {
        pageProvider.getBookStorePage().openBookStorePage()
                .clickOnLinkDesigningBook().checkIsRedirectToBookDetailsPage().checkIsBookISBNPresent();
        pageProvider.getBookDetailsPage().checkIsBookTitlePresent();
        pageProvider.getBookDetailsPage().checkIsBookSubtitlePresent();
        pageProvider.getBookDetailsPage().checkIsBookAuthorPresent();
        pageProvider.getBookDetailsPage().checkIsBookPublisherPresent();
        pageProvider.getBookDetailsPage().checkIsBookTotalPagesPresent();
        pageProvider.getBookDetailsPage().checkIsBookDescriptionPresent();
        pageProvider.getBookDetailsPage().checkIsBookWebsiteLinkPresent();
        pageProvider.getBookDetailsPage().checkIsButtonBackToBookStorePresent();
        pageProvider.getBookDetailsPage().checkIsButtonAddToYourCollectionPresent();
        pageProvider.getBookDetailsPage().checkIsListOfBooksNotPresent();
    }
}
