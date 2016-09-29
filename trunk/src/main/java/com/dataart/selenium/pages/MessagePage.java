package com.dataart.selenium.pages;

import org.openqa.selenium.By;

/**
 * Created by macchook on 24/09/16.
 */
public class MessagePage extends BasicPage {

    public String getEditMessage() {
        return driver.findElement(By.xpath("//div[@class='content']/p[@class='flash']")).getText();
    }

    /*public String getDeleteMessage() {
        return driver.findElement(By.xpath("//div[@class='content']/p[@class='flash']")).getText();
    }*/
}
