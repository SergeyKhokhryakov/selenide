package qaguru14.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  protected RegistrationPage registrationPage = new RegistrationPage();
  protected TestData data = new TestData();

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

//  @BeforeEach
//  void setData(){
//
//    Faker faker = new Faker(new Locale("ru"));
//    data.firstName = faker.name().firstName();
//    data.lastName = faker.name().lastName();
//    data.email = faker.internet().emailAddress();
//    data.gender = faker.demographic().sex();
//    data.mobPhone = String.valueOf(faker.phoneNumber());
//    data.yearOfBirthday = String.valueOf(faker.date().birthday());
//    /*
//    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//    Faker faker = new Faker();
//    String dob = sdf.format(faker.date().birthday());
//    System.out.println(dob);
//     */
////    data.monthOfBirthday =
////    data.dayOfBirthday =
//    data.subject1 = "Computer Science";
//    data.subject2 = "Economics";
//    data.address = faker.address().fullAddress();
//    data.state = faker.address().country();
//    data.city = faker.address().cityName();
//    data.fileName = "TestNG_vs_JUnit5.png";
//    data.hobby1 = "Sports";
//    data.hobby2 = "Reading";
//    data.hobby3 = "Music";
//  }
}
