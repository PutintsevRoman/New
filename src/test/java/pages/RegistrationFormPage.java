package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponents;

import java.io.File;


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

    public RegistrationFormPage setFirstName() {
        firstNameInput.setValue("Alexey");
        return this;
    }

    public RegistrationFormPage setLastName() {
        lastNameInput.setValue("Victorov");
        return this;
    }

    public RegistrationFormPage setUserEmail() {
        userEmailInput.setValue("alex_vicktory@mail.com");
        return this;
    }

    public RegistrationFormPage setGenderRadio(int num) {
        SelenideElement gender_radioInput = $("[for='gender-radio-" + num + "']");
        gender_radioInput.click();
        return this;
    }

    public RegistrationFormPage setUserNumber() {
        userNumberInput.setValue("1234567890");
        return this;
    }

    public RegistrationFormPage setCheckbox(int num) {
        SelenideElement checkboxInput = $("[for='hobbies-checkbox-" + num + "']");
        checkboxInput.click();
        return this;
    }

    public RegistrationFormPage setSubject() {
        subjectsInput.setValue("H").pressEnter();
        return this;
    }

    public RegistrationFormPage setCurrentAddress() {
        currentAddressInput.setValue("Some address");
        return this;
    }

    public RegistrationFormPage setFile() {
        fileInput.uploadFile(new
                File("src\\test\\resources\\a.png"));
        return this;
    }

    public RegistrationFormPage setCity() {
        cityInput.setValue("Noida").pressEnter();
        return this;
    }

    public RegistrationFormPage setState() {
        stateInput.setValue("NCR").pressEnter();
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
