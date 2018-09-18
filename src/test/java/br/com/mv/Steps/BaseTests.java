package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTests {

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\projects\\sel\\src\\test\\resources\\chromedriver\\chromedriver.exe");


        //Create a Chrome driver. All test classes use this.
        WebDriver driver = new ChromeDriver();

        //Create a wait. All test classes use this.
//        wait = new WebDriverWait(driver, 15);

        //Maximize Window
        driver.manage().window().maximize();

        BasePage.setDriver(driver);

        //Instantiate the Page Class

        //page = new BasePage(driver);

        BasePage.getDriver().get("http://editor3-app-balancer-343154102.us-east-1.elb.amazonaws.com/mveditor/index.html");

//        Thread.sleep(500);

    }


    @After
    public void teardown() {
        BasePage.getDriver().quit();
    }

}
