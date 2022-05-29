package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void conf(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1366x768";
        Configuration.browserPosition = "00x00";
    }

    @Test
    void firstTest(){
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
        $("[id=userNumber]").setValue("1234567890");

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
                File("src\\test\\resources\\a.png"));

        //address
        $("[id=currentAddress]").setValue("Some address");

        //Lists
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Noida").pressEnter();

        //Button
        $("#submit").click();


        //Checks
        $(".table-responsive").shouldHave(
                text("Alexey Victorov"),
                text("alex_vicktory@mail.com"),
                text("Male"),
                text("1234567890"),
                text("21 August,1990"),
                text("Hindi"),
                text("Sports, Music"),
                text("a.png"),
                text("Some address"),
                text("NCR Noida")
                );
    }

}
