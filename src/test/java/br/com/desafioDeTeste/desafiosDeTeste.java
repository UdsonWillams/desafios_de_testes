package br.com.desafioDeTeste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class desafiosDeTeste{
    WebDriver driver = new ChromeDriver();
    screenShot print = new screenShot();
    @Test
    public void googleRecursividade() throws Exception {
        driver.manage().window().maximize();
        try {
            driver.navigate().to("https://www.google.com.br/");
            driver.findElement(By.name("q")).sendKeys("recursividade" + Keys.ENTER);
            Assert.assertEquals("recursividade", driver.findElement(By.xpath("//*[@id=\"taw\"]/div[2]/div/p/a/b/i")).getText());
            print.takeSnapShot(driver, "d:\\testeRecursividade.png");
        } finally {
            driver.quit();

        }
    }
    @Test
    public void loginAuto() throws Exception {
        driver.manage().window().maximize();
        try {
            driver.navigate().to("http://demo.guru99.com/test/login.html");
            driver.findElement(By.name("email")).sendKeys("udsonwillams@gmail.com");
            driver.findElement(By.name("passwd")).sendKeys("123987");
            //print.takeSnapShot(driver, "d:\\testeLogin.png") ;
            driver.findElement(By.id("SubmitLogin")).click();
            Assert.assertEquals("Successfully Logged in...", driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText());
            print.takeSnapShot(driver, "d:\\testeLoginConfirmacao.png");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void dragDrop() throws Exception {
        driver.manage().window().maximize();
        try {
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
        Actions action = new Actions(driver);
        //Move o botão Bank
        WebElement sourceBank = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement targetBank = driver.findElement(By.id("bank"));
        action.dragAndDrop(sourceBank, targetBank).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        //Move o botão 5000 1° / do lado esquerdo
        WebElement sourceLeftQuin = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement targetLeftQuin = driver.findElement(By.id("amt7"));
        action.dragAndDrop(sourceLeftQuin, targetLeftQuin).build().perform();
        //Move o botão Sales
        WebElement sourceSales = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
        WebElement targetSales = driver.findElement(By.id("loan"));
        action.dragAndDrop(sourceSales, targetSales).build().perform();
        //Move o botão 5000 2° / lado direito
        WebElement sourceRightQuin = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement targetRightQuin = driver.findElement(By.id("amt8"));
        action.dragAndDrop(sourceRightQuin, targetRightQuin).build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        Assert.assertEquals("Perfect!", driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText());
        print.takeSnapShot(driver, "d:\\testeDragDrop.png");
        }
        finally {
            driver.quit();
        }
    }
}