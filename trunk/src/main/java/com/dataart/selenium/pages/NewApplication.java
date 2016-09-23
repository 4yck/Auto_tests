package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by amamchuk on 11.07.2016.
 */
public class NewApplication extends BasicPage {
    @FindBy(xpath = TITLE_XPATH)
    WebElement titleField;
    @FindBy(xpath = DESCRIPTION_XPATH)
    WebElement descriptionField;
    @FindBy(xpath = CATEGORY_XPATH)
    WebElement categoryField;
    @FindBy(xpath = CREATE_BUTTON_XPATH)
    WebElement createButton;

    public MyApplications createNewApplication() {
        titleField.clear();
        descriptionField.clear();
        titleField.sendKeys("App_01");
        descriptionField.sendKeys("Description for App_01");
        Select newSelect = new Select(categoryField);
        newSelect.selectByVisibleText("News");
        createButton.click();
        return initPage(MyApplications.class);
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//div[2]/h1")).getText();
    }

    public static final String TITLE_XPATH = "//input[@name='title']";
    public static final String DESCRIPTION_XPATH = "//textarea[@name='description']";
    public static final String CATEGORY_XPATH = "//select[@name = 'category']";
    public static final String CREATE_BUTTON_XPATH = "//input[@type = 'submit' and @value = 'Create']";
}
