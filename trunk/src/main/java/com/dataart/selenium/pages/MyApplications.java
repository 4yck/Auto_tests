package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by amamchuk on 11.07.2016.
 */
public class MyApplications extends BasicPage{

    @FindBy(xpath = ADD_NEW_APPLICATION_BUTTON_XPATH)
    WebElement addNewApplicationButton;

    public NewApplication myApplicationsButtonClick () {
        addNewApplicationButton.click();
        return initPage(NewApplication.class);
    }

    public static final String ADD_NEW_APPLICATION_BUTTON_XPATH = "//a[text()= 'Click to add new application']";

}
