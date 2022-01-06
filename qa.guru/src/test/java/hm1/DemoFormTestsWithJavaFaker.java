package hm1;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;

public class DemoFormTestsWithJavaFaker extends TestBase{

    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userAddress = faker.address().fullAddress();


    @Test
    void fillDataFormTest(){
        open("/automation-practice-form");
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .selectUserGender()
                .typeUserPhone("8900900050")
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
                .checkResultsValue("Mobile", "8900900050")
                .checkResultsValue("Date of Birth","10 June,1988")
                .checkResultsValue("State and City","Haryana Karnal")
                .checkCloseLargeModal();
    }
}