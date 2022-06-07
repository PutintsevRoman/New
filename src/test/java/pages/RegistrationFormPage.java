package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponents;

import java.io.File;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponents resultTableComponents = new ResultTableComponents();

    SelenideElement firstNameInput = $("#firstName")
    ,lastNameInput =$("[id= lastName]")
    ,userEmailInput = $("[id= userEmail]")
    ,userNumberInput =$("[id=userNumber]")
    ,subjectsInput =$("#subjectsInput")
    ,currentAddressInput =$("[id=currentAddress]")
    ,FileInput =$("[id=uploadPicture]")
    ,stateInput = $("[id=react-select-3-input]")
    ,cityInput =$("[id=react-select-4-input]")
    ,dateInput =$("[id=dateOfBirthInput]")
    ,buttom =$("#submit");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");

        // Some staff
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage SetfirstName() {
        firstNameInput.setValue("Alexey");
        return this;
    }
    public RegistrationFormPage SetlastName() {
        lastNameInput.setValue("Victorov");
        return this;
    }
    public RegistrationFormPage SetuserEmail() {
        userEmailInput.setValue("alex_vicktory@mail.com");
        return this;
    }
    public RegistrationFormPage SetgenderRadio(int num) {
        SelenideElement gender_radioInput =$("[for='gender-radio-"+ num +"']");
        gender_radioInput.click();
        return this;
    }

    public RegistrationFormPage SetuserNumber () {
        userNumberInput.setValue("1234567890");
        return this;
    }

    public RegistrationFormPage Setcheckbox (int num) {
        SelenideElement checkboxInput =$("[for='hobbies-checkbox-"+ num +"']");
        checkboxInput.click();
        return this;
    }

    public RegistrationFormPage Setsubject () {
        subjectsInput.setValue("H").pressEnter();
        return this;
    }

    public RegistrationFormPage SetcurrentAddress () {
        currentAddressInput.setValue("Some address");
        return this;
    }

    public RegistrationFormPage Setfile () {
        FileInput.uploadFile(new
                File("src\\test\\resources\\a.png"));
        return this;
        }
    public RegistrationFormPage SetCity () {
        cityInput.setValue("Noida").pressEnter();
        return this;
    }
    public RegistrationFormPage SetState () {
        stateInput.setValue("NCR").pressEnter();
        return this;
    }
    public RegistrationFormPage SetDate (String month, String year,String day) {
        dateInput.click();
        calendar.setDate(month, year, day);
        return this;
    }
    public RegistrationFormPage Submit () {
        buttom.click();
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponents.checkResult(key,value);
        return this;
    }
}
