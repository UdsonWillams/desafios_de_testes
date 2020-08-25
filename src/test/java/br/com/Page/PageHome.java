package br.com.Page;
import br.com.desafioDeTeste.Teste.screenShot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//Construtor do Driver
public class PageHome{
    screenShot print = new screenShot();

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    public PageHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

//Teste googleRecursividade
    @FindBy(name="q")
    private WebElement pesquisaGoogle;
    public void pesquisaRecursividade() throws Exception {
        driver.manage().window().maximize();
        pesquisaGoogle.sendKeys("recursividade" + Keys.ENTER);
        Assert.assertEquals("recursividade", driver.findElement(By.xpath("//*[@id=\"taw\"]/div[2]/div/p/a/b/i")).getText());
        print.takeSnapShot(driver, "d:\\testeRecursividade.png");
        driver.quit();
    }

// Teste de login automatico no guru
    @FindBy(name="email")
    private WebElement emailGuru;
    @FindBy(name="passwd")
    private WebElement senhaGuru;
    @FindBy(id="SubmitLogin")
    private WebElement clickLoginGuru;
    public void logarGuruAuto() throws Exception {
        driver.manage().window().maximize();
        emailGuru.sendKeys("udsonwillams@gmail.com");
        senhaGuru.sendKeys("123987");
        clickLoginGuru.click();
        Assert.assertEquals("Successfully Logged in...", driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText());
        print.takeSnapShot(driver, "d:\\testeLoginConfirmacao.png");
        driver.quit();
    }
//Teste Drag and Drop
    @FindBy(xpath="//*[@id=\"credit2\"]/a")
    private WebElement sourceBank;
    @FindBy(id="bank")
    private WebElement targetBank;

    @FindBy(xpath="//*[@id=\"fourth\"]/a")
    private WebElement source5000Esq;
    @FindBy(id="amt7")
    private WebElement target5000Esq;

    @FindBy(xpath="//*[@id=\"credit1\"]/a")
    private WebElement sourceSales;
    @FindBy(id=("loan"))
    private WebElement targetSales;

    @FindBy(xpath="//*[@id=\"fourth\"]/a")
    private WebElement source5000Dir;
    @FindBy(id="amt8")
    private WebElement target5000Dir;
    public void dragDrop() throws Exception {
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.dragAndDrop(sourceBank, targetBank).build().perform();
        action.dragAndDrop(source5000Esq, target5000Esq).build().perform();
        action.dragAndDrop(sourceSales, targetSales).build().perform();
        action.dragAndDrop(source5000Dir, target5000Dir).build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        Assert.assertEquals("Perfect!", driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText());
        print.takeSnapShot(driver, "d:\\testeDragDrop.png");
        driver.quit();
    }
// Teste de Registro no Guru
    @FindBy(name="firstName")
    private WebElement nome;

    @FindBy(name="lastName")
    private WebElement sobrenome;

    @FindBy(name="phone")
    private WebElement telefone;

    @FindBy(name="userName")
    private WebElement emailRegistroGuru;

    @FindBy(name="address1")
    private WebElement endereco;

    @FindBy(name="city")
    private WebElement cidade;

    @FindBy(name="state")
    private WebElement estado;

    @FindBy(name="postalCode")
    private WebElement cep;

    @FindBy(id="email")
    private WebElement NomeUsuario;

    @FindBy(name="password")
    private WebElement senha;

    @FindBy(name="confirmPassword")
    private WebElement confirmaSenha;

    @FindBy(name="submit")
    private WebElement submitGuru;

    @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a")
    private WebElement sign;

    @FindBy(name="userName")
    private WebElement NomeUsuario2;

    @FindBy(name="password")
    private WebElement senha2;

    @FindBy(name="submit")
    private WebElement submitGuru2;

    public void registoNoGuru() throws Exception {
        driver.manage().window().maximize();
        nome.sendKeys("Udson Willams");
        sobrenome.sendKeys("Rêgo de Lima");
        telefone.sendKeys("999999999");
        emailRegistroGuru.sendKeys("udsonwillams@gmail.com");
        endereco.sendKeys("julieta gadelha");
        cidade.sendKeys("Santa Rita");
        estado.sendKeys("PB");
        cep.sendKeys("1594826");
        // Selecionando um valor num elemento select
        Select selecione = new Select(driver.findElement(By.name("country")));
        selecione.selectByValue("BRAZIL");
        String nomeUsuario = "udsonwillams";
        NomeUsuario.sendKeys(nomeUsuario);
        String senhaRegistroGuru = "udson123";
        senha.sendKeys(senhaRegistroGuru);
        confirmaSenha.sendKeys(senhaRegistroGuru);
        submit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Thank you for registering. You may now sign-in using the user name and password you've just entered.", driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText());
        print.takeSnapShot(driver, "d:\\TesteRegistro.png");
        sign.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        NomeUsuario2.sendKeys(nomeUsuario);
        senha2.sendKeys(senhaRegistroGuru);
        submitGuru2.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Login Successfully", driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText());
        print.takeSnapShot(driver, "d:\\TesteRegistroLoginSucesso.png");
        driver.quit();
    }

// Teste deleteCustomerId
    @FindBy(name="cusid")
    private WebElement customerId;
    @FindBy(name="submit")
    private WebElement submit;
    public void acessarCustomerId() {
        customerId.sendKeys("123");
        submit.click();
        Assert.assertEquals("Do you really want to delete this Customer?",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Assert.assertEquals("Customer Successfully Delete!",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
