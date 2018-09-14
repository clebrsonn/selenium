package br.com.mv.page;

import br.com.mv.framework.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);

//        fields.put("Username field", getDriver().findElement(By.id("email")));
//        fields.put("Password field", getDriver().findElement(By.id("password")));
//        fields.put("login button", getDriver().findElement(By.id("loginButton")));
//        fields.put("error message username", getDriver().findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div")));
//        fields.put("error message password", errorMessagePassword);


    }

    //*********Web Elements by using Page Factory*********
//    @FindBy(how = How.ID, using = "email")
//    public WebElement username;
//
//    @FindBy(how = How.ID, using = "password")
//    public WebElement password;
//
//    @FindBy(how = How.ID, using = "loginButton")
//    public WebElement loginButton;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[1]/div/div")
//    public WebElement errorMessageUsername;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
//    public WebElement errorMessagePassword;


    //*********Page Methods*********
//    public void loginToN11(String pusername, String ppassword) {
//        //Enter Username(Email)
//        writeText(username, pusername);
//        //Enter Password
//        writeText(password, ppassword);
//        //Click Login Button
//        click(loginButton);
//    }
//
//    //Verify Username Condition
//    public void verifyLoginUserName(String expectedText) {
//        Assert.assertEquals(readText(errorMessageUsername), expectedText);
//    }
//
//    //Verify Password Condition
//    public void verifyLoginPassword(String expectedText) {
//        Assert.assertEquals(readText(errorMessagePassword), expectedText);
//    }
}
