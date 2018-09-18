package br.com.mv.page.elements;

import br.com.mv.framework.Modal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewDocumentModal extends Modal {


    public NewDocumentModal(WebDriver driver) {
        super(driver);
        fields.put("new document modal", By.cssSelector("#new-document-modal .modal-header"));
        fields.put("search document model", By.cssSelector("#new-document-modal .modal-header .search"));
        fields.put("new document title", By.cssSelector("#new-document-modal .modal-header .dialog-title span.title"));
        fields.put("new document title description", By.cssSelector("#new-document-modal .modal-header .dialog-title span.description"));


//        ".modal-body .models section .folders ";

    }
}
