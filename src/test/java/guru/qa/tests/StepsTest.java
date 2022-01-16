package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.REPOSITORY;
import static guru.qa.tests.TestData.NUMBER;

public class StepsTest {
    @Test
    public void annotatedSteps() {
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.openRepositoryPage(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.shouldSeeIssueWitcNumber(NUMBER);
    }
}
