package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {

    @BeforeAll
    static void conf(){
        Configuration.baseUrl ="https://demoqa.com";
        //Configuration.browserSize = "1366х768";

    }

    @Test
    void FirstTest(){
        open("/automation-practice-form");
        executeJavaScript("document.body.style.zoom='50%'");
    }
}
