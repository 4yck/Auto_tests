package com.dataart.selenium.pages;

import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by macchook on 01/10/16.
 */
public class AjaxTestPage extends BasicPage {

    @FindBy(xpath = X_XPATH)
    WebElement xTextField;
    @FindBy(xpath = Y_XPATH)
    WebElement yTextField;
    @FindBy(xpath = SUM_BUTTON_XPATH)
    WebElement sumButton;

    private AjaxTestPage obj;

    public void sumXandY () {
        xTextField.sendKeys("21");
        Float x = Float.parseFloat("21");
        yTextField.sendKeys("22");
        Float y = Float.parseFloat("22");
        sumButton.click();
        Float sum = x + y;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Float res = Float.parseFloat(result.getText().substring(result.getText().lastIndexOf(':')+2));
        assertEquals("Check", sum, res);
    }

    public static final String X_XPATH = "//input[@id='x']";
    public static final String Y_XPATH = "//input[@id='y']";
    public static final String SUM_BUTTON_XPATH = "//button[@id='calc']";
}
