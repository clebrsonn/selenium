package br.com.mv.page;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) {
        super(driver);

        //example
//        fields.put("Username field", getDriver().findElement(By.id("email")));
    }

    private HashMap<String, WebElement> fields;

}