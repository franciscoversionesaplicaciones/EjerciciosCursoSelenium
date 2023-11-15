/*Ejercicio Selenium Java para rellenar formulario.*/
package org.apps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App11 {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean estado=false;
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName=driver.findElement(By.xpath("//label[text()='Name']/following::input[@placeholder='First Name']"));
        firstName.sendKeys("Eduardo");
        WebElement lastName=driver.findElement(By.xpath("//label[text()='Name']/following::input[@placeholder='Last Name']"));
        lastName.sendKeys("Ruiz");
        Thread.sleep(2000);
        WebElement userEmail=driver.findElement(By.xpath("//label[text()='Email']/following::input[@placeholder='name@example.com']"));
        userEmail.sendKeys("prueba@gmail.com");
        Thread.sleep(2000);
        WebElement gender=driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        gender.click();
        Thread.sleep(2000);
        WebElement mobile=driver.findElement(By.xpath("//label[text()='Mobile']/following::input[@placeholder='Mobile Number']"));
        mobile.sendKeys("111111111");
        Thread.sleep(2000);
        WebElement birth=driver.findElement(By.xpath("//label[text()='Date of Birth']/following::input[@value='26 Oct 2023']"));
        birth.click();
        Select month= new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("May");
        Select year= new Select (driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("1990");
        WebElement day=driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--020 react-datepicker__day--weekend']"));
        day.click();
        Thread.sleep(2000);
        WebElement finalPagina=driver.findElement(By.xpath("//*[@id='currentAddress']"));
        Actions scrollVertical = new Actions(driver);
        scrollVertical.scrollToElement(finalPagina).perform();
        Thread.sleep(2000);
        /*WebElement subjectsFocus=driver.findElement(By.xpath("//*[@class='subjects-auto-complete__control css-yk16xz-control']"));
        subjectsFocus.click();
        Thread.sleep(2000);
        WebElement subjectsAutoComplete=driver.findElement(By.xpath("//*[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        subjectsAutoComplete.sendKeys("Arts");
        Thread.sleep(2000);
        WebElement subjectsPlaceholder=driver.findElement(By.xpath("//*[@class='subjects-auto-complete__control subjects-auto-complete__control--is-focused subjects-auto-complete__control--menu-is-open css-1pahdxg-control']"));
        subjectsPlaceholder.click();
        Thread.sleep(2000);*/
        WebElement hobbies=driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        hobbies.click();
        Thread.sleep(2000);
        WebElement rutaFichero = driver.findElement(By.xpath("//label[text()='Picture']/following::input[@type='file']"));
        rutaFichero.sendKeys("c:\\Users\\ftabuenc\\Documents\\Documento de prueba 1.docx");
        WebElement currentAddress=driver.findElement(By.xpath("//label[text()='Current Address']/following::textarea[@placeholder='Current Address']"));//No es posible localizarlo por su label, ya que su label no tiene atributo for
        currentAddress.sendKeys("Calle La Paz, nº 20, Una ciudad del mundo.");
        Thread.sleep(2000);
    }
}
