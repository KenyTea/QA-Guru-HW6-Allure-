package guru.qa.AnnotatedTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class Steps {

    @Step("Открываем страницу {URL}")
    public void openGithubPage(String URL) {
        open(URL);
    }

    @Step("Находим нужный нам репозиторий {repository}")
    public void finedRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Кликаем на Issues")
    public void finedIssues() {
        // Проверяем переход на другую страницу
        $(partialLinkText("Issues")).should(Condition.visible, Duration.ofSeconds(30));
        // Кликаем на Issues
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие #{number}")
    public void finedNumberInIssues(int number) {
        // Проверяем наличие #64
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
