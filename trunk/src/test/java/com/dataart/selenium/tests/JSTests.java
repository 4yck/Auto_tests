package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.newDeveloper;

/**
 * Created by amamchuk on 05.10.2016.
 */
public class JSTests extends BaseTest {
    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;
    private User user;
    private JSTestPage jsTestPage;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        registrationPage = initPage(RegistrationPage.class);
        headerPage = initPage(HeaderPage.class);
        jsTestPage = initPage(JSTestPage.class);
    }

    @Test
    public void getCoordinates() throws InterruptedException {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "DEVELOPER");
        headerPage.jsTestPageButtonClick();
        jsTestPage.getCoordinates();
    }
}
