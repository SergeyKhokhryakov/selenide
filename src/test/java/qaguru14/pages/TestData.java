package qaguru14.pages;

//import com.github.javafaker.Faker;
//import com.github.javafaker.PhoneNumber;

import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TestData {
  Faker faker = new Faker(new Locale("ru"));
  Faker fakerEng = new Faker(new Locale("en-US"));
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
          hobby2 = "",
          hobby3 = "";
  public TestData(){

          String[] memberOfBirthday;
          firstName = faker.name().firstName();
          lastName = faker.name().lastName();
          email = fakerEng.internet().emailAddress();
//          gender = faker.demographic().sex(); // only "Male", "Female"
          gender = faker.options().option("Male", "Female", "Other");
          mobPhone = parserMobNumber(
                          faker.phoneNumber().phoneNumber()
                                    );
//          Вариант 2
//          mobPhone = String.valueOf(faker.number().numberBetween(9151111111L, 9269999999L));
    // Надежный вариант, т.к. разбирается рандомная дата рождения
          memberOfBirthday = getRandomDateBirthday();
//    Вариант 2 (похоже, но дольше разбор)
//          memberOfBirthday = parserBirthday(faker.date().birthday(1, 99, "YYYY/MM/dd"));
          yearOfBirthday = memberOfBirthday[0];
          monthOfBirthday = memberOfBirthday[1];
          dayOfBirthday = memberOfBirthday[2];
//    Вариант 3 - недостаток: рандомный день не привязан к месяцу => 1...28 (чтобы попасть в область определения)
//          monthOfBirthday = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
//          yearOfBirthday = faker.number().numberBetween(1940,2005) + "";
//          dayOfBirthday = setRandomDay();
//          String dateBirth = String.format("%s %s,%s", dayOfBirthday, monthOfBirthday, yearOfBirthday);
//    ToDo choosing subject from dropdown list by random first letter
          subject1 = faker.options().option("Computer Science", "Economics", "English", "Arts", "History", "Hindi");
          subject2 = faker.options().option("Computer Science", "Economics", "English", "Arts", "History", "Hindi");
          hobby1 = faker.options().option("Sports", "Reading", "Music");
//          hobby2 = faker.options().option("Sports", "Reading", "Music");
//          hobby3 = faker.options().option("Sports", "Reading", "Music");
          address = faker.address().fullAddress();
          state = faker.options().option("Uttar Pradesh", "NCR", "Haryana", "Rajasthan");
          city = setRandomCity(state);
//          state = faker.address().country();
//          city = faker.address().cityName();
          fileName = "TestNG_vs_JUnit5.png";

        }

  /**
   * @param birthday "YYYY/MM/dd"
   * @return String[] [0] "YYYY"
   *                  [1] "January", ...., "December"
   *                  [2] "dd"
   */
        String[] parserBirthday(String birthday){
          String[] membersOfBirthday;
          String[] months = {"January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November", "December"};
          membersOfBirthday = birthday.split("/");
          int index = Integer.parseInt(membersOfBirthday[1]);
          membersOfBirthday[1] = months[index];
          return membersOfBirthday;
        }
  /* for Faker library
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
String dob = sdf.format(faker.date().birthday());
*/
  String[] getRandomDateBirthday() {
    return new SimpleDateFormat("yyyy MMMM dd", Locale.ENGLISH).format(faker.date().birthday(18, 70)).split(" ");
  }

  /**
   *
   * @param mobNumber "x (xxx) xxx-xx-xx"
   * @return "xxxxxxxxxx" (String is contained 10 chars)
   */
  String parserMobNumber(String mobNumber){
                String[] buff, buff1, buff2;
                buff = mobNumber.split("-");
                buff1 = buff[0].split("\\(");
                buff2 = buff1[1].split("\\)");
                return String.join("", buff2[0], buff2[1].trim(), buff[1], buff[2]);
        }

  String setRandomCity (String state){
    String item = null;
    ArrayList<String> values = new ArrayList<>();
    if (state.equals("NCR")){
      Collections.addAll(values,"Delhi", "Gurgaon", "Noida");
      item = values.get(faker.random().nextInt(0,values.size()-1));
    }
    else if (state.equals("Uttar Pradesh")){
      Collections.addAll(values,"Agra", "Lucknow", "Merrut");
      item = values.get(faker.random().nextInt(0,values.size()-1));
    }
    else if (state.equals("Haryana")){
      Collections.addAll(values,"Karnal", "Panipat");
      item = values.get(faker.random().nextInt(0,values.size()-1));
    }
    else if  (state.equals("Rajasthan")){
      Collections.addAll(values,"Jaipur", "Jaiselmer");
      item = values.get(faker.random().nextInt(0,values.size()-1));
    }
    return item;
  }
  String setRandomDay(){
    int day = faker.number().numberBetween(1,28);
    if (day < 10) {
      return "0" + day;
    }
    else {
      return day + "";
    }
  }

}
