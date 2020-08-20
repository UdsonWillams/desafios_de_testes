package br.com.desafioDeTeste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class desafiosDeTeste{
    WebDriver driver = new ChromeDriver();
    screenShot print = new screenShot();
    @Test
    public void googleRecursividade() throws Exception {
        String url = "https://www.google.com.br/";
        driver.manage().window().maximize();
        try {
            driver.navigate().to(url);
            driver.findElement(By.name("q")).sendKeys("recursividade" + Keys.ENTER);
            Assert.assertEquals("recursividade", driver.findElement(By.xpath("//*[@id=\"taw\"]/div[2]/div/p/a/b/i")).getText());
            print.takeSnapShot(driver, "d:\\testeRecursividade.png");
        } finally {
            driver.quit();
        }
    }
    @Test
    public void loginAuto() throws Exception {
        String url = ("http://demo.guru99.com/test/login.html");
        driver.manage().window().maximize();
        try {
            driver.navigate().to(url);
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
        String url = "http://demo.guru99.com/test/drag_drop.html";
        driver.manage().window().maximize();
        try {
            driver.navigate().to(url);
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
    @Test
    public void desafioRegistro() throws Exception {
        String url = "http://demo.guru99.com/test/newtours/register.php";
        driver.manage().window().maximize();
        try{
            driver.navigate().to(url);
            driver.findElement(By.name("firstName")).sendKeys("Udson Willams");
            driver.findElement(By.name("lastName")).sendKeys("Rêgo de Lima");
            driver.findElement(By.name("phone")).sendKeys("hu3hu3br");
            driver.findElement(By.name("userName")).sendKeys("udsonwillams@gmail.com");
            driver.findElement(By.name("address1")).sendKeys("julieta gadelha");
            driver.findElement(By.name("city")).sendKeys("Santa Rita");
            driver.findElement(By.name("state")).sendKeys("PB");
            driver.findElement(By.name("postalCode")).sendKeys("1594826");
            // Selecionando um valor num elemento select
            Select selecione = new Select(driver.findElement(By.name("country")));
            selecione.selectByValue("BRAZIL");
            //
            String userName = "udsonwillams";
            driver.findElement(By.id("email")).sendKeys(userName);
            String passWord = "udson123";
            driver.findElement(By.name("password")).sendKeys(passWord);
            driver.findElement(By.name("confirmPassword")).sendKeys(passWord);
            driver.findElement(By.name("submit")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertEquals("Thank you for registering. You may now sign-in using the user name and password you've just entered.", driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText());
            print.takeSnapShot(driver, "d:\\TesteRegistro.png");
            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.name("userName")).sendKeys(userName);
            driver.findElement(By.name("password")).sendKeys(passWord);
            driver.findElement(By.name("submit")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertEquals("Login Successfully", driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText());
            print.takeSnapShot(driver, "d:\\TesteRegistroLoginSucesso.png");
        }
        finally{
            driver.quit();
        }
    }
    @Test
    public void deleteCustomerId() throws Exception {
        String url = "http://demo.guru99.com/test/delete_customer.php";
        try {
            driver.navigate().to(url);
            driver.findElement(By.name("cusid")).sendKeys("123");
            driver.findElement(By.name("submit")).click();
            Alert alert = driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
        }
        finally {
            driver.quit();
        }
    }
}