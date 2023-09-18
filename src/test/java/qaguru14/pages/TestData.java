package qaguru14.pages;

//import com.github.javafaker.Faker;
//import com.github.javafaker.PhoneNumber;

import net.datafaker.Faker;
import java.util.Locale;

public class TestData {
  public String firstName,
          lastName,
          email,
          gender,
          mobPhone,
          yearOfBirthday,
          monthOfBirthday,
          dayOfBirthday,
          subject1,
          subject2,
          address ,
          state,
          city,
          fileName,
          hobby1,
          hobby2,
          hobby3;
  public TestData(){
          Faker faker = new Faker(new Locale("ru"));
          String[] memberOfBirthday;
          firstName = faker.name().firstName();
          lastName = faker.name().lastName();
          email = faker.internet().emailAddress();
          gender = faker.demographic().sex();
          mobPhone = faker.phoneNumber().phoneNumber();
          memberOfBirthday = parserBirthday(faker.date().birthday(1, 99, "YYYY/MM/dd"));
          yearOfBirthday = memberOfBirthday[0];
    /*
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    String dob = sdf.format(faker.date().birthday());
     */
          monthOfBirthday = memberOfBirthday[1];
          dayOfBirthday = memberOfBirthday[2];
          subject1 = "Computer Science";
          subject2 = "Economics";
          address = faker.address().fullAddress();
          state = faker.address().country();
          city = faker.address().cityName();
          fileName = "TestNG_vs_JUnit5.png";
          hobby1 = "Sports";
          hobby2 = "Reading";
          hobby3 = "Music";
        }

  /**
   * @param birthday "YYYY/MM/dd"
   * @return String[] [0] "YYYY"
   *                  [1] "January", ...., "December"
   *                  [2] "dd"
   */
  String[] parserBirthday(String birthday){
          String[] membersOfBirthday = new String[birthday.length()];
          membersOfBirthday = birthday.split("/");
          switch (membersOfBirthday[1]){
            case "01":
              membersOfBirthday[1] = "January";
              break;
            case "02":
              membersOfBirthday[1] = "February";
              break;
            case "03":
              membersOfBirthday[1] = "March";
              break;
            case "04":
              membersOfBirthday[1] = "April";
              break;
            case "05":
              membersOfBirthday[1] = "May";
              break;
            case "06":
              membersOfBirthday[1] = "June";
              break;
            case "07":
              membersOfBirthday[1] = "July";
              break;
            case "08":
              membersOfBirthday[1] = "August";
              break;
            case "09":
              membersOfBirthday[1] = "September";
              break;
            case "10":
              membersOfBirthday[1] = "October";
              break;
            case "11":
              membersOfBirthday[1] = "November";
              break;
            case "12":
              membersOfBirthday[1] = "December";
              break;
          }
          return membersOfBirthday;
        }
}
