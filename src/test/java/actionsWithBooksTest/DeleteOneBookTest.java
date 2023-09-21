package actionsWithBooksTest;

import baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class DeleteOneBookTest extends BaseTest {

    @Before
    public void addBookToUserCollection() {
        pageProvider.getBookDetailsPage().openBookDetailsPage()
                .clickOnButtonAddToYourCollection();
        pageProvider.getBookDetailsPage().alertAccept();
        pageProvider.getBookDetailsPage().clickOnButtonProfile().checkIsRedirectToProfilePage();

        pageProvider.getProfilePage().checkAddedBookIsShown();
        pageProvider.getProfilePage().checkButtonDeleteAddedBookIsShown();
    }

    @Test
    public void deleteOneBookTest() {
        pageProvider.getProfilePage().checkIsRedirectToProfilePage()
                .clickOnButtonDeleteAddedBook().checkIsModalDialogVisible();
                pageProvider.getProfilePage().acceptModalDialog();
                pageProvider.getProfilePage().alertAccept();
                pageProvider.getProfilePage().checkIsBookDeleted();
    }
}
