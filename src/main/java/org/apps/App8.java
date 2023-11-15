package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class App8 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String texto;
    private Alert alert;

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");

        /*IMPORTANTÍSIMO: Hay que esperar a que el iframe padre esté disponible y cambiar al contexto del iframe padre, antes de intentar
        localizar el iframe hijo*/
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));

        //Esperar a que el iframe hijo este disponible y cambiar al contexto del iframe hijo
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        //Esperar a que el elemento esté visible dentro del iframe
        WebElement parraf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Child Iframe']")));
        //Realizar acciones en el elemento
        System.out.println(parraf.getText());
        //Cambiar al contexto predeterminado fuera del iframe
        driver.switchTo().defaultContent();

        //Esperar a que el iframe padre este disponible y cambiar al contexto del iframe padre
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        //Esperar a que el elemento esté visible dentro del iframe padre
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[text()='Parent frame']")));
        //Realizar acciones en el elemento
        System.out.println(text.getText());
        //Cambiar al contexto predeterminado fuera del iframe
        driver.switchTo().defaultContent();

    }
}