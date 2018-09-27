package br.com.mv.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class EditorPallet extends ListElements {

    public EditorPallet(WebDriver driver) {
        super(driver);

        fields.put("editor pallet", By.cssSelector(".pg-editor-pallet div.tabs ul"));
        fields.put("document configuration", ".pg-editor-pallet div.tabs ul.nav-pills li:nth-child(1)");
        fields.put("document classification", ".pg-editor-pallet div.tabs ul.nav-pills li:nth-child(2)");
        fields.put("document header", ".pg-editor-pallet div.tabs ul.nav-pills li:nth-child(3)");
        fields.put("document rules", ".pg-editor-pallet div.tabs ul.nav-pills li:nth-child(4)");

        fields.put("pallet hide", ".pg-editor-pallet div.tabs ul.nav-pills button");

    }

    protected HashMap<String, Object> fields = new HashMap<>();
}
