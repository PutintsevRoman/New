package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;


public class TestForm extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();


    public String firstName,
            lastName,
            userEmail,
            userGender,
            userNumber,
            userHobbies,
            userSubject,
            userAddress,
            userState,
            userCity,
            month,
            day,
            year,
            file;

    void fillStrings() {
        firstName = testData.getName();
        lastName = testData.getLastName();
        userEmail = testData.getUserEmail();
        userGender = testData.getUserSex();
        userNumber = testData.getUserPhone();
        userHobbies = testData.getUserHobbies();
        userSubject = testData.getUserSubject();
        userAddress = testData.getUserAddress();
        userState = testData.getUserState();
        userCity = testData.getUserCity(userState);
        month = testData.getRandomMonth();
        day = testData.getRandomDay();
        year = testData.getRandomYear();
        file = "a.png";
    }

    @Test
    @DisplayName("Позитивный тест на зполнение всех полей случайными данными")
    @Owner("Путинцев, Роман")
    @Severity(SeverityLevel.MINOR)
    @Feature("Случайные данные")
    void firstTest() {

        step("Создание случайных данных для теста", () -> {
            fillStrings();
        });

        step("Заполнение полей созданными данными", () -> {
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
        });

        step("Проверка результатов", () -> {
            registrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", userGender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", userSubject)
                    .checkResult("Hobbies", userHobbies)
                    .checkResult("Picture", file)
                    .checkResult("Address", userAddress)
                    .checkResult("State and City", userState + " " + userCity);
        });
    }

}
