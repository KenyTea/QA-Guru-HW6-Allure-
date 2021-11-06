package guru.qa.tests;

import com.codeborne.selenide.Condition;
import guru.qa.tests.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork5 extends TestBase {
//    @Rule
//    public  TestRule report = new TestReporter();

    @Test
    void studentsRegistration() {

        registrationPage
                .openPage("https://demoqa.com/automation-practice-form") // Открываем браузер и проверяем что страница загрузилась
                .setFirstName("Alex") // Заполняем поле firstName
                .setLastName("Vass") // Заполняем поле lastName
                .setEmail("Vass@gmail.com") // Заполняем поле email
                .buttonMaleClick() // Кликаем Gender radio button
                .setMobilePhone("7773557777") // Заполняем поле Mobile(10 Digits)
                //registrationPage.calendarComponent.setDateOfBirthday("5", "1982", "15");  Реализовал, но тогда код не красивый!
                .setDateOfBirthday("5", "1982", "15") // Заполняем поле Date of Birth
                .setsubjects("e") // Заполняем поле Subjects
                .buttonHobbiesClick() // Кликаем Hobbies checkbox
                .setPicture("resources\\p1.PNG") // Загрузка картинки
                .setCurrentAddress("sssss") // Заполнение Current Address
                .setState("NCR") // Select state
                .setCity("Gurgaon") //Select City
                .setSubmit() // Нажименм кнопку Subjects
                // Проверка:
                .validation("Student Name", "Alex Vass")
                .validation("Student Email", "Vass@gmail.com")
                .validation("Gender", "Male")
                .validation("Mobile", "7773557777")
                .validation("Date of Birth", "15 June,1982")
                .validation("Subjects", "English")
                .validation("Hobbies", "Sports")
                .validation("Picture", "p1.PNG")
                .validation("Address", "sssss")
                .validation("State and City", "NCR Gurgaon");

        // Для проверки
        sleep(2000);

    }

}
