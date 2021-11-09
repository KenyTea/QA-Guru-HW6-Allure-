package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import guru.qa.tests.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork5 extends TestBase {

    private final String URL = "https://demoqa.com/automation-practice-form";

    @Test
    void studentsRegistration() {

        registrationPage
                .openPage(URL) // Открываем браузер и проверяем что страница загрузилась
                .setFirstName(randomFaker.firstName) // Заполняем поле firstName
                .setLastName(randomFaker.lastName) // Заполняем поле lastName
                .setEmail("qa.guru@gmail.com") // Заполняем поле email
                .selectGender("Male") // Кликаем Gender radio button
                .setMobilePhone("7773557777"); // Заполняем поле Mobile(10 Digits)
        registrationPage.calendarComponent.setDateOfBirthday("5", "1982", randomFaker.day); // Заполняем поле Date of Birth
        registrationPage
                .setSubjects("e") // Заполняем поле Subjects
                .hobbySelect("Sports") // Кликаем Hobbies checkbox
                .setPicture("resources\\p1.PNG") // Загрузка картинки
                .setCurrentAddress(randomFaker.address) // Заполнение Current Address
                .setState("NCR") // Select state
                .setCity("Gurgaon") //Select City
                .setSubmit() // Нажименм кнопку Subjects
                // Проверка:
                .validate("Student Name", randomFaker.firstName + " " + randomFaker.lastName)
                .validate("Student Email", "qa.guru@gmail.com")
                .validate("Gender", "Male")
                .validate("Mobile", "7773557777")
                .validate("Date of Birth", randomFaker.day + " June,1982")
                .validate("Subjects", "English")
                .validate("Hobbies", "Sports")
                .validate("Picture", "p1.PNG")
                .validate("Address", randomFaker.address)
                .validate("State and City", "NCR Gurgaon");

    }

}
