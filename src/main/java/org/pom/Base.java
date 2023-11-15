package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;
    //Constructor
    public Base(WebDriver driver){
        this.driver=driver;
    }
    /*Método para llamar al ChromeDriver, que es el ejecutable que nos permite crear una instancia del navegador
    Chrome y desde aquí vamos a llamar a la página que queremos automatizar y a realizar todas las acciones
    del caso de prueba sobre esa página*/
    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        return driver;
    }
    //WRAPPING DE LA MAYORÍA DE LOS MÉTODOS DE SELENIUM QUE NECESITEMOS
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    //Método para devolver el texto del elemento que paso como parámetro
    public String getText(WebElement element){
        return element.getText();
    }
    /*Sobrecarga del método para que reciba un objeto Locator.
    Devuelve el texto del elemento que buscamos a través de ese localizador*/
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    /*Método para escribir texto. El primer parámetro es el texto que queremos escribir en la página y el segundo
    parámetro se encarga de localizar el elemento donde queremos escribir ese texto*/
    public void type(String inputText,By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    //Método para hacer click en un elemento
    public void click(By locator){
        driver.findElement(locator).click();
    }
    //Método para saber si el elemento se encuentra listo para ser utilizado
    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            //Si el elemento no se encuentra disponible porque no ha cargado, no existe o se ha modificado
            return false;
        }
    }
    /*Método encargado de recibir la URL y de abrir la pçagina*/
    public void visit(String url){
        driver.get(url);
    }
}
