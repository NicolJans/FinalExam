package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //DECLARING CHROME DRIVER VARIABLE
    private WebDriver driver;

    //DECLARING VARIABLES FOR ELEMENT ON LOGIN PAGE/SESSION
    private By loginAssert = By.tagName("h2");
    private By userNameField = By.name("username");
    private By passwordField = By.name("password");
    private By login = By.id("btn-login");

    //CREATING THE CONSTRUCTOR FOR THE CHROME DRIVER
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //METHOD TO INTERACT WITH THE USERNAME FIELD
    public void setUserName(String username1){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username1);
    }

    //METHOD TO INTERACT WITH THE PASSWORD FIELD
    public void setPassword(String password1){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password1);
    }

    //METHOD TO INTERACT WITH THE LOGIN BUTTON
    public void clickOnLoginBtn(){
        driver.findElement(login).click();
        }

    //METHOD TO OBTAIN THE LOGIN HEADING
    public String assertLoginPage(){return  driver.findElement(loginAssert).getText();
    }

    //METHOD TO OBTAIN THE APPOINTMENT PAGE HEADING
    //public String assertAppPage(){
      //  return driver.findElement(appointmentAssert).getText();
   // }


}
