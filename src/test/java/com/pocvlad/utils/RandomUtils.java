package com.pocvlad.utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {

    static final Faker faker = new Faker();
    private final Date birthday = faker.date().birthday();
    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Commerce", "Maths", "English"};
    String[] hobbies = {"Sports", "Reading", "Music"};
    String[] pictures = {"11.png", "22.png", "33.jpg"};
    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
    String[] uttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
    String[] haryanaCities = {"Karnal", "Panipat"};
    String[] rajasthanCities = {"Jaipur", "Jaiselmer"};

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {

        return faker.options().nextElement(genders);
    }

    public String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getBirthdayYear() {
        return new SimpleDateFormat("yyyy").format(birthday);
    }

    public String getBirthdayMonth() {
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(birthday)) - 1;
        return Integer.toString(month);
    }

    public String getBirthdayDay() {
        return new SimpleDateFormat("d").format(birthday);
    }

    public String getRandomSubject() {

        return faker.options().nextElement(subjects);
    }

    public String getRandomHobbies() {

        return faker.options().nextElement(hobbies);
    }

    public String getRandomPictures() {

        return faker.options().nextElement(pictures);
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {

        return faker.options().nextElement(states);
    }


    public String getRandomCityFromState(String state) {

        String city = null;

        switch (state) {
            case "NCR":
                city = faker.options().nextElement(ncrCities);
                break;
            case "Uttar Pradesh":
                city = faker.options().nextElement(uttarPradeshCities);
                break;
            case "Haryana":
                city = faker.options().nextElement(haryanaCities);
                break;
            case "Rajasthan":
                city = faker.options().nextElement(rajasthanCities);
        }
        return city;
    }
}
