package org.apps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class App7 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String texto;
    private Alert alert;

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,10);

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        By eBoton1=By.xpath("//button[@id='alertButton']");
        WebElement oBoton1 = driver.findElement(eBoton1);
        oBoton1.click();
        Thread.sleep(4000);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        texto = alert.getText();
        alert.accept();
        Thread.sleep(4000);

        By eBoton2=By.xpath("//button[@id='timerAlertButton']");
        WebElement oBoton2 = driver.findElement(eBoton2);
        oBoton2.click();
        Thread.sleep(7000);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        texto = alert.getText();
        alert.accept();
        Thread.sleep(4000);

        By eBoton3=By.xpath("//button[@id='confirmButton']");
        WebElement oBoton3 = driver.findElement(eBoton3);
        oBoton3.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        texto = alert.getText();
        alert.accept();
        Thread.sleep(4000);

        By eBoton4=By.xpath("//button[@id='promtButton']");
        WebElement oBoton4 = driver.findElement(eBoton4);
        oBoton4.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Fran");
        Thread.sleep(4000);
        alert.accept();
    }
}