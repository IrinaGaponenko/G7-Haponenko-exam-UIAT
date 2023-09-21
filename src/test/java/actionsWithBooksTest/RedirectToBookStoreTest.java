package actionsWithBooksTest;

import baseTest.BaseTest;
import org.junit.Test;

public class RedirectToBookStoreTest extends BaseTest {

    @Test
    public void redirectToBookStoreTest() {
        pageProvider.getProfilePage().openProfilePage()
                .clickOnButtonRedirectToBookStore().checkIsRedirectBookStorePage()
                .checkHeaderTitle();
        pageProvider.getBookStorePage().checkIsActiveButtonBookStore();
        pageProvider.getBookStorePage().checkIsTableBooksVisible().checkIsTableBooksNotEmpty();
        pageProvider.getBookStorePage().checkIsButtonLogOutVisible();
        pageProvider.getBookStorePage().checkIsInputBookSearchVisible();
        pageProvider.getBookStorePage().checkIsButtonSearchVisible();
        pageProvider.getBookStorePage().checkUserName();
    }
}
