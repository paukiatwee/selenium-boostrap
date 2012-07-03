/**
 * 
 */
package com.example.web.servlet;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


/**
 * @author pau
 *
 */
public class LoginIT {
    private int delay = 0;
    WebDriver webDriver;
    @Before
    public void before() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        
        webDriver = new FirefoxDriver(profile);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    
    @Test(expected = NoSuchElementException.class)
    public void loginFailed() throws InterruptedException {
        login("sysadmin", "wrongpassword");
        webDriver.findElement(By.cssSelector("css=.alert.alert-error"));
        Thread.sleep(1000);
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        login("sysadmin", "sysadmin");
        Thread.sleep(delay);
    }
    
    private void login(String username, String password) throws InterruptedException {
        webDriver.get("http://localhost:8080/");
        Thread.sleep(delay);
        keyin(".username", username);
        Thread.sleep(delay);
        keyin(".password", password);
        Thread.sleep(delay);
        click(".btn.btn-primary");
        Thread.sleep(delay);
    }
    
    private void keyin(String selector, String value) {
        WebElement name = webDriver.findElement(By.cssSelector(selector));
        name.clear();
        name.sendKeys(value);
    }
    
    private void click(String selector) {
        webDriver.findElement(By.cssSelector(selector)).click();
    }
    
    
    @After
    public void after() {
        webDriver.close();
    }

}
