package Keyboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import java.io.File;

/**
 * Created by TechBook on 22.03.2017.
 */
public class KeyboardTesting
{
    public WebDriver driver;

    @Before
    public void OpenVse10()
    {
        File exe = new File("D:\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary FireFox = new FirefoxBinary(exe);
        FirefoxProfile FireFox_profile = new FirefoxProfile();
        driver = new FirefoxDriver(FireFox,FireFox_profile);
        driver.get("http://vse10.ru/");

    }

    @After
    public void CloseVse10()
    {
        driver.quit();
    }

    //-------------KeyBoard trainer------------
    @Test
    public void Vse10Keyboard()
    {

        //Go to test page
        driver.findElement(By.cssSelector("button[class='submitNew']")).click();
        //Enter word
        WebElement Str_in = driver.findElement(By.id("keyboard"));

        if (Str_in.isDisplayed())
        {
            if (Str_in.isEnabled())
            {
                Str_in.sendKeys("тестовая");
            }
        }

        String exp_res = "текстовая";
        String Act_res = driver.findElement(By.cssSelector("div[id='str_out']")).getText();

        Assert.assertEquals(exp_res,Act_res);

    }

}
