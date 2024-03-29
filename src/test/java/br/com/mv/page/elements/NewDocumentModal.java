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
import java.util.concurrent.TimeUnit;

public class NewDocumentModal extends ListElements {


    public NewDocumentModal(WebDriver driver) {
        super(driver);
        fields.put("New Document Modal", By.cssSelector("#new-document-modal .modal-header"));

        fields.put("new document modal", By.cssSelector("#new-document-modal .modal-header"));
        fields.put("search document model", By.cssSelector("#new-document-modal .modal-header .search"));
        fields.put("new document title", By.cssSelector("#new-document-modal .modal-header .dialog-title span.title"));
        fields.put("new document title description", By.cssSelector("#new-document-modal .modal-header .dialog-title span.description"));

        fields.put("botão cancelar", By.cssSelector(".modal-footer button.btn-outline-default"));
        fields.put("botão próximo", By.cssSelector(".modal-footer button.btn-outline-primary"));

        fields.put("lista de modelos", By.cssSelector(".modal-body .models section .folders .list-group"));


        fields.put("lista de templates", By.cssSelector(".modal-body .models .document-types > div"));

        chargeList();

        BasePage.fields = this.fields;

    }

    protected HashMap<String, Object> fields = new HashMap<>();


    private void chargeList() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy((By) fields.get("lista de modelos"),
                                By.cssSelector(".list-group-item span")));


        List<WebElement> elements = getDriver()
                .findElements(
                        By.cssSelector("#new-document-modal .modal-body .models section " +
                                ".folders .list-group button"));

        int[] i = {1};
        elements.forEach(

                webElement -> {
                    WebElement webElementChild = webElement.findElement(By.cssSelector(":nth-child(" + i[0] + ") span"));

                    JavascriptExecutor js = (JavascriptExecutor) getDriver();
                    js.executeScript("arguments[0].scrollIntoView();", webElementChild);
                    new WebDriverWait(getDriver(), 10)
                            .until(ExpectedConditions
                                    .elementToBeClickable(getWebElement(webElementChild)));

                    fields.put(webElementChild.getText(), webElementChild);
                    i[0]++;

                }

        );


        elements = getDriver().findElements(By.cssSelector("#new-document-modal .modal-body .models .document-types > div"));

        i[0] = 1;
        elements.forEach(webElement -> {
                    WebElement webElementChild = webElement.findElement(By.cssSelector("div:nth-child(" + i[0] + ") button label"));
                    fields.put(webElementChild.getText(), webElementChild);
                    i[0]++;

                }
        );


    }

    @Override
    public <T> void click(T elementAttr) {


        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();",
                getWebElement(elementAttr));
        
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .elementToBeClickable(getWebElement(elementAttr)));


        super.click(elementAttr);
    }
}
