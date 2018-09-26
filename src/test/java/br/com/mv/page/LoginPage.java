package br.com.mv.page;

import br.com.mv.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);

        fields.put("username field", (By.id("username")));
        fields.put("password field", (By.id("password")));
        fields.put("login button", (By.cssSelector("input[type='submit']")));
    }

//
//    *********
//    Page Methods*********

//    public void loginToN11(String pusername, String ppassword) {
//        //Enter Username(Email)
//        writeText(username, pusername);
//        //Enter Password
//        writeText(password, ppassword);
//        //Click Login Button
//        click(loginButton);
//    }

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
