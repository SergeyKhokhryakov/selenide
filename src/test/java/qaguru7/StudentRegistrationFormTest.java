package qaguru7;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest {
  @BeforeAll
  static void setUp(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @Test
  @DisplayName("Проверка формы Student Registration Form https://demoqa.com/automation-practice-form")
  void testStudentRegistrationFormTest(){
    String firstName = "Petr";
    String lastName = "Stuckov";
    String email = "my-email@gmail.com";
    String gender = "Male";
    String mobPhone = "9631112233";
    String yearOfBirthday = "1960";
    String monthOfBirthday = "December";
    String dayOfBirthday = "9";
    String subject1 = "Computer Science";
    String subject2 = "Economics";
    String address = "г. Тобол, ул. Терезы, д.5. кор. 1 кв.1";
    String state = "Rajasthan";
    String city = "Jaipur";
    String fileName = "TestNG_vs_JUnit5.png";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String hobby3 = "Music";

    open("/automation-practice-form");
    //hide overlay banners
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");
   // $(".main-header").shouldHave(text("Practice Form"));
    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(email);
    $("#genterWrapper").$(byText(gender)).click();
    //$("label[for='gender-radio-1']").click(); // сделать читаемый селектор
    $("#userNumber").setValue(mobPhone);
    $("#dateOfBirthInput").click();
    //$$(".react-datepicker__month-select option").get(11).click(); // сделать читаемый селектор
    $(".react-datepicker__month-select").selectOption(monthOfBirthday);
    //$$(".react-datepicker__year-select option").findBy(text(yearOfBirthday)).click(); // сделать читаемый селектор
    $(".react-datepicker__year-select").selectOption(yearOfBirthday);
    //$(".react-datepicker__day[aria-label*='" + dayMonthOfBirthday +"']").click();
    $$(".react-datepicker__month .react-datepicker__week :not(.react-datepicker__day--outside-month)").findBy(text(dayOfBirthday)).click();
    $("#subjectsInput").setValue(subject1).pressEnter();
    $("#subjectsInput").setValue(subject2).pressEnter();
    //$("label[for='hobbies-checkbox-1']").click(); // сделать читаемый селектор
    $("#hobbiesWrapper").$(byText(hobby1)).click();
    //$("label[for='hobbies-checkbox-2']").click(); // сделать читаемый селектор
    $("#hobbiesWrapper").$(byText(hobby2)).click();
    //$("label[for='hobbies-checkbox-3']").click(); // сделать читаемый селектор
    $("#hobbiesWrapper").$(byText(hobby3)).click();
    $("#currentAddress").setValue(address);
    //$("#uploadPicture").uploadFile(new File("/Users/macbookpro/Desktop/" + fileName));
    $("#uploadPicture").uploadFromClasspath(fileName);
    //$("#react-select-3-input").setValue(state).pressEnter(); // сделать читаемый селектор
    $(byText("Select State")).click();
    $(byText(state)).click();
    //$("#react-select-4-input").setValue(city).pressEnter(); // сделать читаемый селектор
    $(byText("Select City")).click();
    $(byText(city)).click();
    $("#submit").click();
    /* Это затратно
    $$(".table-responsive tr").findBy(text("Student Name" + " " + firstName + " " + lastName)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Student Email" + " " + email)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Mobile" + " " + mobPhone)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Date of Birth" + " " + "09 December,1960")).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Subjects" + " " + subject1 + ", " + subject2)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobby1 + ", " + hobby2 + ", " + hobby3)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Picture" + " " + fileName)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("Address" + " " + address)).shouldBe(visible);
    $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
     */
    $(".modal-dialog").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text(firstName)
                                                , text(lastName)
                                                , text(email)
                                                , text(gender)
                                                , text(mobPhone)
                                                , text(dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday)
                                                , text(subject1 + ", " + subject2)
                                                , text(hobby1 + ", " + hobby2 + ", " + hobby3)
                                                , text(fileName)
                                                , text(address)
                                                , text(state + " " + city)
                                                );
  }
}
