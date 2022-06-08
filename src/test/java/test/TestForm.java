package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class TestForm extends TestBase {


    @Test
    void firstTest() {

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setGenderRadio(1)
                .setUserNumber()
                .setCheckbox(1)
                .setSubject()
                .setCurrentAddress()
                .setFile()
                .setState()
                .setCity()
                .setDate("August", "1990", "21")
                .submit();


        //Checks
        registrationFormPage.checkResult("Student Name", "Alexey Victorov")
                .checkResult("Student Email", "alex_vicktory@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "21 August,1990")
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "a.png")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "NCR Noida");

    }

}
