package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class TestForm extends TestBase {


    @Test
    void firstTest() {

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        TestData testData = new TestData();

        String firstName = testData.getName(),
               lastName = testData.getLastName(),
               userEmail = testData.getUserEmail(),
               userGender = testData.getUserSex(),
               userNumber = testData.getUserPhone(),
               userHobbies = testData.getUserHobbies(),
               userSubject = testData.getUserSubject(),
               userAddress = testData.getUserAddress(),
               userState = testData.getUserState(),
               userCity = testData.getUserCity(userState),
               month = testData.getRandomMonth(),
               day = testData.getRandomDay(),
               year = testData.getRandomYear(),
                file = "a.png";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderRadio(userGender)
                .setUserNumber(userNumber)
                .setCheckbox(userHobbies)
                .setSubject(userSubject)
                .setCurrentAddress(userAddress)
                .setFile(file)
                .setState(userState)
                .setCity(userCity)
                .setDate(month, year, day)
                .submit();



        registrationFormPage.checkResult("Student Name", firstName + " " +lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " "+month+"," + year)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", file)
                .checkResult("Address", userAddress)
                .checkResult("State and City", userState + " " +userCity);

    }

}
