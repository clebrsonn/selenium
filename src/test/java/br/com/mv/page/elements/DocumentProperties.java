package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.EditorPallet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentProperties extends EditorPallet {

    public DocumentProperties(WebDriver driver) {
        super(driver);


        fields.put("document name",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-palett-document-properties section label:contains(Nome) + input"));

        fields.put("document indentifier",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-palett-document-properties section label:contains(Identificador) + input"));


        fields.put("largura do documento",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-palett-document-properties section div.doc.size .largura input"));


        fields.put("altura do documento",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-palett-document-properties section div.doc.size .altura input"));


        fields.put("document tags",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-palett-document-properties section div.doc .vue-tags-input"));


        fields.put("save button",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-pallet-footer button:nth-child(1)"));

        fields.put("reset button",
                By.cssSelector(".pg-editor-pallet div.tabs .tab-panel div.palett-properties " +
                        ".edit-pallet-footer button:nth-child(2)"));

        BasePage.fields = this.fields;
    }
}
