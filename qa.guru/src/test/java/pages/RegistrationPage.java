package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderFemale = $("[for='gender-radio-1']"),
            userPhoneInput = $("#userNumber"),
            userAddressInput = $("#currentAddress"),
            userSubjectsInput = $("#subjectsInput"),
            selectUserHobbies = $("[for*='hobbies-checkbox-2']"),
            userFile = $("[class*='form-control-file']"),
            userStateHaryana = $("#react-select-3-input"),
            userCityKarnal = $("#react-select-4-input"),
            submit = $("#submit"),
            resultRegistrationForm = $("[class*=modal-content]"),
            resultsTable = $(".table-responsive"),
            resultFormText = $(byText("Thanks for submitting the form")),
            closeResultFormButton = $("#closeLargeModal");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectUserGender(){
        userGenderFemale.click();

        return this;
    }

    public RegistrationPage typeUserPhone(String value){
        userPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeUserAddress(String value){
        userAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserSubjects(String value){
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage selectUserHobbies(){
        selectUserHobbies.click();
        return this;
    }

    public RegistrationPage uploadUserFile(){
        File file = new File("src/test/resources/b2b.jpg");
        userFile.uploadFile(file);
        return this;
    }

    public RegistrationPage selectUserState(String value){
        userStateHaryana.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectUserCity(String value){
        userCityKarnal.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitFillForm(){
        submit.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkResultRegistrationForm(){
        resultRegistrationForm.should(visible);
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResultsTable(){
        resultFormText.should(appear);
        return this;
    }

    public RegistrationPage checkCloseLargeModal(){
        closeResultFormButton.should(visible);
        return this;
    }

}
