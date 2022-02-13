package tests;

import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstname = "Kamil";
    String lastName = "Syapukov";
    String email = "kamil@syapukov.com";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setBirthDate("may", "1990", "13")
                .setEmail(email)
                .setGender("Other")
                .setNumberUser("89999999999")
                .interests("Math")
                .hobbies("Sports")
                .uploadPicture("cv.jpg")
                .curAddress("Some address 1")
                .scrollTo()
                .stateCity("NCR")
                .scrollToCity()
                .stateCity("Noida")
                .submitButton()
                .showThanks("Thanks for submitting the form")
                .checkInput(firstname + "" + lastName)
                .checkForm("Student Name", firstname + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", "Other");
    }
}