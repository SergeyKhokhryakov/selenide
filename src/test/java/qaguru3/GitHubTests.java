package qaguru3;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
  @BeforeAll
  public static void init(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://github.com/";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @Test
  public void testGitHub (){
    open("/");
    // Поставить курсор в строку поиска
    $(byAttribute("data-target", "qbsearch-input.inputButtonText")).click();
    //Ввести в строку поиска Selenide
    $("input#query-builder-test").setValue("selenide").pressEnter();
    //Кликнуть на элемент списка, содержащий ссылку "selenide/selenide"
    $("a[href='/selenide/selenide']").click();
    //Переход в wiki раздел
    $("#wiki-tab").click();
    // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
    //Забиваем в поисковую строку "SoftAssertions"
    $("#wiki-pages-filter").setValue("SoftAssertions");
    //  проверка, что строка найдена (избыточна)
    //$("span.Truncate [href*='SoftAssertion']").shouldHave(text("SoftAssertions"));
    //Переход в SoftAssertions
    $(byText("SoftAssertions")).click();
    //$(byLinkText("SoftAssertions")).click();
    //Проверка примера кода для JUnit5
    // $$("h4").filterBy(text("Using JUnit5 extend test class")).shouldHave(size(1));
    $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
  }
}
