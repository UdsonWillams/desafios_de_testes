package br.com.desafioDeTeste.Teste;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenShot {
    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//Converte o objeto web driver para tirar um print
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
//chamao metodo getScreenshotAs para criar uma imagem
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move o arquivo de imagem para o novo destino
        File DestFile = new File(fileWithPath);
//Copia o arquivo no novo destino
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
