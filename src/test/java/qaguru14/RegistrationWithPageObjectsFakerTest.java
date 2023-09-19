package qaguru14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import qaguru14.pages.TestBase;

/**
 * //Using Faker library
 * Using Datafaker library
 */

public class RegistrationWithPageObjectsFakerTest extends TestBase {


  @DisplayName("Проверка формы Student Registration Form https://demoqa.com/automation-practice-form")
  @RepeatedTest(2)
  void testStudentRegistrationFormTest(){

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
