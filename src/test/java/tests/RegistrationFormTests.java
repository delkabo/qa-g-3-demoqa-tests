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
                .setBirthDate("may", "1990", "13");
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("cv.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Kamil Syapukov"));
        registrationPage
                    .checkForm("Student Name", firstname + " " + lastName)
                    .checkForm("Student Email", email)
                    .checkForm("Gender", "Other");
    }
}