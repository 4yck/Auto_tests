package com.dataart.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPage {

    public HeaderPage getHeader() {
        return initPage(HeaderPage.class);
    }

    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    WebElement detailsButton;

    public ApplicationInformation detailsButtonClick () {
        detailsButton.click();
        return initPage(ApplicationInformation.class);
    }

    public static final String REGISTER_BUTTON_XPATH = "//div[@class='app'][1]/a[contains(text(),'Details')]";

}
