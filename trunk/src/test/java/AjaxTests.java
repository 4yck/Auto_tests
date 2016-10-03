import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.models.UserBuilder.newDeveloper;

/**
 * Created by macchook on 01/10/16.
 */
public class AjaxTests extends BaseTest {

    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;
    private User user;
    private AjaxTestPage ajaxTestPage;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        registrationPage = initPage(RegistrationPage.class);
        headerPage = initPage(HeaderPage.class);
        ajaxTestPage = initPage(AjaxTestPage.class);
    }

    @Test
    public void ajaxTrue() {
        user = newDeveloper();
        loginPage.registerANewUser();
        registrationPage.registerAsANewUser(user, "DEVELOPER");
        headerPage.ajaxTestPageButtonClick();
        ajaxTestPage.sumXandY();
    }
}
