package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by macchook on 24/09/16.
 */
public class EditPage extends BasicPage {
    @FindBy(xpath = DESCRIPTION_XPATH)
    WebElement descriptionField;
    @FindBy(xpath = UPDATE_BUTTON_XPATH)
    WebElement updateButton;

    public MessagePage updateApplication() {
        descriptionField.clear();
        descriptionField.sendKeys("Description for App_01_update");
        updateButton.click();
        return initPage(MessagePage.class);
    }

    public static final String DESCRIPTION_XPATH = "//textarea[@name='description']";
    public static final String UPDATE_BUTTON_XPATH = "//input[@type = 'submit' and @value = 'Update']";
}
