package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
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

        Faker faker = new Faker();
        String address = faker.address().streetAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int randomDay = faker.number().numberBetween(1, 30);
        String day = Integer.toString(randomDay);

        registrationPage
                .openPage("https://demoqa.com/automation-practice-form") // Открываем браузер и проверяем что страница загрузилась
                .setFirstName(firstName) // Заполняем поле firstName
                .setLastName(lastName) // Заполняем поле lastName
                .setEmail("Vass@gmail.com") // Заполняем поле email
                .buttonMaleClick() // Кликаем Gender radio button
                .setMobilePhone("7773557777") // Заполняем поле Mobile(10 Digits)
                //registrationPage.calendarComponent.setDateOfBirthday("5", "1982", "15");  Реализовал, но тогда код не красивый!
                .setDateOfBirthday("5", "1982", day) // Заполняем поле Date of Birth
                .setsubjects("e") // Заполняем поле Subjects
                .buttonHobbiesClick() // Кликаем Hobbies checkbox
                .setPicture("resources\\p1.PNG") // Загрузка картинки
                .setCurrentAddress(address) // Заполнение Current Address
                .setState("NCR") // Select state
                .setCity("Gurgaon") //Select City
                .setSubmit() // Нажименм кнопку Subjects
                // Проверка:
                .validation("Student Name", firstName + " " + lastName)
                .validation("Student Email", "Vass@gmail.com")
                .validation("Gender", "Male")
                .validation("Mobile", "7773557777")
                .validation("Date of Birth", day + " June,1982")
                .validation("Subjects", "English")
                .validation("Hobbies", "Sports")
                .validation("Picture", "p1.PNG")
                .validation("Address", address)
                .validation("State and City", "NCR Gurgaon");

        // Для проверки
        sleep(2000);

    }

}
