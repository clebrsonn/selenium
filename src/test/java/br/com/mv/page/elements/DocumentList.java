package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class DocumentList extends ListElements {


    public DocumentList(WebDriver driver) {
        super(driver);

        fields.put("document list", (By.className("edit-document-list")));
        BasePage.fields = fields;

        chargeList();
    }

    protected HashMap<String, Object> fields = new HashMap<>();


    private void chargeList() {

        List<WebElement> elements = getDriver().findElements(By.cssSelector(".edit-document-list > div.card"));
        elements.forEach(webElement -> fields.put(webElement.getText().split("\n")[1], webElement));
    }

}
