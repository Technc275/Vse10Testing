package LogIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TechBook on 22.03.2017.
 */
public class LogIn
{
    public WebDriver driver;

    @Before
    public void OpenVse10()
    {
        File exe = new File("D:\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary FireFox = new FirefoxBinary(exe);
        FirefoxProfile FireFox_profile = new FirefoxProfile();
        driver = new FirefoxDriver(FireFox,FireFox_profile);
        driver.get("http://vse10.ru/login/");
    }

    @After
    public void CloseVse10()
    {
        driver.quit();
    }

    //---------------Email test-----------------

    @Test
    public void Vse10EmailFormatTest1()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("login"));
        Email.sendKeys("Ntlvc@ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest2()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("login"));
        Email.sendKeys("Ntlvc@@ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest3()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("login"));
        Email.sendKeys("Ntlvc@1ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest4()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("login"));
        Email.sendKeys("Ntlvc@ukrnet");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }


    //--------------Password test---------------

    @Test
    public void Vse10PasswordTestFormatTest()
    {
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        String Example = "qwertyuiop1234567890qwe";//Leng = 23
        int exp_len = 20;


        //Enter password
        password.sendKeys(Example);
        //Read password leng
        int Act_pass_len = password.getAttribute("value").length();
        String Assert_massage = "Textbox with name " + password.getAttribute("id") + " was tested. Expected: " + exp_len + ". Actual: " + Act_pass_len;

        Assert.assertEquals(Assert_massage,exp_len,Act_pass_len);


    }

    //--------------Usability test---------------
    @Test
    public void Vse10PasswordUsabilitytest()
    {
        List<WebElement> textboxes = driver.findElements(By.cssSelector("form input[type='password']"));
        textboxes.add(driver.findElement(By.cssSelector("form input[name='login']")));

        Dimension size = textboxes.get(0).getSize();

        int y=textboxes.get(0).getLocation().getY();


        for (WebElement textbox:textboxes
                ) {

            // is enabled
            String assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was disabled";
            Assert.assertTrue(assert_message,textbox.isEnabled());

            // is displayed
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was invisible";
            Assert.assertTrue(assert_message,textbox.isDisplayed());

            // is same size
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " have size: "+textbox.getSize().toString()+ "but should be "+size.toString();
            Assert.assertEquals(assert_message,size,textbox.getSize());


            // is horizontal alignment
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " have y coordinate: "+textbox.getLocation().getX()+ "but should be "+y;
            Assert.assertEquals(assert_message,y,textbox.getLocation().getY());

        }
    }


    //-------------Remember me-------------------
    @Test
    public void Vse10UsabilityTest()
    {
        WebElement RenMe = driver.findElement(By.id("rem"));

        // is enabled
        String assert_message ="Textbox with name "+ RenMe.getAttribute("name")+ " was disabled";
        Assert.assertTrue(assert_message,RenMe.isEnabled());

        // is displayed
        assert_message ="Textbox with name "+ RenMe.getAttribute("name")+ " was invisible";
        Assert.assertTrue(assert_message,RenMe.isDisplayed());

    }

    @Test
    public void Vse10RemMeTest()
    {
        //Find element
        WebElement RenMe = driver.findElement(By.id("rem"));
        //Select lelment
        RenMe.click();
        Assert.assertTrue("Remember me isn't Selected",RenMe.isSelected());
    }


    //------------Forgot password----------------
    @Test
    public void Vse10Usability()
    {
        WebElement ForPass = driver.findElement(By.cssSelector("a[href='javascript:void(0)'"));

        // is enabled
        String assert_message ="Textbox with name "+ ForPass.getAttribute("name")+ " was disabled";
        Assert.assertTrue(assert_message,ForPass.isEnabled());

        // is displayed
        assert_message ="Textbox with name "+ ForPass.getAttribute("name")+ " was invisible";
        Assert.assertTrue(assert_message,ForPass.isDisplayed());
    }

    @Test
    public void Vse10ForgotPasswordTest()
    {
        String exp_rem = "Daedmoroz123@gmail.com";
        driver.findElement(By.id("login")).sendKeys("Daedmoroz123@gmail.com");
        //Fild element "Забыли пароль?"
        WebElement link = driver.findElement(By.cssSelector("a[href='javascript:void(0)'"));
        //Click element "Забыли пароль?"
        link.click();
        String assert_massage = "Link with name " + link.getAttribute("id") + " was tested. Expected title : Все10 — Напоминание пароля < Логин. Actual: " + driver.getTitle() ;
        Assert.assertEquals(assert_massage,"Все10 — Напоминание пароля < Логин",driver.getTitle());
    }

    //--------------LogIn Test-------------------
    @Test
    public void RegTest()
    {
        //Enter data
        //Enter Email
        driver.findElement(By.id("login")).sendKeys("daedmoroz123@gmail.com");
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("174dcb");
        //click "Зарагистрироваться"
        WebElement button = driver.findElement(By.cssSelector("input[type='image']"));
        button.click();
        String assert_massage = "Link with name " + button.getAttribute("id") + " was tested. Expected title : Все10 — Моя страница. Actual: " + driver.getTitle() ;
        Assert.assertEquals(assert_massage,"Все10 — Моя страница",driver.getTitle());
    }

}
