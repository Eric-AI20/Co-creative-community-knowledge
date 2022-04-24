package com.cardiff.assessement;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommunityControllerChromeDriverTest {

    private WebDriver webDriver;

    @Value("${local.server.port}")
    private int port;


    @Disabled
    @Test
    public void testingPageContents() {
        assertTrue(true);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c21106601\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        //  options.addArguments("--headless");
        this.webDriver = new ChromeDriver(options);
        this.webDriver.get("http://localhost:" + port + "/home");

        assertTrue(webDriver.findElement(By.id("jamb1p")).getText().contains("description"));
        assertTrue(webDriver.findElement(By.id("navbar")).getText().contains("Co-Create"));


        webDriver.quit();
    }

}
