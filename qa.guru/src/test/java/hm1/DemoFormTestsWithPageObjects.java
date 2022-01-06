package hm1;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;

public class DemoFormTestsWithPageObjects extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Elizaveta";
    String lastName = "Vetrova";
    String userPhone = "89009000505";

    @Test
    void fillDataFormTest(){
        open("/automation-practice-form");
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail("vetrovaLiza@gmail.com")
                .selectUserGender()
                .typeUserPhone(userPhone)
                .setBirthDate("10", "5", "1988")
                .typeUserSubjects("Arts")
                .selectUserHobbies()
                .uploadUserFile()
                .typeUserAddress("Tomsk, Lenina 56-2")
                .selectUserState("Haryana")
                .selectUserCity("Karnal")
                .submitFillForm()
                .checkResultRegistrationForm()
                .checkResultsTable();
        registrationPage.checkResultsValue("Student Name",firstName + " " + lastName)
                .checkResultsValue("Student Email","vetrovaLiza@gmail.com")
                .checkResultsValue("Mobile", "8900900050")
                .checkResultsValue("Date of Birth","10 June,1988")
                .checkResultsValue("Address","Tomsk, Lenina 56-2")
                .checkResultsValue("State and City","Haryana Karnal")
                .checkCloseLargeModal();
    }
}