package com.pocvlad.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;


public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));

    }
    public void verifyResult (String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }
}
