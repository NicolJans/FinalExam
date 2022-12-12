package baseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

//EXTENDING THE LOGINTEST TO BASETEST TO USE FUNCTIONALITY OF CHROME , SCREENSHOTS AND CLOSING OF SESSION
public class HealthcareTest extends BaseTest {

    //ANNOTATION WITH PRIORITY GIVEN TO TEST, CALLING THE DATA PROVIDER BY NAME GIVEN
    @Test(priority = 1, dataProvider = "UserDetails")
    public void loginTest(String Username1, String Password1) {

        //ACCESSING THE MAKE APPOINTMENT BUTTON [ELEMENT]  ON THE HOMEPAGE
        LoginPage loginPage = homepage.clickOnMakeAppLink();

        //ASSERT THAT LOGIN PAGE/SESSION IS BEING DISPLAYED
        Assert.assertEquals(loginPage.assertLoginPage(),"Login");

        //ENTER USERNAME AND PASSWORD DATA FROM DATA PROVIDER
        loginPage.setUserName(Username1);
        loginPage.setPassword(Password1);

        //ACCESSING THE LOGIN BUTTON [ELEMENT] ON THE LOGINSPAGE
        loginPage.clickOnLoginBtn();
    }

    //CREATING OF DATAPROVIDER
    @DataProvider()
    public Object[][] UserDetails() {
        Object[][] data = new Object[1][2];
        data[0][0] = "John Doe";data[0][1]="ThisIsNotAPassword";
        return data;
    }

    //ANNOTATION WITH PRIORITY GIVEN TO TEST, CALLING THE DATA PROVIDER BY NAME GIVEN
    @Test (priority = 2, dataProvider = "AppointmentDetails")
    public void appointmentTest(String facility, String reAdMit,String healthprog, String date, String comment) {

        //ASSERT THAT LOGIN PAGE/SESSION IS BEING DISPLAYED
        Assert.assertEquals(homepage.assertAppPage(), "Make Appointment");

        //SELECTING FACILITY
        homepage.setFacility(facility);

        //SETTING THE READMISSION FLAG
        homepage.setReadmission(reAdMit);

        //SELECTING HEALTHCARE PROGRAM RADIO BUTTON
        homepage.setMEDICAREPrgm(healthprog);

        //CLICKING THE CALENDER ICON
        homepage.clickCalendar();

        //SELECTING A DATE
        homepage.setDATE(date);

        //ENTERING A COMMENT
        homepage.commentStuff(comment);

        //ACCESSING THE BOOK APPOINTMENT BUTTON [ELEMENT]
        homepage.bookApntmntButton();

        //VALIDATION OF APPOINTMENT MADE
        Assert.assertTrue(homepage.getFacility().contains(facility));
        Assert.assertTrue(homepage.getreadMission().contains(reAdMit));
        Assert.assertTrue(homepage.gethealthProg().contains(healthprog));
        Assert.assertTrue(homepage.getvisitDate().contains(date));
        Assert.assertTrue(homepage.getComment().contains(comment));

        //ACCESSING THE GO HOME BUTTON [ELEMENT]
        homepage.go2HomeBtn();

    }

    //CREATING OF DATAPROVIDER
    @DataProvider()
    public Object[][] AppointmentDetails() {
        Object[][] data = new Object[1][5];
        data[0][0] = "Seoul CURA Healthcare Center";
        data[0][1] = "Yes";
        data[0][2] = "None";
        data[0][3] = "20/12/2022";
        data[0][4] = "Adding text to the Comment field";

        /*
        data[0][0] = "Tokyo CURA Healthcare Center";
        data[0][1] = "Yes";
        data[0][2] = "Medicare";
        data[0][3] = "20/12/2022";
        data[0][4] = "Adding text to the Comment field";

        data[0][0] = "Hongkong CURA Healthcare Center";
        data[0][1] = "Yes";
        data[0][2] = "Medicaid";
        data[0][3] = "20/12/2022";
        data[0][4] = "Adding text to the Comment field";
         */
        return data;
    }

}
