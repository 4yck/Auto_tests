package com.dataart.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by amamchuk on 04.08.2016.
 */
public class ApplicationInformation extends BasicPage{

    public String description;
    public String category;
    public String author;
    public String numberOfDownloads;

    @FindBy(xpath = DOWNLOAD_BUTTON_XPATH)
    WebElement downloadButton;
    @FindBy(xpath = DESCRIPTION_XPATH)
    WebElement descriptionXPath;
    @FindBy(xpath = CATEGORY_XPATH)
    WebElement categoryXPath;
    @FindBy(xpath = AUTHOR_XPATH)
    WebElement authorXPath;
    @FindBy(xpath = NUMBER_OF_DOWNLOADS_XPATH)
    WebElement numberXPath;
    @FindBy(xpath = EDIT_BUTTON_XPATH)
    WebElement editButton;
    @FindBy(xpath = POPULAR_APPS_XPATH)
    WebElement popularAppButton;
    @FindBy(xpath = DELETE_BUTTON_XPATH)
    WebElement deleteButton;

    public ApplicationInformation getInfo () {
        ApplicationInformation object = new ApplicationInformation();
        object.description = descriptionXPath.getText();
        object.category = categoryXPath.getText();
        object.author = authorXPath.getText();
        object.numberOfDownloads = (numberXPath.getText());
        return object;
    }


    public JsonResponse downloadButtonClick () {
        downloadButton.click();
        return initPage(JsonResponse.class);
    }

    public EditPage editButtonClick () {
        editButton.click();
        return initPage(EditPage.class);
    }

    public MessagePage deleteButtonClick () throws InterruptedException {
        deleteButton.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return initPage(MessagePage.class);
    }

    public void assertMethod(){
        Assert.assertTrue(downloadButton.isDisplayed());
    }

    public void printNumber() {System.out.println(numberXPath.getText());}

    public String verifyPopularApps() {
        String name = driver.findElement(By.xpath("//div[@class='popular-app']/a/div")).getText();
        return name;
    }

    public void verifyAppDetails() {
        popularAppButton.click();
        Assert.assertTrue(descriptionXPath.isDisplayed());
        Assert.assertTrue(categoryXPath.isDisplayed());
        Assert.assertTrue(authorXPath.isDisplayed());
        Assert.assertTrue(numberXPath.isDisplayed());
    }

    public static final String DOWNLOAD_BUTTON_XPATH = "//a[contains(text(),'Download')]";
    public static final String DESCRIPTION_XPATH = "//div[contains(text(),'Description')]";
    public static final String CATEGORY_XPATH = "//div[contains(text(),'Category')]";
    public static final String AUTHOR_XPATH = "//div[contains(text(),'Author')]";
    public static final String NUMBER_OF_DOWNLOADS_XPATH = "//div[contains(text(),'# of downloads')]";
    public static final String EDIT_BUTTON_XPATH = "//div[@class='edit-app-button']/a[contains(text(),'Edit')]";
    public static final String POPULAR_APPS_XPATH = "//div[@class='popular-app']/a/div[contains(text(),'App_01')]";
    public static final String DELETE_BUTTON_XPATH = "//div[@class='edit-app-button']/a[contains(text(),'Delete')]";
}
