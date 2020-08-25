package br.com.desafioDeTeste.Teste;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class logarSiteAuto {

    screenShot print = new screenShot();

    @Test
    public void loginAuto() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("http://demo.guru99.com/test/login.html");
        driver.findElement(By.name("email")).sendKeys("udsonwillams@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("123987");
        print.takeSnapShot(driver, "d:\\testeLogin.png") ;
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertEquals("Successfully Logged in...", driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText());
        print.takeSnapShot(driver, "d:\\testeLoginConfirmacao.png") ;
        driver.quit();
    }
}   