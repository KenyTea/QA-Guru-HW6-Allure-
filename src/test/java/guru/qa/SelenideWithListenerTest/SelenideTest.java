package guru.qa.SelenideWithListenerTest;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    private static final String URL = "https://github.com/qa-guru";
    private static final String REPOSITORY = "allure-notifications";
    private static final int ISSUE_NUMBER = 64;

    @Owner("KenyTae")
    @Feature("Gidhub")
    @Story("Issues")
    @DisplayName("Selenide test")
    @Link(name = "GitHub", url = "https://github.com/qa-guru")

    @Test
    public void testGithub() {
        // Подключение Листенера Allure
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открываем страниу GitHub
        open(URL);

        // Находим нужный нам репозиторий
        $(linkText(REPOSITORY)).click();

        // Проверяем переход на другую страницу
        $(partialLinkText("Issues")).should(Condition.visible, Duration.ofSeconds(20));
        // Кликаем на Issues
        $(partialLinkText("Issues")).click();

        // Проверяем наличие #64
        $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
    }
}
