package br.com.mv.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Modal extends BasePage {

    public Modal(WebDriver driver) {
        super(driver);
        this.fields.put("body", By.className("modal-body"));
        this.fields.put("footer", By.className("modal-footer"));


        BasePage.fields = this.fields;
    }

    protected HashMap<String, Object> fields = new HashMap<>();

    @Override
    public <T> void click(T elementAttr) {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions
                        .elementToBeClickable((By) fields.get(elementAttr)));

        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        super.click(elementAttr);
        if (getWebElement(elementAttr).isDisplayed() && getWebElement(elementAttr).isEnabled()) {
            super.click(elementAttr);
        }
    }
}
