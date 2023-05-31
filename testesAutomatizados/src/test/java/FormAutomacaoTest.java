import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormAutomacaoTest {
/*
    @Test
    public void testeTitulo(){
        //Configurar o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.br/");

        String title = driver.getTitle();
        String expected = "Google";

        assertEquals(expected, title);

        driver.quit();



    }*/

    @Test
    public void testTituloForm(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        String title = driver.getTitle();
        String expected = "Automação com Selenium";

        assertEquals(expected, title);

      //  driver.quit();





    }
    @Test
    public void testInput() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        String title = driver.getTitle();
        String expected = "Automação com Selenium";

        assertEquals(expected, title);

        driver.findElement(By.id("nome")).sendKeys("Erick");

        assertEquals("Erick", driver.findElement(By.id("nome")).getAttribute("value"));

        driver.quit();

    }

    @Test
    public void testCheckbox(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("masculino")).click();

        //isSelected() retorna um booleano
        assertTrue(driver.findElement(By.id("masculino")).isSelected());

        driver.quit();
    }




}