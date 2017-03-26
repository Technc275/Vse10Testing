package RegistrationForm;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import javax.naming.Name;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TechBook on 22.03.2017.
 */
public class NewUserRegistration
{
    public WebDriver driver;

    @Before
    public void OpenVse10()
    {
        File exe = new File("D:\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary FireFox = new FirefoxBinary(exe);
        FirefoxProfile FireFox_profile = new FirefoxProfile();
        driver = new FirefoxDriver(FireFox,FireFox_profile);
        driver.get("http://vse10.ru/register/");
    }

    @After
    public void CloseVse10()
    {
        driver.quit();
    }

    //---------------Username test--------------
    @Test
    public void Vse10UsernameFormatTest()
    {
        ArrayList<String> Names = new ArrayList<String>();
        ArrayList<String> Expected_Names = new ArrayList<String>();
        WebElement Username = driver.findElement(By.id("name"));

        //1st case
        Names.add("Technic");
        Expected_Names.add("Technic");

        //2nd case
        Names.add("Technic275");
        Expected_Names.add("Technic275");

        //3rd case
        Names.add("Technic@#$%^&");
        Expected_Names.add("Technic");

        //4th case
        Names.add("Technic275$%^&");
        Expected_Names.add("Technic275");

        //5th case
        Names.add("Technic11111111111111111111111111111234567898765434567898765fghjhfgdgdvfbgnuhm");

        for (int i=0;i<Names.size();i++)
        {
            String Name = Names.get(i);

            //Enter username
            Username.sendKeys(Name);
            //Read username
            String Act_un = Username.getAttribute("value");
            if (Act_un.length() < 29)
            {

                Username.clear();

                String assert_message = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: " + Expected_Names.get(i) + ". Actual: " + Act_un;

                Assert.assertEquals(assert_message, Expected_Names.get(i), Act_un);
            }
            else
            {
                int Act_un_len = Act_un.length();
                String assert_massage = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: 29 " + ". Actual: " + Act_un_len;

                Assert.assertEquals(assert_massage,29,Act_un_len);
            }

        }

    }

    //---------------Email test-----------------

    @Test
    public void Vse10EmailFormatTest()
    {
        ArrayList<String> Emails = new ArrayList<String>();
        ArrayList<String> Expected_Emails = new ArrayList<String>();
        WebElement Email = driver.findElement(By.id("email"));


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

    //-----------Usability Test Username and Email-----------

    @Test
    public void Vse10UsernameEmailUsability()
    {
        List<WebElement> textboxes = driver.findElements(By.cssSelector("form input[type='text']"));

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
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " have y coordinate: "+textbox.getLocation().getY()+ "but should be "+y;
            Assert.assertEquals(assert_message,y,textbox.getLocation().getY());

        }
    }

    //-----------Password Test--------------
    @Test
    public void Vse10PasswordTestFormatTest()
    {
        List<WebElement> Passwords_box = driver.findElements(By.cssSelector("input[type='password']"));
        String Example = "qwertyuiop1234567890qwe";//Leng = 23
        int exp_len = 20;

        for (WebElement password:Passwords_box)
        {
            //Enter password
            password.sendKeys(Example);
            //Read password leng
            int Act_pass_len = password.getAttribute("value").length();
            String Assert_massage = "Textbox with name " + password.getAttribute("id") + " was tested. Expected: " + exp_len + ". Actual: " + Act_pass_len;

            Assert.assertEquals(Assert_massage,exp_len,Act_pass_len);
        }

    }

    //----------Password usability test
    @Test
    public void Vse10PasswordUsabilitytest()
    {
        List<WebElement> textboxes = driver.findElements(By.cssSelector("form input[type='password']"));

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
    //---------------Registration test------------------
    @Test
    public void RegTest()
    {
        //Enter data
        driver.findElement(By.id("name")).sendKeys("Technic275");
        driver.findElement(By.id("email")).sendKeys("Ntlvc@ukr.net");//Not correct Email
        driver.findElement(By.id("password1")).sendKeys("1234567");
        driver.findElement(By.id("password2")).sendKeys("1234567");
        //click "Зарагистрироваться"
        driver.findElement(By.cssSelector("input[type='image']")).click();

        boolean check = driver.findElement(By.id("stat_form")).isDisplayed();

        String Assert_massage = "Element with name" + driver.findElement(By.id("stat_form")).getAttribute("name") + " was tested. Expected: True" + ". Actual: " + check;
        Assert.assertTrue(Assert_massage,check);

    }
}
