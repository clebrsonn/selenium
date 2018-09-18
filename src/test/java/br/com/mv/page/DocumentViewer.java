package br.com.mv.page;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


public class DocumentViewer extends BasePage {

    //*********Constructor*********
    public DocumentViewer(WebDriver driver) {
        super(driver);

        //example
//        fields.put("Username field", getDriver().findElement(By.id("email")));

        fields.put("notification success", By.cssSelector(".notifications .sucess"));
        fields.put("title", By.cssSelector(".document-view .title-text h1.title"));

        BasePage.fields = fields;
    }

    private HashMap<String, Object> fields = new HashMap<>();

}