package tests;

import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
                .setBirthDate("May", "1990", "17")
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
                .checkForm("Student Name", firstname + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", "Other")
                .checkForm("Mobile", "8999999999")
                .checkForm("Date of Birth", "17 May,1990")
                .checkForm("Subjects", "Maths")
                .checkForm("Hobbies", "Sports")
                .checkForm("Picture", "cv.jpg")
                .checkForm("Address", "Some address 1")
                .checkForm("State and City", "NCR Noida");
    }
}