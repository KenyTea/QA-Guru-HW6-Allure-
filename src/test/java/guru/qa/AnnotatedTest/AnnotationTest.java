package guru.qa.AnnotatedTest;


import org.junit.jupiter.api.Test;



public class AnnotationTest {
    private static final String URL = "https://github.com/qa-guru";
    private static final String REPOSITORY = "allure-notifications";
    private static final int ISSUE_NUMBER = 64;

    private final Steps steps = new Steps();

    @Test
    public void checkIssue() {
        steps.openGithubPage(URL);
        steps.finedRepository(REPOSITORY);
        steps.finedIssues();
        steps.finedNumberInIssues(ISSUE_NUMBER);
        steps.takeScreenshot();
    }


}
