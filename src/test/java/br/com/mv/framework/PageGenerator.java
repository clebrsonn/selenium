//package br.com.mv.framework;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
////Note (OB):
////Without Page Factory we can generate and return a new instance of a page by using below line.
////return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
//
//public class PageGenerator {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private PageGenerator page;
//
//
//    //Constructor
//    public PageGenerator(WebDriver driver) {
//        //Create a Chrome driver. All test classes use this.
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\projects\\sel\\src\\test\\resources\\chromedriver\\chromedriver.exe");
////        this.driver = new ChromeDriver();
//        this.driver = driver;
//
//        this.driver = new ChromeDriver();
//
//        //Create a wait. All test classes use this.
//        wait = new WebDriverWait(driver, 15);
//
//        //Maximize Window
//        driver.manage().window().maximize();
//
//        //Instantiate the Page Class
//        page = new PageGenerator(driver);
//
//
//    }
//
//    //JAVA Generics to Create and return a New Page
//    public <TPage extends BasePage> TPage GetInstance(Class<TPage> pageClass) {
//        try {
//            //Initialize the Page with its elements and return it.
//            return PageFactory.initElements(driver, pageClass);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
//}
