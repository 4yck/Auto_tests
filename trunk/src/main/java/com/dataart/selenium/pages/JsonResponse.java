package com.dataart.selenium.pages;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.json.simple.JSONObject;
import org.json.JSONException;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by amamchuk on 09.08.2016.
 */
public class JsonResponse extends BasicPage {

    @FindBy(xpath = JSONRESPONSE_XPATH)
    WebElement jsonResponse;
    int i;
    String number_str;

    public void gettingJsonText (ApplicationInformation a) throws JSONException, ParseException {

        i = Integer.parseInt(a.numberOfDownloads.substring(a.numberOfDownloads.lastIndexOf(':')+2))+1;
        number_str = Integer.toString(i);

        String json = jsonResponse.getText();

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        JSONObject jo_1 = (JSONObject) jsonObj.get("category");
        JSONObject jo_2 = (JSONObject) jsonObj.get("author");
        assertEquals(jsonObj.get("description").toString(),a.description.substring(a.description.lastIndexOf(':')+2));
        assertEquals(jo_1.get("title"), a.category.substring(a.category.lastIndexOf(':')+2));
        assertEquals(jo_2.get("name"), a.author.substring(a.author.lastIndexOf(':')+2));
        assertEquals(jsonObj.get("numberOfDownloads").toString(), number_str);
    }

    public static final String JSONRESPONSE_XPATH = "//body/pre";

}
