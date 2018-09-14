package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MenuEditor extends HomePage {


    public MenuEditor(WebDriver driver) {
        super(driver);


        HashMap<String, By> fields = new HashMap<>();
        fields.put("botão Nova Pasta", (By.id("new-folder")));
        fields.put("botão import", (By.id("import")));
        fields.put("botão export", (By.id("export")));

        BasePage.fields = fields;
    }


}
