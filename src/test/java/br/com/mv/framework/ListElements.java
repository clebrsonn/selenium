package br.com.mv.framework;

import br.com.mv.framework.exceptions.BusinessException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListElements extends BasePage {


    public ListElements(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public <T> void selectValueInListWithList(T element, String childElement) {
        WebElement webElement = getWebElement(element);
        webElement.click();
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(webElement, By.linkText(childElement)));
        webElement.findElement(By.linkText(childElement)).click();
    }

    public void selectValueInList(String value) {
        WebElement webElement = new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.linkText(value)));
        webElement.click();
    }


    public WebElement selectValueInListByPosition(int position) {

        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return getDriver().findElement(By.cssSelector(" li:nth-child(" + position + ")"));
    }


    public void doubleClickInPosition(int position) {
        doubleClick(selectValueInListByPosition(position));
    }

    public void existElementWithValueInList(String value, String condition, String list) throws BusinessException {
        List<WebElement> elements = getWebElement(list).findElements(By.linkText(value));

        if (elements == null && condition.equalsIgnoreCase(Comparator.NOTEXISTS)) {
            throw new BusinessException("Elemento " + condition + "!");
        }
        assert elements != null;
        if (condition.equalsIgnoreCase(Comparator.EXIST) && elements.size() == 0) {
            throw new BusinessException("Elemento " + condition + "!");
        }

    }
}
