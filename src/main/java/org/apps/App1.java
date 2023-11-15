package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class App1 {
    private WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.estadiodeportivo.com");
    }
}
