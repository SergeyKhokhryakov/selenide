package qaguru14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qaguru14.pages.TestBase;
import qaguru14.pages.TestData;

/**
 * //Using Faker library
 * Using Datafaker library
 */

public class RegistrationWithPageObjectsTest extends TestBase {

  @Test
  @DisplayName("Проверка формы Student Registration Form https://demoqa.com/automation-practice-form")
  void testStudentRegistrationFormTest(){
    TestData data = new TestData();
//    String firstName = "Petr";
//    String lastName = "Stuckov";
//    String email = "my-email@gmail.com";
//    String gender = "Male";
//    String mobPhone = "9631112233";
//    String yearOfBirthday = "1960";
//    String monthOfBirthday = "December";
//    String dayOfBirthday = "9";
//    String subject1 = "Computer Science";
//    String subject2 = "Economics";
//    String address = "г. Тобол, ул. Терезы, д.5. кор. 1 кв.1";
//    String state = "Rajasthan";
//    String city = "Jaipur";
//    String fileName = "TestNG_vs_JUnit5.png";
//    String hobby1 = "Sports";
//    String hobby2 = "Reading";
//    String hobby3 = "Music";

    registrationPage.openPage()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setPhone(data.mobPhone)
                    .setBirthdayDate(data.dayOfBirthday, data.monthOfBirthday, data.yearOfBirthday)
                    .setSubjects(data.subject1, data.subject2)
                    .setHobbies(data.hobby1, data.hobby2, data.hobby3)
                    .selectPicture(data.fileName)
                    .setAddress(data.address)
                    .setStateAndCity(data.state, data.city)
                    .sendForm();

    registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", data.firstName + " " + data.lastName)
                    .verifyResult("Student Email", data.email)
                    .verifyResult("Gender", data.gender)
                    .verifyResult("Mobile", data.mobPhone)
                    .verifyResult("Date of Birth", data.dayOfBirthday + " " + data.monthOfBirthday + "," + data.yearOfBirthday)
                    .verifyResult("Subjects", data.subject1 + ", " + data.subject2)
                    .verifyResult("Hobbies", data.hobby1 + ", " + data.hobby2 + ", " + data.hobby3)
                    .verifyResult("Picture", data.fileName)
                    .verifyResult("Address", data.address)
                    .verifyResult("State and City", data.state + " " + data.city);
  }
}
