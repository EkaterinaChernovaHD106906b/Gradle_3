package ru.netology.domain;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class Test {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();


    }
    @org.junit.jupiter.api.Test
    public void myTest() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=\"city\"] input").setValue("Нальчик");
        $("[data-test-id='date'] input ").setValue("11.08.2022");
        $("[data-test-id='name'] input").setValue("Алексей Орлов-Чесменский");
        $("[data-test-id='phone'] input").setValue("+76540785412");
        $("[data-test-id= 'agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $("[data-test-id='notification']").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}
