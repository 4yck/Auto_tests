package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.models.UserBuilder.newDeveloper;
import static com.dataart.selenium.models.UserBuilder.newUser;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by amamchuk on 19.07.2016.
 */
public class ApplicationTests extends BaseTest {

    private LoginPage loginPage;
    private BasicPage basicPage;
    private HomePage homePage;
    private ApplicationInformation appInfo;
    private RegistrationPage registrationPage;
    private MyApplications myapplicationsPage;
    private NewApplication newapplicationPage;
    private HeaderPage headerPage;
    private EditPage editPage;
    private MessagePage messagePage;
    public String appName;
    public ApplicationInformation a;
    private JsonResponse jsonresponsePage;
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        registrationPage = initPage(RegistrationPage.class);
        headerPage = initPage(HeaderPage.class);
        myapplicationsPage = initPage(MyApplications.class);
        newapplicationPage = initPage(NewApplication.class);
        loginPage = basicPage.forceLogout();
        homePage = initPage(HomePage.class);
        appInfo = initPage(ApplicationInformation.class);
        jsonresponsePage = initPage(JsonResponse.class);
        editPage = initPage(EditPage.class);
        messagePage = initPage(MessagePage.class);
        user = admin();
    }

    @Test
    public void parsingTest() throws JSONException, ParseException {
        loginPage.loginAs(user);
        homePage.detailsButtonClick();
        a = appInfo.getInfo();
        appInfo.downloadButtonClick();
        jsonresponsePage.gettingJsonText(a);
    }

    @Test
    public void creatingAppWithoutImages() {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user,"DEVELOPER");
        headerPage.myApplicationsButtonClick();
        myapplicationsPage.myApplicationsButtonClick();
        appName = newapplicationPage.getAppName();
        newapplicationPage.createNewApplicationWithoutImages(appName);
        myapplicationsPage.detailsButtonClick();
        appInfo.assertMethod();
        appInfo.editButtonClick();
        editPage.updateApplication();
        assertThat(messagePage.getEditMessage()).isEqualTo("Application edited");
    }

    @Test
    public void creatingAppWithImages() {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user,"DEVELOPER");
        headerPage.myApplicationsButtonClick();
        myapplicationsPage.myApplicationsButtonClick();
        appName = newapplicationPage.getAppName();
        newapplicationPage.createNewApplicationWithImages(appName);
        myapplicationsPage.detailsButtonClick();
        appInfo.assertMethod();
    }

    @Test
    public void mostPopularApps() {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "DEVELOPER");
        headerPage.myApplicationsButtonClick();
        myapplicationsPage.myApplicationsButtonClick();
        appName = newapplicationPage.getAppName();
        newapplicationPage.createNewApplicationWithoutImages(appName);
        myapplicationsPage.detailsButtonClick();
        int i = 1;
        while (i <= 5) {
            appInfo.downloadButtonClick();
            driver.navigate().back();
            i = i + 1;
        }
        driver.navigate().refresh();
        appInfo.printNumber();
        assertThat(appInfo.verifyPopularApps()).isEqualTo(appName);
        appInfo.verifyAppDetails();
    }

    @Test
    public void deleteApp() throws InterruptedException {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "DEVELOPER");
        headerPage.myApplicationsButtonClick();
        myapplicationsPage.myApplicationsButtonClick();
        appName = newapplicationPage.getAppName();
        newapplicationPage.createNewApplicationWithoutImages(appName);
        myapplicationsPage.detailsButtonClick();
        appInfo.deleteButtonClick();
        assertThat(messagePage.getEditMessage()).isEqualTo("Deleted");
    }
}
