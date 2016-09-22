package com.dataart.selenium.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

import com.dataart.selenium.pages.BasicPage;
//import com.opencsv.CSVReader;

import static com.dataart.selenium.framework.BasePage.initPage;

/**
 * Created by amamchuk on 22.09.2016.
 */
public class CSVRead extends BasicPage {

    String CSV_PATH="D:\\Detail.csv";
    public BufferedReader csvRead() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader(CSV_PATH));
        return reader;
    }
}
