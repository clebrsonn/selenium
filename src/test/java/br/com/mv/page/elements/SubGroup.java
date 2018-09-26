package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class SubGroup extends GroupList {


    public SubGroup(WebDriver driver) {
        super(driver);

        fields.put("sub group", (By.cssSelector(".edit-document-list > div.card  .card-body > ul")));


        chargeList();
        BasePage.fields = fields;
    }

    protected HashMap<String, Object> fields = new HashMap<>();


    private void chargeList() {

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy((By) BasePage.fields.get("group list"),
                                By.cssSelector(".card-body > ul")));


        List<WebElement> elements = getDriver()
                .findElements((By.cssSelector(".edit-document-list > div.card  .card-body > ul > li")));
        elements.forEach(webElement -> fields.put(webElement.getText(),
                By.linkText(webElement.getText())));


        fields.put("confirm button", (By.cssSelector(".edit-document-list " +
                "> div.card  .card-body .edit .edit-buttons button.save-edit")));

        fields.put("remove button", (By.cssSelector(".edit-document-list " +
                "> div.card  .card-body .edit .edit-buttons button.delete-group")));


//        fields.put("remove button", By.linkText("excluir"));
//        fields.put("confirm button", (By.linkText("confirmar")));
        fields.put("input folder name",
                (By.cssSelector(".edit-document-list > div.card .card-body .edit  input")));

    }


}
