package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import br.com.mv.framework.Modal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class NewDocumentModal2 extends Modal {


    public NewDocumentModal2(WebDriver driver) {
        super(driver);
        fields.put("new document modal2", By.cssSelector("#new-document-modal .modal-content"));
        fields.put("new document title", By.cssSelector("#new-document-modal .modal-body span.text"));
        fields.put("new document title description", By.cssSelector("#new-document-modal .modal-body span.description"));

        fields.put("document name", By.cssSelector("#new-document-modal .modal-body .name input"));

        fields.put("document description", By.cssSelector("#new-document-modal .modal-body .identifier input"));
        fields.put("document width", By.cssSelector("#new-document-modal .modal-body .screen-seetings .width-input input"));
        fields.put("document height", By.cssSelector("#new-document-modal .modal-body .screen-seetings .height-input input"));
        fields.put("page orientation vertical", By.cssSelector("#new-document-modal .modal-body .screen-seetings .page-orientation input[value='PORTRAIT']"));
        fields.put("page orientation horizontal", By.cssSelector("#new-document-modal .modal-body .screen-seetings .page-orientation input[value='LANDSCAPE']"));


        fields.put("botão voltar", By.cssSelector("#new-document-modal .modal-footer button.btn-outline-default"));
        fields.put("botão criar", By.cssSelector("#new-document-modal .modal-footer button.btn-outline-primary"));


        BasePage.fields = this.fields;

    }

    protected HashMap<String, Object> fields = new HashMap<>();
}
