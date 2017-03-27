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
    public void Vse10UsernameFormatTest1()
    {
        String Expected_Name = "Technic";

        WebElement Username = driver.findElement(By.id("name"));
        Username.sendKeys("Technic");

        String assert_message = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: " + Expected_Name + ". Actual: " + Username.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Name, Username.getAttribute("value"));

    }
    @Test
    public void Vse10UsernameFormatTest2()
    {
        String Expected_Name = "Technic275";

        WebElement Username = driver.findElement(By.id("name"));
        Username.sendKeys("Technic275");

        String assert_message = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: " + Expected_Name + ". Actual: " + Username.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Name, Username.getAttribute("value"));

    }
    @Test
    public void Vse10UsernameFormatTest3()
    {
        String Expected_Name = "Technic";

        WebElement Username = driver.findElement(By.id("name"));
        Username.sendKeys("Technic@#$^&*^");

        String assert_message = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: " + Expected_Name + ". Actual: " + Username.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Name, Username.getAttribute("value"));

    }
    @Test
    public void Vse10UsernameFormatTest4()
    {
        String Expected_Name = "Technic275";

        WebElement Username = driver.findElement(By.id("name"));
        Username.sendKeys("Technic275%^$(#^@");

        String assert_message = "Textbox with name " + Username.getAttribute("id") + " was tested. Expected: " + Expected_Name + ". Actual: " + Username.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Name, Username.getAttribute("value"));

    }


    //---------------Email test-----------------
    @Test
    public void Vse10EmailFormatTest1()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("Ntlvc@ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest2()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("Ntlvc@@ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest3()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("Ntlvc@1ukr.net");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }
    @Test
    public void Vse10EmailFormatTest4()
    {
        String Expected_Email = "Ntlvc@ukr.net";

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("Ntlvc@ukrnet");

        String assert_message = "Textbox with name " + Email.getAttribute("id") + " was tested. Expected: " + Expected_Email + ". Actual: " + Email.getAttribute("value");

        Assert.assertEquals(assert_message, Expected_Email, Email.getAttribute("value"));

    }

    //-----------Usability Test Username and Email-----------
    @Test
    public void Vse10UsernameLengUsabilityTest()
    {
        int Exp_len = 29;
        String testname = "Technic11111111111111111111111111111234567898765434567898765fghjhfgdgdvfbgnuhm";

        WebElement Username = driver.findElement(By.id("name"));
        Username.sendKeys(testname);
        String Act_un = Username.getAttribute("value");
        int Act_un_len = Act_un.length();

        String assert_massage = "Textbox username " + Username.getAttribute("id") + " was tested. Expected: 29 " + ". Actual: " + Act_un_len;
        Assert.assertEquals(assert_massage,Exp_len,Act_un_len);
    }

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
        //check warning massage
        boolean check = driver.findElement(By.cssSelector("div[class='d1']")).isDisplayed();

        String Assert_massage = "Element with name" + driver.getTitle() + " was tested. Expected: True" + ". Actual: " + check;
        Assert.assertTrue(Assert_massage,check);

    }
}
