package com.dataart.selenium.pages;

import com.dataart.selenium.models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


/**
 * Created by amamchuk on 30.06.2016.
 */
public class RegistrationPage extends BasicPage {
    @FindBy(xpath = NAME_TEXT_FIELD_XPATH)
    WebElement nameTextField;
    @FindBy(xpath = FIRST_NAME_TEXT_FIELD_XPATH)
    WebElement firstNameTextField;
    @FindBy(xpath = LAST_NAME_TEXT_FIELD_XPATH)
    WebElement lastNameTextField;
    @FindBy(xpath = PASSWORD_TEXT_FIELD_XPATH)
    WebElement passwordTextField;
    @FindBy(xpath = CONFIRM_PASSWORD_TEXT_FIELD_XPATH)
    WebElement confirmPasswordTextField;
    @FindBy(xpath = ROLE_DROP_DOWN_MENU_XPATH)
    WebElement roleDropDownMenu;
    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    WebElement registerButton;



    public HomePage registerAsANewUser(User user, String role) {
        nameTextField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        passwordTextField.clear();
        confirmPasswordTextField.clear();
        nameTextField.sendKeys(user.getUsername());
        firstNameTextField.sendKeys(user.getFname());
        lastNameTextField.sendKeys(user.getLname());
        passwordTextField.sendKeys(user.getPassword());
        confirmPasswordTextField.sendKeys(user.getPassword());
        Select newSelect = new Select(roleDropDownMenu);
        newSelect.selectByVisibleText(role);
        registerButton.click();
        return initPage(HomePage.class);
    }

    public void ddtRegistration() throws IOException {

        String csvFile = "C:\\Users\\amamchuk\\amamchuk-aut\\Book1.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] name = line.split(cvsSplitBy);

                System.out.println("Name [name= " + name[0]/* + " , surname=" + name[1] + "]"*/);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public void ddtRegistration(BufferedReader r) throws IOException {
        String [] csvCell;
        while ((csvCell = r.readNext()) != null) {
            String Name = csvCell[0];
            String FName = csvCell[1];
            String LName = csvCell[2];
            String Password = csvCell[3];
            String ConfirmPassword = csvCell[4];
            String Role = csvCell[5];
            nameTextField.sendKeys(Name);
            firstNameTextField.sendKeys(FName);
            lastNameTextField.sendKeys(LName);
            passwordTextField.sendKeys(Password);
            confirmPasswordTextField.sendKeys(ConfirmPassword);
            Select newSelect = new Select(roleDropDownMenu);
            newSelect.selectByVisibleText(Role);
            registerButton.click();
        }
    }*/

    /*public void ddtRegistration() throws IOException {
        InputStream in = new FileInputStream("Book1.xlsx");
        HSSFWorkbook wb = new HSSFWorkbook(in);

        Sheet sheet = wb.getSheetAt(0);
        Iterator<org.apache.poi.ss.usermodel.Row> it = sheet.iterator();
        while (it.hasNext()) {
            org.apache.poi.ss.usermodel.Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "=");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print("[" + cell.getNumericCellValue() + "]");
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        System.out.print("[" + cell.getNumericCellValue() + "]");
                        break;
                    default:
                        System.out.print("|");
                        break;
                }
            }
            System.out.println();
        }
        }*/


    public static final String NAME_TEXT_FIELD_XPATH = "//input[@name = 'name']";
    public static final String FIRST_NAME_TEXT_FIELD_XPATH = "//input[@name = 'fname']";
    public static final String LAST_NAME_TEXT_FIELD_XPATH = "//input[@name = 'lname']";
    public static final String PASSWORD_TEXT_FIELD_XPATH = "//input[@name = 'password']";
    public static final String CONFIRM_PASSWORD_TEXT_FIELD_XPATH = "//input[@name = 'passwordConfirm']";
    public static final String ROLE_DROP_DOWN_MENU_XPATH = "//select[@name = 'role']";
    public static final String REGISTER_BUTTON_XPATH = "//input[@type = 'submit' and @value = 'Register']";

}
