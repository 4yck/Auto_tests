package com.dataart.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasicPage {

    @FindBy(xpath = LOGOUT_BUTTON_XPATH)
    WebElement logoutButton;
    @FindBy(xpath = MY_APPLICATIONS_BUTTON_XPATH)
    WebElement myApplicationsButton;

    public LoginPage logoutButtonClick () {
        logoutButton.click();
        return initPage(LoginPage.class);
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.xpath("//div[@class='header']/div[@class='welcome']")).getText();
    }

    public MyApplications myApplicationsButtonClick () {
        myApplicationsButton.click();
        return initPage(MyApplications.class);
    }

    public LoginPage assertButton() {
        if(driver.findElements(By.xpath("//a[text()= 'My applications']")).isEmpty())
            logoutButton.click();
            return initPage(LoginPage.class);
    }

    public static final String MY_APPLICATIONS_BUTTON_XPATH = "//a[text()= 'My applications']";
    public static final String LOGOUT_BUTTON_XPATH = "//a[text()= 'Logout']";

}
