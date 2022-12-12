package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    //DECLARING CHROME DRIVER VARIABLE
    private WebDriver driver;

    //DECLARING VARIABLE FOR ELEMENT ON PAGE/SESSION
    private By makeAppointment = By.linkText("Make Appointment");

    //CREATING THE CONSTRUCTOR FOR THE CHROME DRIVER
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //METHOD TO INTERACT WITH THE "MAKE APPOINTMENT" BUTTON
    public LoginPage clickOnMakeAppLink() {
        driver.findElement(makeAppointment).click();
        return new LoginPage(driver);
    }

    //APPOINTMENTPAGE DECLARATIONS AND METHODS
    private By appointmentAssert = By.linkText("Make Appointment");
    private By facilityDropdown = By.id("combo_facility");
    private By reAdMitflag = By.cssSelector("input[type='checkbox'][value='Yes']");
    private By healthprogram3 = By.cssSelector("input[type='radio'][value='None']");
    private By calendarPick = By.cssSelector("input[type='text'],[placeholder='dd/mm/yyyy]");
    private By setDate20 = By.cssSelector("body > div > div.datepicker-days > table > tbody > tr:nth-child(4) > td:nth-child(3)");
    private By comMent = By.name("comment");
    private By bookApBtn = By.cssSelector("#btn-book-appointment");


    //METHOD TO OBTAIN THE APPOINTMENT PAGE HEADING
    public String assertAppPage() {
        return driver.findElement(appointmentAssert).getText();
    }

    //METHOD TO INTERACT WITH THE FACILITY DROPDOWN LIST
    public void setFacility(String facility) {
        driver.findElement(facilityDropdown).sendKeys(facility);
    }

    //METHOD TO SELECT TICK BOX
    public void setReadmission(String reAdMit) {
        driver.findElement(reAdMitflag).click();
    }

    //METHOD TO SELECT HEALTHCARE PROGRAMS
    public void setMEDICAREPrgm(String medicare) {
        driver.findElement(healthprogram3).click();
    }

    //METHOD FOR CLICKING ON DATE TABLE
    public void clickCalendar() {
        driver.findElement(calendarPick).click();
    }

    //METHODS SELECTING A DATE
    public void setDATE(String date) {
        driver.findElement(setDate20).click();
    }

    //METHOD TO ENTER A COMMENT
    public void commentStuff(String comment) {
        driver.findElement(comMent).click();
        driver.findElement(comMent).sendKeys(comment);
    }

    //METHOD TO SELECT BOOK APPOINTMENT BUTTON
    public void bookApntmntButton() {
        driver.findElement(bookApBtn).submit();

    }

    //SUMMARYPAGE DECLARATIONS AND METHODS
    private By facilityText = By.cssSelector("#facility");
    private By readmissionText = By.cssSelector("#hospital_readmission");
    private By healthprogText = By.id("program");
    private By visitdateText = By.cssSelector("#visit_date");
    private By commentText = By.cssSelector("#comment");
    private By go2HomePageBtn = By.cssSelector("#summary > div > div > div:nth-child(7) > p > a");
    private By hamburgerMenu = By.cssSelector("#to-top > i");

    //METHODS TO VALIDATE APPOINTMENT
    public String getFacility(){return driver.findElement(facilityText).getText();}

    public String getreadMission(){return driver.findElement(readmissionText).getText();}

    public String gethealthProg(){return driver.findElement(healthprogText).getText();}

    public String getvisitDate(){return driver.findElement(visitdateText).getText();}

    public String getComment(){return driver.findElement(commentText).getText();}

    //METHOD TO ACCESS THE GO HOME BUTTON
    public void go2HomeBtn(){driver.findElement(go2HomePageBtn).click();}

}






