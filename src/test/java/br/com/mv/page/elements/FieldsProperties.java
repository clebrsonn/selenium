package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.EditorPallet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FieldsProperties extends EditorPallet {

    public FieldsProperties(WebDriver driver) {
        super(driver);


        fields.put("tab fields in document",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-content .tab-pane.active" +
                        " .tabs ul.nav-tabs li:nth-child(1)"));

        fields.put("tab fields disponibles",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-content .tab-pane.active" +
                        " .tabs ul.nav-tabs li:nth-child(2)"));


        fields.put("search fields",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-content " +
                        ".tab-pane.active .tabs  div.tab-content div.active .search-input"));

        fields.put("new field button",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-content" +
                        "div.tab-pane.show.fade.active > div.edit-pallet-footer button"));


        chargeList();

        BasePage.fields = this.fields;
    }

    private void chargeList() {
        List<WebElement> webelements = getDriver().findElements(By.cssSelector(".pg-editor-pallet div.tab-pane.show.fade.active > " +
                "div.pallet-field-document-wrapper > div.fields-wrapper > section > div.list-group"));

        int[] i = {1};

        webelements.forEach(webElement -> {
                    fields.put(webElement.getText(),
                            webElement.findElement(By.cssSelector("button:nth-child(" + i[0] + ")")));
                    i[0]++;

                }
        );
    }


}
