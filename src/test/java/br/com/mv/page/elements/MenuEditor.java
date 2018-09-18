package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MenuEditor extends Menu {


    public MenuEditor(WebDriver driver) {
        super(driver);


        fields.put("botão Nova Pasta", (By.id("new-folder")));
        fields.put("botão import", (By.id("import")));
        fields.put("botão export", (By.id("export")));

        //após selecionar um subgrupo
        fields.put("botão novo documento", By.cssSelector(".header-area .buttons .edit-new-document-button"));
        fields.put("search", By.cssSelector("div.header-area .search input"));
        BasePage.fields = fields;
    }

    protected HashMap<String, Object> fields = new HashMap<>();


}
