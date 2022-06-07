package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class TestForm extends TestBase {



    @Test
    void firstTest(){

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage.openPage()
                .SetfirstName()
                .SetlastName()
                .SetuserEmail()
                .SetgenderRadio(1)
                .SetuserNumber()
                .Setcheckbox(1)
                .Setsubject()
                .SetcurrentAddress()
                .Setfile()
                .SetState()
                .SetCity()
                .SetDate("August","1990","21")
                .Submit();


        //Checks
        registrationFormPage.checkResult("Student Name","Alexey Victorov")
                        .checkResult("Student Email","alex_vicktory@mail.com")
                        .checkResult("Gender","Male")
                        .checkResult("Mobile","1234567890")
                        .checkResult("Date of Birth","21 August,1990")
                        .checkResult("Subjects","Hindi")
                        .checkResult("Hobbies","Sports")
                        .checkResult("Picture","a.png")
                        .checkResult("Address","Some address")
                        .checkResult("State and City","NCR Noida");

    }

}
