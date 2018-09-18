package br.com.mv.page.elements;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.Modal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewFolderModal extends Modal {


    public NewFolderModal(WebDriver driver) {
        super(driver);

        this.fields.put("new folder modal", (By.cssSelector("#new-folder-modal .modal-header")));
        fields.put("folder name", (By.cssSelector("#new-folder-modal .modal-body > .name > input")));
        fields.put("folder directory", (By.cssSelector("#new-folder-modal .modal-body > .directory > select")));
        fields.put("botão salvar", (By.cssSelector("#new-folder-modal .modal-footer > button.btn-outline-primary")));
        fields.put("botão cancelar", (By.cssSelector("#new-folder-modal .modal-footer > button.btn-outline-default")));

        BasePage.fields = this.fields;
    }


}
