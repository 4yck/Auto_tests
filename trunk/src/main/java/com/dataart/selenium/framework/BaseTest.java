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

import static com.dataart.selenium.framework.BasePage.driver;

public class BaseTest {
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws InterruptedException {
        //For running in Google Chrome
        //System.setProperty("webdriver.chrome.driver", "/Users/macchook/Documents/Drivers/chromedriver");

        /*FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        driver = new FirefoxDriver(profile);
        driver.get("http://admin:admin@localhost:8080");*/

        BasePage.driver = settings.getDriver();
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl());
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT))
            driver.manage().window().maximize();
        //Thread.sleep(5000);
        //Alert alert = driver.switchTo().alert();
        //driver.switchTo().alert().authenticateUsing((Credentials) new UsernamePasswordCredentials("admin", "admin"));
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        driver.close();
    }
}
