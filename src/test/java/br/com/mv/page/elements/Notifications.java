package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Notifications extends BasePage {
    public Notifications(WebDriver driver) {
        super(driver);

        fields.put("notification success", (By.cssSelector(".notifications .sucess")));
        fields.put("notification warning", (By.cssSelector(".notifications .warning")));
        fields.put("notification error", (By.cssSelector(".notifications .error")));

        fields.put("notification title", (By.cssSelector(".notifications .notification-title")));
        fields.put("notification description", (By.cssSelector(".notifications .notification-content")));


    }

    protected HashMap<String, Object> fields = new HashMap<>();

}
