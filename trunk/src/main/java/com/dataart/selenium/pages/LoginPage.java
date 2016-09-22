package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage extends BasicPage {

    @FindBy(xpath = USER_NAME_TEXT_FIELD_XPATH)
    WebElement userNameTextField;
    @FindBy(xpath = UPASSWORD_TEXT_FIELD_XPATH)
    WebElement passwordTextField;
    @FindBy(xpath = ULOGIN_BUTTON_XPATH)
    WebElement loginButton;
    @FindBy(xpath = REGISTER_AS_A_NEW_USER_BUTTON_XPATH)
    WebElement registerButton;

    public HomePage loginAs(User user) {
        userNameTextField.clear();
        passwordTextField.clear();
        userNameTextField.sendKeys(user.getUsername());
        passwordTextField.sendKeys(user.getPassword());
        loginButton.click();
        return initPage(HomePage.class);
    }

    public RegistrationPage registerANewUser() {

        registerButton.click();
        return initPage(RegistrationPage.class);
    }

    public void assertMethod () {

        Assert.assertTrue(userNameTextField.isDisplayed());
        Assert.assertTrue(passwordTextField.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());

    }

    public static final String USER_NAME_TEXT_FIELD_XPATH = "//input[@id='j_username']";
    public static final String UPASSWORD_TEXT_FIELD_XPATH = "//input[@id='j_password']";
    public static final String ULOGIN_BUTTON_XPATH = "//div[@class='form']/form/input";
    public static final String REGISTER_AS_A_NEW_USER_BUTTON_XPATH = "//div[@class='form']/a[text() = 'Register as a new user']";
}
