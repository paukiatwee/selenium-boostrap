/**
 * 
 */
package com.example.web.servlet;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


/**
 * @author pau
 *
 */
public class LoginTest {
    private int delay = 1500;
    Selenium selenium;
    @Before
    public void before() {
        selenium = new DefaultSelenium("localhost", 4444, "*googlechrome", "http://localhost:8080");
        selenium.start();
    }
    
    
    @Test
    public void loginFailed() throws InterruptedException {
        selenium.windowMaximize();
        login("sysadmin", "wrongpassword");
        Assert.assertTrue(selenium.isElementPresent("css=.alert.alert-error"));
        Thread.sleep(1000);
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        selenium.windowMaximize();
        login("sysadmin", "sysadmin");
        waitForText("Add User");
        Thread.sleep(delay);
    }
    
    private void login(String username, String password) throws InterruptedException {
        selenium.open("/");
        Thread.sleep(delay);
        selenium.type("username", username);
        Thread.sleep(delay);
        selenium.type("password", password);
        Thread.sleep(delay);
        selenium.click("css=.btn.btn-primary");
        Thread.sleep(delay);
    }
    
    
    private void waitForText(String text) {
        long timeoutInMiliSecond = 3000;
        long start = System.currentTimeMillis();
        long current = start;
        do {
            if(selenium.isTextPresent(text)) {
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                
            }
            current = System.currentTimeMillis();
        } while((current - start) < timeoutInMiliSecond);
        throw new TimeoutException("Failed to wait for text \"" + text + "\" to present in " + timeoutInMiliSecond + " miliseconds");
        
    }
    
    @After
    public void after() {
        selenium.close();
    }

}
