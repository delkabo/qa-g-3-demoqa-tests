package Pages;

import Pages.Components.CalendarComponent;
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
            resultTable = $(".table-responsive");


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

    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
    public void setBirthDate(String month, String year, String day) {
    $("#dateOfBithInput").click();
    calendarComponent.setDate(month, year, day);
    }
}
