package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class App9 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String texto;
    private Alert alert;
    private JavascriptExecutor js;

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,10);

        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/shadowdom");

        //Esperar a que el botón esté disponible
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("guid-generator")));
        WebElement elementoPadre=driver.findElement(By.tagName("guid-generator"));
        JavascriptExecutor execute = (JavascriptExecutor)driver;
        SearchContext elementoShadowDom=(SearchContext) execute.executeScript("return arguments[0].shadowRoot",elementoPadre);
        WebElement boton=elementoShadowDom.findElement(By.id("buttonGenerate"));
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(boton)).click();
        Thread.sleep(4000);
        WebElement input=elementoShadowDom.findElement(By.id("editField"));
        String valueInput=input.getAttribute("value");
        System.out.println(valueInput);
    }

}