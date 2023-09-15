package qaguru10.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  protected RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }
}
