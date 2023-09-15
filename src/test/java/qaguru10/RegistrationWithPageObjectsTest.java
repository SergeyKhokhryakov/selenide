package qaguru10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qaguru10.pages.RegistrationPage;
import qaguru10.pages.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTest extends TestBase {

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

    registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(mobPhone)
                    .setDayOfBirthday(dayOfBirthday, monthOfBirthday, yearOfBirthday)
                    .setSubjects(subject1, subject2)
                    .setHobbies(hobby1, hobby2, hobby3)
                    .selectPicture(fileName)
                    .setAddress(address)
                    .setStateAndCity(state, city)
                    .clickSubmit();

    registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", mobPhone)
                    .verifyResult("Date of Birth", dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday)
                    .verifyResult("Subjects", subject1 + ", " + subject2)
                    .verifyResult("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                    .verifyResult("Picture", fileName)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
  }
}
