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
    @FindBy(xpath = IMAGE_BUTTON_XPATH)
    WebElement imageButton;
    @FindBy(xpath = ICON_BUTTON_XPATH)
    WebElement iconButton;
    @FindBy(xpath = CREATE_BUTTON_XPATH)
    WebElement createButton;

    public NewApplication createNewApplicationWithoutImages() {
        titleField.clear();
        descriptionField.clear();
        titleField.sendKeys("App_01");
        descriptionField.sendKeys("Description for App_01");
        Select newSelect = new Select(categoryField);
        newSelect.selectByVisibleText("News");
        createButton.click();
        return initPage(NewApplication.class);
    }

    public NewApplication createNewApplicationWithImages() {
        titleField.clear();
        descriptionField.clear();
        titleField.sendKeys("App_01");
        descriptionField.sendKeys("Description for App_01");
        imageButton.sendKeys("C:\\Users\\amamchuk\\Auto_tests\\фото.jpg");
        iconButton.sendKeys("C:\\Users\\amamchuk\\Auto_tests\\фото.jpg");
        Select newSelect = new Select(categoryField);
        newSelect.selectByVisibleText("News");
        createButton.click();
        return initPage(NewApplication.class);
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//div[2]/h1")).getText();
    }

    public static final String TITLE_XPATH = "//input[@name='title']";
    public static final String DESCRIPTION_XPATH = "//textarea[@name='description']";
    public static final String CATEGORY_XPATH = "//select[@name = 'category']";
    public static final String IMAGE_BUTTON_XPATH = "//input[@type = 'file' and @name = 'image']";
    public static final String ICON_BUTTON_XPATH = "//input[@type = 'file' and @name = 'icon']";
    public static final String CREATE_BUTTON_XPATH = "//input[@type = 'submit' and @value = 'Create']";
}
