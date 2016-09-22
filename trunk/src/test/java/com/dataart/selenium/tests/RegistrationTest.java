package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.CSVRead;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.models.UserBuilder.newDeveloper;
import static com.dataart.selenium.models.UserBuilder.newUser;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by amamchuk on 30.06.2016.
 */
public class RegistrationTest extends BaseTest{

    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;
    private MyApplications myapplicationsPage;
    private NewApplication newapplicationPage;
    private User user;
    private CSVRead csvRead;
    public BufferedReader ret;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        registrationPage = initPage(RegistrationPage.class);
        headerPage = initPage(HeaderPage.class);
        myapplicationsPage = initPage(MyApplications.class);
        newapplicationPage = initPage(NewApplication.class);
        csvRead = initPage(CSVRead.class);
    }

    @Test
    public void registerANewUser() {
        user = newUser();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "USER");
        assertHeader(user);
    }

    @Test
    public void registerANewUserThenVerify() {
        user = newUser();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "USER");
        headerPage.logoutButtonClick();
        loginPage.assertMethod();
    }

    @Test
    public void registerADeveloper(){
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user,"DEVELOPER");
        headerPage.myApplicationsButtonClick();
        myapplicationsPage.myApplicationsButtonClick();
        assertTitle();
    }

    @Test
    public void registerARegularUser() {
        user = newUser();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "USER");
        headerPage.assertButton();
    }

    @Test
    public void csvDataRead() throws IOException {

        //ret = csvRead.csvRead();
        loginPage.registerANewUser();
        registrationPage.ddtRegistration();
        //registrationPage.ddtRegistration(ret);
    }

    private void assertHeader(User user){
       assertThat(headerPage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }

    private void assertTitle(){
        assertThat(newapplicationPage.getTitle().contains("New application"));
    }


}
