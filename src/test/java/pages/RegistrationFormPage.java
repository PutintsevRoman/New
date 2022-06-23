package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponents;

import java.io.File;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponents resultTableComponents = new ResultTableComponents();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("[id= lastName]"),
            userEmailInput = $("[id= userEmail]"),
            userNumberInput = $("[id=userNumber]"),
            subjectsInput = $("#subjectsInput"),
            currentAddressInput = $("[id=currentAddress]"),
            fileInput = $("[id=uploadPicture]"),
            stateInput = $("[id=react-select-3-input]"),
            cityInput = $("[id=react-select-4-input]"),
            dateInput = $("[id=dateOfBirthInput]"),
            buttom = $("#submit");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");

        // Some staff
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGenderRadio(String value) {
         $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setCheckbox(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setFile(String file) {
        fileInput.uploadFromClasspath(file);
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setDate(String month, String year, String day) {
        dateInput.click();
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationFormPage submit() {
        buttom.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponents.checkResult(key, value);
        return this;
    }
}
