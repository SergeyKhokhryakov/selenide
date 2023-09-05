package qaguru4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {

  @BeforeAll
  public static void init(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://the-internet.herokuapp.com";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }
  @Test
  public void testDragAndDrop (){
    open("/drag_and_drop");
    // actions() - не работает как DragAndDrop
    //int xA = $("#column-a").getLocation().getX();
    //int xB = $("#column-b").getLocation().getX();
    //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(xB-xA, 0).release().perform();
    //$("#column-a").dragAndDrop(to($("#column-b")));                             // using a CSS selector defining the target element
    $("#column-a").dragAndDrop(to("#column-b"));                                // using a SelenideElement defining the target element
    //$("#column-a").dragAndDropTo($("#column-b"));                               // Deprecate
    //$(byTagAndText("header","A")).dragAndDropTo($(byTagAndText("header","B"))); // Deprecate
    $("#column-a header").shouldHave(text("B"));
    $("#column-b header").shouldHave(text("A"));
  }
}
