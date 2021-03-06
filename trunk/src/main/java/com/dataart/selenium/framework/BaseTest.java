package com.dataart.selenium.framework;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static com.dataart.selenium.framework.BasePage.driver;

public class BaseTest {
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws IOException {
        //For running in Google Chrome
        //System.setProperty("webdriver.chrome.driver", "/Users/macchook/Documents/Drivers/chromedriver");

        //Basic Authentification point 2
        /*FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        driver = new FirefoxDriver(profile);
        driver.get("http://admin:admin@localhost:8080");*/

        /*BasePage.driver = settings.getDriver();
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl());
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT))
            driver.manage().window().maximize();*/

        BasePage.driver = settings.getDriver();
        BasePage.settings = settings;

        driver.manage().window().maximize();

        Runtime.getRuntime().exec("C:\\Users\\amamchuk\\Desktop\\AutoITScripts\\HandleAuthentification.exe");

        BasePage.driver.get(settings.getBaseUrl());
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT));

    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        driver.close();
    }
}
