package com.dataart.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public static final String DOWNLOAD_BUTTON_XPATH = "//a[contains(text(),'Download')]";
    public static final String DESCRIPTION_XPATH = "//div[contains(text(),'Description')]";
    public static final String CATEGORY_XPATH = "//div[contains(text(),'Category')]";
    public static final String AUTHOR_XPATH = "//div[contains(text(),'Author')]";
    public static final String NUMBER_OF_DOWNLOADS_XPATH = "//div[contains(text(),'# of downloads')]";


}
