package br.com.mv.framework;

import br.com.mv.framework.exceptions.BusinessException;
import br.com.mv.page.DocumentList;
import br.com.mv.page.LoginPage;
import br.com.mv.page.elements.*;
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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {


    private static WebDriver driver;
    protected static HashMap<String, Object> fields = new HashMap<>();
    protected static HashMap<String, Class> pages = new HashMap<>();

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

    public static <TPage extends BasePage> TPage getInstance(String pageName) throws BusinessException {


        //MODALS
        pages.put("New Folder", NewFolderModal.class);
        pages.put("New Document", NewDocumentModal.class);
        pages.put("New Document2", NewDocumentModal2.class);

        //PAGE ELEMENTS
        pages.put("Group List", GroupList.class);
        pages.put("Sub Group List", SubGroup.class);
        pages.put("Menu Editor", MenuEditor.class);

        //PAGES
        pages.put("Document List", DocumentList.class);
        pages.put("Login", LoginPage.class);


        Class<TPage> classe = (Class<TPage>) pages.get(pageName);

        if (classe == null) {
            throw new BusinessException("Página '" + pageName + "' não Encontrada");
        }


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

    public <T> void selectValue(T elementAttr, String value) {
        Select select = new Select(getWebElement(elementAttr));
        select.selectByVisibleText(value);
        new WebDriverWait(driver, 30);

    }


    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click(T elementAttr) {

        getWebElement(elementAttr).click();
    }

    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText(T elementAttr, String text) {
        getWebElement(elementAttr).clear();
        getWebElement(elementAttr).sendKeys(text);
    }

    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText(T elementAttr) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        //NOTIFICATIONS
        fields.put("notification success", By.cssSelector(".notifications .sucess"));
        fields.put("notification warning", By.cssSelector(".notifications .warning"));
        fields.put("notification error", By.cssSelector(".notifications .error"));

        fields.put("notification title", By.cssSelector(".notifications .notification-title"));
        fields.put("notification description", By.cssSelector(".notifications .notification-content"));


        if (condition.equalsIgnoreCase(Comparator.VISIBLE)) {
            new WebDriverWait(getDriver(), 20)
                    .until(ExpectedConditions
                            .visibilityOf(getWebElement(element)));

        } else if (condition.equalsIgnoreCase(Comparator.INVISIBLE)) try {
            new WebDriverWait(getDriver(), 20)
                    .until(ExpectedConditions.invisibilityOf(getWebElement(element)));

        } catch (NoSuchElementException e) {
            System.out.println(e);

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
