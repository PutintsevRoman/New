package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    private static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void conf() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        String browser =System.getProperty("browser","chrome");
        String browserVersion = System.getProperty("browserVersion");
        String browserSize =System.getProperty("browserSize","1920x1080");
        System.out.println(browser);
        System.out.println(browserVersion);
        System.out.println(browserSize);

        String remoteDriverUrl = System.getProperty("remoteDriverUrl", "selenoid.autotests.cloud/wd/hub");
        Configuration.browser = browser;
        Configuration.browserVersion =browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteDriverUrl);
        System.out.println(String.format("https://%s:%s@%s", config.login(), config.password(), remoteDriverUrl));


    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
