package loginTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonLogIn();

        pageProvider.getProfilePage().checkIsRedirectToProfilePage();
        pageProvider.getProfilePage().checkHeaderTitle();
        pageProvider.getProfilePage().checkIsActiveButtonProfile();
        pageProvider.getProfilePage().checkIsInputBookSearchVisible();
        pageProvider.getProfilePage().checkIsButtonSearchVisible();
        pageProvider.getProfilePage().checkUserName();
        pageProvider.getProfilePage().checkIsButtonDeleteAccountVisible();
        pageProvider.getProfilePage().checkIsButtonLogOutVisible();
        pageProvider.getProfilePage().checkIsButtonRedirectToBookStoreVisible();
        pageProvider.getProfilePage().checkIsButtonDeleteAllBooksVisible();
        pageProvider.getProfilePage().checkLoginFormIsNotShown();
    }

    @After
    public void logout() {
        pageProvider.getProfilePage().clickOnButtonLogOut();
        pageProvider.getLoginPage().checkIsRedirectToLoginPage();
    }
}
