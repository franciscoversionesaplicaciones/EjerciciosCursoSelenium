package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
public class App2 {
    private WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.estadiodeportivo.com");
        By eBotAceptCookies=By.xpath("//*[@id='acceptAllMain']");
        WebElement oBotAceptCookies=driver.findElement(eBotAceptCookies);
        oBotAceptCookies.click();

        By eEscudoBetis=By.xpath("//*[@src='https://www.estadiodeportivo.com/img/equipos/futbol/escudo/real-betis-balompie.png']");
        WebElement oEscudoBetis=driver.findElement(eEscudoBetis);
        oEscudoBetis.click();

        ArrayList<WebElement>listaNoticias=new ArrayList<>();
        listaNoticias=(ArrayList<WebElement>) driver.findElements(By.xpath("//*[@class='titular titulo-1' or @class='titular titulo-5'] |" +
                " //*[@class='card pila-v m-foto-completa']//*[@class='titular titulo-3']"));
        for (WebElement webElement:listaNoticias)
            System.out.println("- "+webElement.getText());
    }
}
