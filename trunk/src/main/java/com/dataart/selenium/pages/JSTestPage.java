package com.dataart.selenium.pages;

import org.fest.assertions.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by amamchuk on 05.10.2016.
 */
public class JSTestPage extends BasicPage {

    @FindBy(xpath = TOP_FIELD_XPATH)
    WebElement topField;
    @FindBy(xpath = LEFT_FIELD_XPATH)
    WebElement leftField;
    @FindBy(xpath = PROCESS_BUTTON_XPATH)
    WebElement processButton;

    private Object val;

    public void getCoordinates () throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        val = js.executeScript("return $('.flash').offset().top");
        int top = (int)Math.round(Float.parseFloat(val.toString()));
        val = js.executeScript("return $('.flash').offset().left");
        int left = (int)Math.round(Float.parseFloat(val.toString()));

        topField.clear();
        leftField.clear();
        topField.sendKeys(Integer.toString(top));
        leftField.sendKeys(Integer.toString(left));
        processButton.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        Assertions.assertThat(alert.getText()).isEqualTo("Whoo Hoooo! Correct!");
        alert.accept();
    }

    public static final String TOP_FIELD_XPATH = "//input[@id='top']";
    public static final String LEFT_FIELD_XPATH = "//input[@id='left']";
    public static final String PROCESS_BUTTON_XPATH = "//button[@id='process']";

}
