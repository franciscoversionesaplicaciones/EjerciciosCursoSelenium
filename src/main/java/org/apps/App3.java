package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
public class App3 {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,20);

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

        By eUnaNotic=By.xpath("(//*[@class='titular titulo-3']/a)[last()]");
        WebElement oUnaNotic=driver.findElement(eUnaNotic);
        oUnaNotic.click();

        By ePrimNoticSlider=By.xpath("//*[@class='r-col12 rm-col4 pila-v fondo-gris lo-ultimo']//h2/a");
        WebElement oPrimNoticSlider=driver.findElement(ePrimNoticSlider);
        System.out.println("Primera noticia slider: "+oPrimNoticSlider.getText());

        Actions scrollVertical = new Actions(driver);
        scrollVertical.scrollToElement(oPrimNoticSlider).perform();

        By eBotonSiguiente=By.xpath("//*[@class='swiper-button-next1 boton redondo']");
        WebElement oBotonSiguiente=driver.findElement(eBotonSiguiente);
        Actions act = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(oBotonSiguiente));
        act.doubleClick(oBotonSiguiente).perform();
        act.doubleClick(oBotonSiguiente).perform();
        act.doubleClick(oBotonSiguiente).perform();

        By eUltimNoticSlider=By.xpath("(//*[@class='r-col12 rm-col4 pila-v fondo-gris lo-ultimo']//h2/a)[last()]");
        WebElement oUltimNoticSlider=driver.findElement(eUltimNoticSlider);
        System.out.println("Última noticia slider: "+oUltimNoticSlider.getText());

        wait.until(ExpectedConditions.elementToBeClickable(oBotonSiguiente));
        oUltimNoticSlider.click();
    }
}
