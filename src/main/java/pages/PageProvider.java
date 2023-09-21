package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.ModalDialogDeleteBook;
import pages.elements.ModalDialogRegistration;

public class PageProvider {

    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(webDriver);
    }
    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public ProfilePage getProfilePage() {
        return new ProfilePage(webDriver);
    }

    public BookStorePage getBookStorePage() {
        return new BookStorePage(webDriver);
    }

    public BookDetailsPage getBookDetailsPage() {
        return new BookDetailsPage(webDriver);
    }

    public static ModalDialogDeleteBook getModalDialogDeleteBook(WebDriver webDriver) {
        return new ModalDialogDeleteBook(webDriver);
    }

    public static ModalDialogRegistration getModalDialogRegistration(WebDriver webDriver) {
        return new ModalDialogRegistration(webDriver);
    }
}
