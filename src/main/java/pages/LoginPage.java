package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement buttonLogOut;


    @Override
    protected String getRelativeUrl() {
        return "/login";
    }

    public void openLoginPage() {
        openPage(BASE_URL + getRelativeUrl());
        checkUrl();
    }

    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonLogIn() {
        clickOnElement(buttonSignIn);
    }

    public boolean checkIsButtonLogOutVisible() {
        return isElementDisplayed(buttonLogOut);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(LOGIN_DEFAULT);
        enterTextIntoInputPassword(PASSWORD_DEFAULT);
        clickOnButtonLogIn();
    }

    public LoginPage checkIsRedirectToLoginPage() {
        checkUrl();
        logger.info("login page was opened");
        return this;
    }
}
