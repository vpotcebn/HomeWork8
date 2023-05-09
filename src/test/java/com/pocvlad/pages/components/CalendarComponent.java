package com.pocvlad.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String month, String year) {
        $("[class=react-datepicker__month-select]").selectOptionByValue(month);
        $("[class=react-datepicker__year-select]").selectOptionByValue(year);
        $(".react-datepicker__month-container").$(byText(day)).click();


    }
}
