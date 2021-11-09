package guru.qa.LambdaTest;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {
    private static final String URL = "https://github.com/qa-guru";
    private static final String REPOSITORY = "allure-notifications";
    private static final int ISSUE_NUMBER = 64;

    @Owner("KenyTae")
    @Feature("Gidhub")
    @Story("Issues")
    @DisplayName("Lambda test")
    @Link(name = "GitHub", url = "https://github.com/qa-guru")

    @Test
    public void testGithub() {

        step("Открываем страниу GitHub", () -> open(URL));
        step("Находим нужный нам репозиторий " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());
        step("Проверяем переход на другую страницу Issues ", () -> {
            $(partialLinkText("Issues")).should(Condition.visible, Duration.ofSeconds(20));
        });
        step("Открываем таб Issues", () -> $(partialLinkText("Issues")).click());
        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
