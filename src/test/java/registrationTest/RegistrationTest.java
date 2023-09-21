package registrationTest;

import baseTest.BaseTest;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    private String firstName = "Iryna";
    private String lastName = "Haponenko";
    private String email = "irynag7@mailinator.com";
    private String mobile = "0984353531";
    private String birthDate = "24 August 1988";

    @Test
    public void registrationTest() {
        pageProvider.getRegistrationPage().openRegistrationPage();
        pageProvider.getRegistrationPage().showEntireRegForm();
        pageProvider.getRegistrationPage().enterTextIntoInputFirstName(firstName);
        pageProvider.getRegistrationPage().enterTextIntoInputLastName(lastName);
        pageProvider.getRegistrationPage().enterTextIntoInputEmail(email);
        pageProvider.getRegistrationPage().enterTextIntoInputMobile(mobile);
        pageProvider.getRegistrationPage().selectDateOfBirth(birthDate);
        pageProvider.getRegistrationPage().clickOnRadiobuttonGenderFemale();
        pageProvider.getRegistrationPage().clickOnButtonSubmit();
        pageProvider.getRegistrationPage().checkIsModalDialogRegistrationShown();
        pageProvider.getRegistrationPage().checkIsStudentNameShown();
        pageProvider.getRegistrationPage().checkIsStudentNameMatches(firstName, lastName);

        pageProvider.getRegistrationPage().closeModalDialogRegistration();

    }
}
