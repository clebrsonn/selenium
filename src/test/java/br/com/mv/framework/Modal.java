package br.com.mv.framework;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Modal extends BasePage {

    public Modal(WebDriver driver) {
        super(driver);
        this.fields.put("body", By.className("modal-body"));
        this.fields.put("footer", By.className("modal-footer"));

        BasePage.fields = this.fields;
    }

    protected HashMap<String, Object> fields = new HashMap<>();

    @Override
    public <T> void click(T elementAttr) {
        super.click(elementAttr);

        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        super.click(elementAttr);

    }
}
