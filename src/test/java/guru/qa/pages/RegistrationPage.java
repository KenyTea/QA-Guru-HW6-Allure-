package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import guru.qa.components.CalendarComponent;

import java.io.File;
import java.time.Duration;
import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // locators and elements
    private final String URL = "https://demoqa.com/automation-practice-form";
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            studentRegistrationForm = $(byText(FORM_TITLE)),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            maleClick = $(byText("Male")),
            userNumber = $("#userNumber"),
            dateOfBirthClick = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            english = $(byText("English")),
            hobbies = $(byText("Sports")),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateClick = $("#state"),
            cityClick = $("#city"),
            submitClick = $("#submit"),
            responsTable = $(".table-responsive");

            ElementsCollection daySelect = $$(".react-datepicker__day");


    // actions
    public RegistrationPage openPage(String url) {
        // Открываем браузер
        open(url);
        // Проверяем дто страница загрузилась
        studentRegistrationForm.shouldBe(Condition.visible, Duration.ofMillis(25_000));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        // Заполняем поле firstName
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        // Заполняем поле lastName
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        // Заполняем поле email
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage buttonMaleClick() {
        // Заполняем поле firstName
        maleClick.click();
        return this;
    }

    public RegistrationPage setMobilePhone(String value) {
        // Заполняем поле Mobile(10 Digits)
        userNumber.setValue(value);
        return this;
    }

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setDateOfBirthday(String month, String year, String day) {
        // Заполняем поле Date of Birth
        dateOfBirthClick.click();
        monthSelect.selectOptionByValue(month);
        yearSelect.selectOptionByValue(year);
        daySelect.find(text(day)).click();
        return this;
    }

    public RegistrationPage setsubjects(String character) {
        // Заполняем поле Subjects
        subjectsInput.scrollTo();
        subjectsInput.click();
        subjectsInput.sendKeys(character);
        english.click();
        return this;
    }

    public RegistrationPage buttonHobbiesClick() {
        // Кликаем Hobbies checkbox
        hobbies.click();
        return this;
    }

    public RegistrationPage setPicture(String fileName) {
        // Загрузка картинки
        uploadPicture.uploadFile(new File(fileName));
        return this;
    }

    public RegistrationPage setCurrentAddress(String Address) {
        // Заполнение Current Address
        currentAddress.scrollTo();
        currentAddress.setValue(Address);
        return this;
    }

    public RegistrationPage setState(String state) {
        // Select state
        stateClick.click();
        stateClick.find(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        //Select City
        cityClick.click();
        cityClick.find(byText(city)).click();
        return this;
    }

    public RegistrationPage setSubmit() {
        // Нажименм кнопку Subjects
        submitClick.click();
        return this;
    }

    public RegistrationPage validation(String label, String value) {
        responsTable.$(byText(label)).parent().shouldHave(text(value));
        return  this;
    }

}
