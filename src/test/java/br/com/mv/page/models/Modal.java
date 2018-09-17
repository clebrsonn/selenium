package br.com.mv.page.models;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Modal extends BasePage {

    public Modal(WebDriver driver) {
        super(driver);
        this.fields.put("body", By.className("modal-body"));
        this.fields.put("footer", By.className("modal-footer"));

        BasePage.fields = this.fields;
    }

    protected HashMap<String, Object> fields = new HashMap<>();


}
