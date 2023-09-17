package qaguru10.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
  public void setDate(String day, String month, String year){
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOption(year);
    $$(".react-datepicker__month .react-datepicker__week :not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
  }
}
