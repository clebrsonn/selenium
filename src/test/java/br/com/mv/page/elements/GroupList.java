package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class GroupList extends ListElements {


    public GroupList(WebDriver driver) {
        super(driver);

        fields.put("document list", (By.className("edit-document-list")));

        fields.put("confirm button", (By.cssSelector(".edit-document-list " +
                "> div.card  .card-header .edit .edit-buttons button.save-edit")));

        fields.put("remove button", (By.cssSelector(".edit-document-list " +
                "> div.card  .card-header .edit .edit-buttons button.delete-group")));

        fields.put("input folder name",
                (By.cssSelector(".edit-document-list > div.card .card-header .edit input")));
        chargeList();

        BasePage.fields = fields;

    }

    protected HashMap<String, Object> fields = new HashMap<>();


    private void chargeList() {

        List<WebElement> elements = getDriver().findElements(By.cssSelector(".edit-document-list > div.card"));
        elements.forEach(webElement -> fields.put(webElement.getText().split("\n")[1], webElement));
    }

}
