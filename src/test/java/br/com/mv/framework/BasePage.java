package br.com.mv.framework;

import br.com.mv.framework.exceptions.BusinessException;
import br.com.mv.page.HomePage;
import br.com.mv.page.LoginPage;
import br.com.mv.page.elements.DocumentList;
import br.com.mv.page.elements.MenuEditor;
import br.com.mv.page.elements.NewFolderModal;
import br.com.mv.page.elements.SubGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class BasePage {


    private static WebDriver driver;
    protected static HashMap<String, Object> fields = new HashMap<>();

    protected static HashMap<String, Object> pages = new HashMap<>();

    public BasePage(WebDriver driver) {
        setDriver(driver);
        new WebDriverWait(driver, 30).until(driver1 -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    //JAVA Generics to Create and return a New Page

    public static <TPage extends BasePage> TPage getInstance(String pageName) {
        pages.put("new folder modal", NewFolderModal.class);
        pages.put("Document List", DocumentList.class);
        pages.put("Sub Group List", SubGroup.class);
        pages.put("Menu Editor", MenuEditor.class);
        pages.put("Home", HomePage.class);
        pages.put("Login", LoginPage.class);


        Class<TPage> classe = (Class<TPage>) pages.get(pageName);


        return getInstance(classe);
    }

    public static <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(getDriver(), pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public <T> void selectValue(T elementAttr, String value) throws InterruptedException {
        Select select = new Select(getWebElement(elementAttr));
        select.selectByVisibleText(value);
        new WebDriverWait(driver, 30);

    }


    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click(T elementAttr) {

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .elementToBeClickable(getWebElement(elementAttr)));
        getWebElement(elementAttr).click();
    }

    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText(T elementAttr, String text) {
        getWebElement(elementAttr).clear();
        getWebElement(elementAttr).sendKeys(text);
    }

    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText(T elementAttr) {
        return getWebElement(elementAttr).getText();
    }

    //Close popup if exists
    public void handlePopup(By by) throws InterruptedException {
        List<WebElement> popup = getDriver().findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            Thread.sleep(200);
        }
    }


    public void navegateTo(String s) {
        getDriver().navigate().to(s);
    }

    public ExpectedCondition<Boolean> iAmOn(String title) {
        return ExpectedConditions.titleIs(title);
    }


    public <T> void isPresent(String elementAttr) {

        By element = (By) fields.get(elementAttr);

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(element));
    }


    public void isActive(String element, String condition) throws BusinessException {
        boolean active = false;
        if (condition.equalsIgnoreCase(Comparator.ACTIVE)) {
            active = getWebElement(element).isEnabled();

        } else if (condition.equalsIgnoreCase(Comparator.INACTIVE)) {
            active = !getWebElement(element).isEnabled();
        }

        if (!active) {
            throw new BusinessException("Elemento não está " + condition + "!");
        }

    }

    public void isVisible(String element, String condition) {
        if (condition.equalsIgnoreCase(Comparator.VISIBLE)) {
            new WebDriverWait(getDriver(), 20)
                    .until(ExpectedConditions
                            .visibilityOf(getWebElement(element)));

        } else if (condition.equalsIgnoreCase(Comparator.INVISIBLE)) {
            new WebDriverWait(getDriver(), 20)
                    .until(ExpectedConditions.invisibilityOf(getWebElement(element)));
        }
    }

    protected <T> WebElement getWebElement(T elementAttr) {
        if (elementAttr instanceof String) {
            elementAttr = (T) fields.get(elementAttr);
        }
        if (elementAttr.getClass().getName().contains("By")) {
            return getDriver().findElement((By) elementAttr);
        } else {
            return (WebElement) elementAttr;
        }

    }

    public <T> void doubleClick(T element) {

        Actions actions = new Actions(getDriver());

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .visibilityOf(getWebElement(element)));


        actions.doubleClick(getWebElement(element)).perform();
    }


}
