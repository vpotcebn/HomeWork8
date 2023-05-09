package com.pocvlad.tests;

import com.pocvlad.pages.RegistrationPage;
import com.pocvlad.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static java.time.format.TextStyle.FULL;
import static java.util.Locale.ENGLISH;


public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils generator = new RandomUtils();

    @Test
    void fillFormTest() {

        String firstName = generator.getRandomFirstName();
        String lastName = generator.getRandomLastName();
        String email = generator.getRandomEmail();
        String gender = generator.getRandomGender();
        String phoneNumber = generator.getRandomPhoneNumber();
        String year = generator.getBirthdayYear();
        String month = generator.getBirthdayMonth();
        String day = generator.getBirthdayDay();
        String subject = generator.getRandomSubject();
        String hobby = generator.getRandomHobbies();
        String picture = generator.getRandomPictures();
        String address = generator.getRandomAddress();
        String state = generator.getRandomState();
        String city = generator.getRandomCityFromState(state);
        var monthNumber = Integer.parseInt(month) + 1;
        String monthName = Month.of(monthNumber).getDisplayName(FULL, ENGLISH);


        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", day + " " + monthName + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}