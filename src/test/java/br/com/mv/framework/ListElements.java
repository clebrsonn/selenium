package br.com.mv.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListElements extends BasePage {


    public ListElements(WebDriver driver) {
        super(driver);
    }


    @Override
    public <T> void click(T elementAttr) {
        getWebElement(elementAttr).click();

    }

    public void doubleClickInList(String list, String value) {

        WebElement webElement = getWebElement(list);
        webElement.click();
        WebElement a = new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(webElement, By.linkText(value)));


        Actions actions = new Actions(getDriver());

        actions.doubleClick(getWebElement(a));
    }

    public <T> void selectValueInList(T element, String childElement) {
        WebElement webElement = getWebElement(element);
        webElement.click();
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(webElement, By.linkText(childElement)));
        webElement.findElement(By.linkText(childElement)).click();
    }


    public void selectValueInListByPosition(int position, String condition) {


    }
}
