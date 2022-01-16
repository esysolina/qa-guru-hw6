package guru.qa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.tests.TestData.REPOSITORY;
import static guru.qa.tests.TestData.NUMBER;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    @Test
    public void lambdaTest() {
        step("Открываем страницу", ()->{
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, ()->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, ()->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку Issues", ()->{
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем номер Issue " + NUMBER, ()->{
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }
}
