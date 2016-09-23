package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by amamchuk on 11.07.2016.
 */
public class MyApplications extends BasicPage{

    @FindBy(xpath = ADD_NEW_APPLICATION_BUTTON_XPATH)
    WebElement addNewApplicationButton;
    @FindBy(xpath = DETAILS_BUTTON_XPATH)
    WebElement detailsButton;


    public NewApplication myApplicationsButtonClick () {
        addNewApplicationButton.click();
        return initPage(NewApplication.class);
    }

    public ApplicationInformation detailsButtonClick () {
        detailsButton.click();
        return initPage(ApplicationInformation.class);
    }


    public static final String ADD_NEW_APPLICATION_BUTTON_XPATH = "//a[text()= 'Click to add new application']";
    public static final String DETAILS_BUTTON_XPATH = "//div[@class='app'][1]/a[contains(text(),'Details')]";

}
