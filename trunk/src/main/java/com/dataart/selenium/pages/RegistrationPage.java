package com.dataart.selenium.pages;

import com.dataart.selenium.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 * Created by amamchuk on 30.06.2016.
 */
public class RegistrationPage extends BasicPage {
    @FindBy(xpath = NAME_TEXT_FIELD_XPATH)
    WebElement nameTextField;
    @FindBy(xpath = FIRST_NAME_TEXT_FIELD_XPATH)
    WebElement firstNameTextField;
    @FindBy(xpath = LAST_NAME_TEXT_FIELD_XPATH)
    WebElement lastNameTextField;
    @FindBy(xpath = PASSWORD_TEXT_FIELD_XPATH)
    WebElement passwordTextField;
    @FindBy(xpath = CONFIRM_PASSWORD_TEXT_FIELD_XPATH)
    WebElement confirmPasswordTextField;
    @FindBy(xpath = ROLE_DROP_DOWN_MENU_XPATH)
    WebElement roleDropDownMenu;
    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    WebElement registerButton;
    //String l = "";
    String cvsSplitBy = ";";

    public HomePage registerAsANewUser(User user, String role) {
        nameTextField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        passwordTextField.clear();
        confirmPasswordTextField.clear();
        nameTextField.sendKeys(user.getUsername());
        firstNameTextField.sendKeys(user.getFname());
        lastNameTextField.sendKeys(user.getLname());
        passwordTextField.sendKeys(user.getPassword());
        confirmPasswordTextField.sendKeys(user.getPassword());
        Select newSelect = new Select(roleDropDownMenu);
        newSelect.selectByVisibleText(role);
        registerButton.click();
        return initPage(HomePage.class);
    }

    public void ddtRegistration(String l) throws IOException {

        String[] name = l.split(cvsSplitBy);

        nameTextField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        passwordTextField.clear();
        confirmPasswordTextField.clear();
        nameTextField.sendKeys(name[0]);
        firstNameTextField.sendKeys(name[1]);
        lastNameTextField.sendKeys(name[2]);
        passwordTextField.sendKeys(name[3]);
        confirmPasswordTextField.sendKeys(name[4]);
        Select newSelect = new Select(roleDropDownMenu);
        newSelect.selectByVisibleText(name[5]);
        registerButton.click();
    }

    public static final String NAME_TEXT_FIELD_XPATH = "//input[@name = 'name']";
    public static final String FIRST_NAME_TEXT_FIELD_XPATH = "//input[@name = 'fname']";
    public static final String LAST_NAME_TEXT_FIELD_XPATH = "//input[@name = 'lname']";
    public static final String PASSWORD_TEXT_FIELD_XPATH = "//input[@name = 'password']";
    public static final String CONFIRM_PASSWORD_TEXT_FIELD_XPATH = "//input[@name = 'passwordConfirm']";
    public static final String ROLE_DROP_DOWN_MENU_XPATH = "//select[@name = 'role']";
    public static final String REGISTER_BUTTON_XPATH = "//input[@type = 'submit' and @value = 'Register']";

}
