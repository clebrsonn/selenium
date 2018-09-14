package br.com.mv.framework;

import br.com.mv.page.HomePage;
import br.com.mv.page.LoginPage;
import br.com.mv.page.elements.DocumentList;
import br.com.mv.page.elements.MenuEditor;
import br.com.mv.page.elements.NewFolderModal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.HashMap;
import java.util.List;

public class BasePage {


    private static WebDriver driver;
    protected static HashMap<String, By> fields = new HashMap<>();

    protected static HashMap<String, Object> pages = new HashMap<>();

    private static final String VISIBLE = "visivel";
    private static final String INVISIBLE = "invisivel";
    private static final String ACTIVE = "ativo";
    private static final String INACTIVE = "inativo";

    public BasePage(WebDriver driver) {
        setDriver(driver);
        new WebDriverWait(driver, 30).until(driver1 -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));

    }


//    public void setMap(String key, WebElement value) {
//        this.map.put(key, value);
//    }

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

//    public WebElement getMap(String key) {
//        return map.get(key);
//    }


    public <T> void selectValue(T elementAttr, String value) {
        if (elementAttr instanceof String) {
            elementAttr = (T) fields.get(elementAttr);
        }
        if (elementAttr.getClass().getName().contains("By")) {
            Select select = new Select(getDriver().findElement((By) elementAttr));
            select.selectByVisibleText(value);
        } else {
            Select select = new Select(((WebElement) elementAttr));
            select.selectByVisibleText(value);
        }
    }


    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click(T elementAttr) {

        if (elementAttr instanceof String) {

            elementAttr = (T) fields.get(elementAttr);
        }
        if (elementAttr.getClass().getName().contains("By")) {
            getDriver().findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr instanceof String) {

            elementAttr = (T) fields.get(elementAttr);
        }

        if (elementAttr.getClass().getName().contains("By")) {
            getDriver().findElement((By) elementAttr).clear();
            getDriver().findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).clear();
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText(T elementAttr) {
        if (elementAttr instanceof String) {

            elementAttr = (T) fields.get(elementAttr);
        }

        if (elementAttr.getClass().getName().contains("By")) {
            return getDriver().findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
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

        By element = fields.get(elementAttr);

        element.isDisplayed();

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(element));
    }


    public <T> void selectValueInList(T element, String childElement) {
        if (element instanceof String) {
            element = fields.get(element);
        }
        WebElement webElement = (WebElement) element;
        webElement.click();
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(webElement, By.linkText(childElement)));
        webElement.findElement(By.linkText(childElement)).click();
    }


    public void isActive(String element, String condition) throws Exception {
        boolean active = false;
        if (condition.equalsIgnoreCase(ACTIVE)) {
            active = fields.get(element).isEnabled();

        } else if (condition.equalsIgnoreCase(INACTIVE)) {
            active = !fields.get(element).isEnabled();
        }

        if (!active) {
            throw new Exception("Elemento não está " + condition + "!");
        }

    }

    public void isVisible(String element, String condition) {
        if (condition.equalsIgnoreCase(VISIBLE)) {
            new WebDriverWait(getDriver(), 10)
                    .until(ExpectedConditions
                            .visibilityOf(fields.get(element)));

        } else if (condition.equalsIgnoreCase(INVISIBLE)) {
            new WebDriverWait(getDriver(), 10)
                    .until(ExpectedConditions.invisibilityOf(fields.get(element)));
        }
    }
}
