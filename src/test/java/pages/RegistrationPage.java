package pages;

import pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //components
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput  = $("#firstName"),
            firsLastNameInput  = $("#lastName"),
            resultTable = $(".table-responsive"),
            inpDate = $("#dateOfBirthInput"),
            inpEmail = $("#userEmail"),
            inpGender = $("#genterWrapper"),
            inpNumber = $("#userNumber"),
            inpInterests = $("#subjectsInput"),
            inpHobbie = $("#hobbiesWrapper"),
            inpUpload = $("#uploadPicture"),
            inpAddress = $("#currentAddress"),
            inpScrollTo = $("#state"),
            inpStateCity = $("#stateCity-wrapper"),
            inpClickCity = $("#city"),
            inpStateCity2 = $("#stateCity-wrapper"),
            inpSumitButton = $("#submit"),
            inpThanksText = $("#example-modal-sizes-title-lg"),
            inpCheck = $(".table-responsive").$(byText("Student Name"));


    //actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        firsLastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setBirthDate(String month, String year, String day) {
        inpDate.click();
        calendarComponent.setDate(month, year, day);
    return this;
    }

    public RegistrationPage setEmail(String email) {
        inpEmail.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        inpGender.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumberUser(String numberUser) {
        inpNumber.setValue(numberUser);
        return this;
    }

    public RegistrationPage interests(String nameInterest) {
        inpInterests.setValue(nameInterest).pressEnter();
        return this;
    }

    public RegistrationPage hobbies(String nameHob) {
        inpHobbie.$(byText(nameHob)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String nameFile) {
        inpUpload.uploadFromClasspath(nameFile);
        return this;
    }

    public RegistrationPage curAddress(String nameAddress) {
        inpAddress.setValue(nameAddress);
        return this;
    }

    public RegistrationPage scrollTo() {
        inpScrollTo.scrollTo().click();
        return this;
    }

    public RegistrationPage stateCity(String nameCity) {
        inpStateCity.$(byText(nameCity)).click();
        return this;
    }

    public RegistrationPage scrollToCity() {
        inpClickCity.click();
        return this;
    }

    public RegistrationPage submitButton() {
        inpSumitButton.click();
        return this;
    }

    public RegistrationPage showThanks(String thanksText) {
        inpThanksText.shouldHave(text(thanksText));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }


}
