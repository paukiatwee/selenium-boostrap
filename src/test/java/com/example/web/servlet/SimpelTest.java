package com.example.web.servlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public final class SimpelTest {

    private WebDriver driver;

    @Before
    public void before() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        driver = new FirefoxDriver(profile);
    }

    @Test
    public void simpleRun() {
        driver.get("http://www.google.com");
    }

    @After
    public void after() {
        driver.quit();
    }
}