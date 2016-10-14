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
    @FindBy(xpath = AJAX_TEST_PAGE_XPATH)
    WebElement ajaxTestPageButton;
    @FindBy(xpath = JS_TEST_PAGE_XPATH)
    WebElement JSTestPageButton;

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

    public AjaxTestPage ajaxTestPageButtonClick () {
        ajaxTestPageButton.click();
        return initPage(AjaxTestPage.class);
    }

    public JSTestPage jsTestPageButtonClick () {
        JSTestPageButton.click();
        return initPage(JSTestPage.class);
    }

    public LoginPage assertButton() {
        if(driver.findElements(By.xpath("//a[text()= 'My applications']")).isEmpty())
            logoutButton.click();
        return initPage(LoginPage.class);
    }

    public static final String MY_APPLICATIONS_BUTTON_XPATH = "//a[text()= 'My applications']";
    public static final String LOGOUT_BUTTON_XPATH = "//a[text()= 'Logout']";
    public static final String AJAX_TEST_PAGE_XPATH = "//a[text()= 'Ajax test page']";
    public static final String JS_TEST_PAGE_XPATH = "//a[text()= 'JS test page']";
}
