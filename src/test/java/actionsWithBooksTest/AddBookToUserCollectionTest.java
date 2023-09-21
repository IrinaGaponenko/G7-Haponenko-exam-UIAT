package actionsWithBooksTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddBookToUserCollectionTest extends BaseTest {

    @Before
    public void deleteAllBooks() {
        pageProvider.getProfilePage().openProfilePage().deleteAllBooks();
        pageProvider.getProfilePage().checkIsModalDialogVisible();
        pageProvider.getProfilePage().acceptModalDialog();
        pageProvider.getProfilePage().alertAccept();
        pageProvider.getProfilePage().checkIsTableBooksEmpty();
    }

    @Test
    public void addBookToUserCollectionTest() {
        pageProvider.getProfilePage().clickOnButtonRedirectToBookStore().clickOnLinkDesigningBook();
        pageProvider.getBookDetailsPage().clickOnButtonAddToYourCollection();
        pageProvider.getBookDetailsPage().alertAccept();
        pageProvider.getBookDetailsPage().clickOnButtonProfile().checkIsRedirectToProfilePage();

        pageProvider.getProfilePage().checkAddedBookIsShown();
        pageProvider.getProfilePage().checkButtonDeleteAddedBookIsShown();
    }

    @After
    public void deleteAddedBook() {
        pageProvider.getProfilePage().clickOnButtonDeleteAddedBook();
        pageProvider.getProfilePage().checkIsModalDialogVisible();
        pageProvider.getProfilePage().acceptModalDialog();
        pageProvider.getProfilePage().alertAccept();
        pageProvider.getProfilePage().checkIsBookDeleted();
    }
}
