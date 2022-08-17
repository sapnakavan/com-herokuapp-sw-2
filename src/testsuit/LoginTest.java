package testsuit;

import browserfactory.BestTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest extends BestTest {
    String baseUrl ="http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
       // * Enter “tomsmith” username
       // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");


        //   * Enter “SuperSecretPassword!” password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");


        //* Click on ‘LOGIN’ button
        // driver.findElement(By.xpath("//input[@id='username']")).click();
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();


        //* Verify the text “Secure Area”
     WebElement verify = driver.findElement(By.xpath("//div[@class='example']"));
     String accmess =verify.getText();

     String expmess ="Secure Area\n" +
             "Welcome to the Secure Area. When you are done click logout below.\n" +
             "Logout";

        Assert.assertEquals(expmess,accmess);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //* Enter “tomsmith1” username
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith1");


        // * Enter “SuperSecretPassword!” password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");


        //* Click on ‘LOGIN’ button
        // driver.findElement(By.xpath("//input[@id='username']")).click();
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();


        // * Verify the error message “Your username is invalid!”
        WebElement verify = driver.findElement(By.xpath("//div[@id='flash']"));
        String accmess =verify.getText();

        String expmess ="Your username is invalid!\n" +
                "×";

        Assert.assertEquals(expmess,accmess);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
      //  * Enter “tomsmith” username
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");


        //* Enter “SuperSecretPassword” password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword");



        //* Click on ‘LOGIN’ button
        // driver.findElement(By.xpath("//input[@id='username']")).click();
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();



        //* Verify the error message “Your password is invalid!”
        WebElement verify = driver.findElement(By.xpath("//div[@class='flash error']"));
        String accmess =verify.getText();

        String expmess ="Your password is invalid!\n" +
                "×";

        Assert.assertEquals(expmess,accmess);

    }


}