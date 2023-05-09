package com.pocvlad.pages;

import com.codeborne.selenide.Selenide;
import com.pocvlad.pages.components.CalendarComponent;
import com.pocvlad.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage removeBanners() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;

    }


    public RegistrationPage setFirstName(String value) {
        $("[id=firstName]").setValue(value);

        return this;

    }

    public RegistrationPage setLastName(String value) {
        $("[id=lastName]").setValue(value);

        return this;

    }

    public RegistrationPage setEmail(String value) {
        $("[id=userEmail]").setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPhoneNumber(String value) {
        $("[id=userNumber]").setValue(value);

        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("[id=dateOfBirthInput]").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        $("[id=hobbiesWrapper]").$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);

        return this;

    }

    public RegistrationPage setAddress(String value) {
        $("[id=currentAddress]").setValue(value);

        return this;

    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;

    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;

    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;

    }

    public RegistrationPage verifyResultsModalAppears () {
        registrationResultsModal.verifyModalAppears();

        return this;

    }

    public RegistrationPage verifyResult (String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;

    }

}
