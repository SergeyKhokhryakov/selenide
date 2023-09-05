package qaguru4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
    //$x("//button[normalize-space()='Solutions']").hover();
    //$("a.HeaderMenu-dropdown-link[href$='enterprise']").click();
    $(byText("Solutions")).hover();
    $(byText("Enterprise")).click();
    $(".eyebrow-banner").parent().$("h1").shouldHave(text("Build like the best"));
  }
}
