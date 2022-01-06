package hm1;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class DemoFormTestsWithRandomUtils extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = getRandomString(10);
    String lastName = getRandomString(14);
    String userEmail = getRandomEmail();
    String userAddress = getRandomString(12) + " " + getRandomInt(1, 99);
    String userPhone = getRandomPhone();


    @Test
    void fillDataFormTest(){
        open("/automation-practice-form");
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .selectUserGender()
                .typeUserPhone(userPhone)
                .setBirthDate("10", "5", "1988")
                .typeUserSubjects("Arts")
                .selectUserHobbies()
                .uploadUserFile()
                .typeUserAddress(userAddress)
                .selectUserState("Haryana")
                .selectUserCity("Karnal")
                .submitFillForm()
                .checkResultRegistrationForm()
                .checkResultsTable()
                .checkResultsValue("Date of Birth","10 June,1988")
                .checkResultsValue("State and City","Haryana Karnal")
                .checkCloseLargeModal();
    }
}