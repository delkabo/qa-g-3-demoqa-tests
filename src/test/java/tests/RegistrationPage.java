package tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //locators
    //"#firstName"
    SelenideElement firstNameInput  = $("#firstName");
    SelenideElement firsLastNameInput  = $("#lastName");
    SelenideElement resultTable = $(".table-responsive");


    //actions
    //setValue("Kamil");
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        firsLastNameInput.setValue(lastName);
    }

    public void checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
    }
}
