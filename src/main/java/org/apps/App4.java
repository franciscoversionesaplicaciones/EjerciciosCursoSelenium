/*Ejercicio Selenium Java para rellenar formulario.*/
package org.apps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App4 {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean estado=false;
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Eduardo");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Ruiz");
        Thread.sleep(2000);
        WebElement userEmail=driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("prueba@gmail.com");
        Thread.sleep(2000);
        WebElement gender=driver.findElement(By.xpath("//*[@for='gender-radio-1']"));/*No es posible localizarlo por el id porque
        salta una Exception que indica que el elemento clickable tiene que ser el label, y el label en este caso no tiene id*/
        gender.click();
        Thread.sleep(2000);
        WebElement mobile=driver.findElement(By.id("userNumber"));
        mobile.sendKeys("111111111");
        Thread.sleep(2000);
        WebElement birth=driver.findElement(By.id("dateOfBirthInput"));
        birth.click();
        Select month= new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("May");
        Select year= new Select (driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("1990");
        WebElement day=driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--020 react-datepicker__day--weekend']"));
        day.click();
        Thread.sleep(2000);
        WebElement finalPagina=driver.findElement(By.id("currentAddress"));
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

        /*By subjectsFocus = By.id("subjectsInput");
        WebElement searchElement = driver.findElement(subjectsFocus);
        Select dropdown = new Select(searchElement);
        dropdown.selectByValue("Maths");*/

        WebElement hobbies=driver.findElement(By.xpath("//*[@for='hobbies-checkbox-1']"));
        hobbies.click();
        Thread.sleep(2000);
        WebElement rutaFichero = driver.findElement(By.id("uploadPicture"));
        rutaFichero.sendKeys("c:\\Users\\ftabuenc\\Documents\\Documento de prueba 1.docx");
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Calle La Paz, nº 20, Una ciudad del mundo.");
        Thread.sleep(2000);
    }
}
