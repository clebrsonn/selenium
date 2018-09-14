package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocumentList extends HomePage {


    public DocumentList(WebDriver driver) {
        super(driver);

        fields.put("document list", (By.className("edit-document-list")));
        BasePage.fields = fields;

        chargelist();
    }

    protected HashMap<String, By> fields = new HashMap<>();


    private void chargelist() {
        List<By> elements = (By.cssSelector(".edit-document-list > div.card"));
        elements.forEach(webElement -> fields.put(webElement.getText().split("\n")[1], webElement));
        fields.get("Documentos Assistenciais").findElements(By.cssSelector("div.card-body ul.sub-folders a"));
    }


}
