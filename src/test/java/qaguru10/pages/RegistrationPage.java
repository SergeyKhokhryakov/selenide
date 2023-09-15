package qaguru10.pages;

import com.codeborne.selenide.Condition;
import qaguru10.components.Calendar;
import qaguru10.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
  private Calendar calendar = new Calendar();
  private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
  public RegistrationPage openPage(){
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    //hide overlay banners
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    return this;
  }

  public RegistrationPage setFirstName(String value){
    $("#firstName").setValue(value);
    return this;
  }

  public RegistrationPage setLastName(String value){
    $("#lastName").setValue(value);
    return this;
  }

  public RegistrationPage setEmail(String value){
    $("#userEmail").setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value){
    $("#genterWrapper").$(byText(value)).click();
    return this;
  }

  public RegistrationPage setPhone(String value){
    $("#userNumber").setValue(value);
    return this;
  }

  public RegistrationPage setDayOfBirthday(String day, String month, String year){
    $("#dateOfBirthInput").click();
    calendar.chooseDayOfCalendar(day, month, year);
    return this;
  }

  public RegistrationPage setSubjects(String... subjects){
    for (String subject : subjects) {
      $("#subjectsInput").setValue(subject).pressEnter();
    }
    return this;
  }

  public RegistrationPage setHobbies(String... hobbies){
    for (String hobby : hobbies) {
      $("#hobbiesWrapper").$(byText(hobby)).click();
    }
    return this;
  }

  public RegistrationPage setAddress(String value){
    $("#currentAddress").setValue(value);
    return this;
  }
  public RegistrationPage selectPicture(String value){
    $("#uploadPicture").uploadFromClasspath(value);
    return this;
  }

  public RegistrationPage setStateAndCity(String state, String city){
    $(byText("Select State")).click();
    $(byText(state)).click();
    $(byText("Select City")).click();
    $(byText(city)).click();
    return this;
  }

  public RegistrationPage verifyResultsModalAppears(){
    registrationResultsModal.verifyModalAppears();
    return this;
  }

  public void clickSubmit(){
    $("#submit").click();
  }

  public RegistrationPage verifyResult(String key, String value) {
    registrationResultsModal.verifyResult(key, value);
    return this;
  }
}
