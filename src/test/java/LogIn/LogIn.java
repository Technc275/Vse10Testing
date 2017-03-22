package LogIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.ArrayList;

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
    public void Vse10LoginFormatTest()
    {
        ArrayList<String> Emails = new ArrayList<String>();
        ArrayList<String> Expected_Emails = new ArrayList<String>();
        WebElement Email = driver.findElement(By.id("login"));

        //1st case
        Emails.add("Ntlvc@ukr.net");
        Expected_Emails.add("Ntlvc@ukr.net");

        //2nd case
        Emails.add("Ntlvc@@ukr.net");
        Expected_Emails.add("Ntlvc@ukr.net");

        //3rd case
        Emails.add("Ntlvc@1ukr.net");
        Expected_Emails.add("Ntlvc@ukr.net");

        //4th case
        Emails.add("Ntlvc@ukrnet");
        Expected_Emails.add("Ntlvc@ukr.net");;

        for (int i=0;i<Emails.size();i++)
        {
            String Mail = Emails.get(i);
            String Expected_Mail = Expected_Emails.get(i);

            //Enter email
            Email.sendKeys(Mail);
            //Read email
            String Act_e = Email.getAttribute("value");

            Email.clear();

            String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Mail + ". Actual: " + Act_e;

            Assert.assertEquals(assert_message, Expected_Mail, Act_e);

        }
    }
}
