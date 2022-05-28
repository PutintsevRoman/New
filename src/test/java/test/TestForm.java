package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void conf(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1366x768";
        Configuration.browserPosition = "00x00";
    }

    @Test
    void FirstTest(){
        open("/automation-practice-form");

        // Some staff
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Text
        $("[id= firstName]").setValue("Alexey");
        $("[id= lastName]").setValue("Victorov");
        $("[id= userEmail]").setValue("alex_vicktory@mail.com");

        // Radio
        $("[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("123123123");

        // Date
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label = 'Choose Tuesday, August 21st, 1990']").click();

        //Subject
        $("#subjectsInput").setValue("H").pressEnter();

        //Checkboxes
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("[for='hobbies-checkbox-2']").click();

        //File
        $("[id=uploadPicture]").uploadFile(new
                File("C:\\Users\\putin\\IdeaProjects\\Home\\a.png"));

        //address
        $("[id=currentAddress]").setValue("Some address");

        //Lists
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Noida").pressEnter();

        //Button
        $("#submit").click();


        //Checks
        $("#firstName.mr-sm-2.form-control").shouldHave(value("Alexey"));
        $("#lastName.mr-sm-2.form-control").shouldHave(value("Victorov"));
        $("#gender-radio-1.custom-control-input").shouldHave(checked);
        $("#userNumber.mr-sm-2.form-control").shouldHave(value("123123123"));
        $("#dateOfBirthInput.form-control").shouldHave(value("21 Aug 1990"));
        $("[id = subjectsWrapper]").shouldHave(text("Hindi"));
        $("#hobbies-checkbox-1.custom-control-input").shouldHave(checked);
        $("#hobbies-checkbox-3.custom-control-input").shouldHave(checked);
        $("#hobbies-checkbox-2.custom-control-input").shouldNotHave(checked);
        $("#currentAddress.form-control").shouldHave(value("Some address"));
        $("[id = stateCity-wrapper]").shouldHave(text("NCR"));
        $("[id = stateCity-wrapper]").shouldHave(text("Noida"));
    }

}
