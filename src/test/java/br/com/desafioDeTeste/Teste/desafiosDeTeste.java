package br.com.desafioDeTeste.Teste;

import br.com.Page.PageHome;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class desafiosDeTeste{
    WebDriver driver = new ChromeDriver();
    screenShot print = new screenShot();
    PageHome home = new PageHome(driver);

    @Test
    public void googleRecursividade() throws Exception {
        String url = "https://www.google.com.br/";
        driver.navigate().to(url);
        home.pesquisaRecursividade();
    }
    @Test
    public void loginAuto() throws Exception {
        String url = ("http://demo.guru99.com/test/login.html");
        driver.navigate().to(url);
        home.logarGuruAuto();
    }
    @Test
    public void dragDrop() throws Exception {
        String url = "http://demo.guru99.com/test/drag_drop.html";
        driver.navigate().to(url);
        home.dragDrop();
    }
    @Test
    public void desafioRegistro() throws Exception {
        String url = "http://demo.guru99.com/test/newtours/register.php";
        driver.navigate().to(url);
        home.registoNoGuru();
    }
    @Test
    public void deleteCustomerId(){
        driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
        home.acessarCustomerId();
    }
}
