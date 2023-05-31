import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTesteSistemaTest {

    @Test
    public void nomeUsuarioNaoInformado(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("username"));
        assertEquals("", driver.findElement(By.id("username")).getAttribute("value"));
        driver.quit();


    }

    @Test
    public void senhaNaoInformado(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("password"));
        assertEquals("", driver.findElement(By.id("password")).getAttribute("value"));

    }

    @Test
    public void senhaeNomeNaoInformado(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        String mensagem = String.valueOf(driver.findElement(By.id("message")));

        driver.findElement(By.id("loginButton")).click();
        assertTrue(driver.findElement(By.id("message")).getText().contains("Nome de usuário ou senha incorretos."));
        driver.quit();

    }

    @Test
    public void nomeIncorretoSenhaCorreta(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("username")).sendKeys("errado");
        driver.findElement(By.id("password")).sendKeys("password");


        assertEquals("password", driver.findElement(By.id("password")).getAttribute("value"));
        assertNotEquals("admin", driver.findElement(By.id("username")).getAttribute("value"));

        driver.findElement(By.id("loginButton")).click();
        assertTrue(driver.findElement(By.id("message")).getText().contains("Nome de usuário ou senha incorretos."));
        driver.quit();

    }

    @Test
    public void nomeCorretoSenhaIncorreta(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("errado");


        assertEquals("admin", driver.findElement(By.id("username")).getAttribute("value"));
        assertNotEquals("password", driver.findElement(By.id("password")).getAttribute("value"));

        driver.findElement(By.id("loginButton")).click();
        assertTrue(driver.findElement(By.id("message")).getText().contains("Nome de usuário ou senha incorretos."));
        driver.quit();

    }

    @Test
    public void ambosIncorreto(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("username")).sendKeys("errado");
        driver.findElement(By.id("password")).sendKeys("errado");


        assertNotEquals("admin", driver.findElement(By.id("username")).getAttribute("value"));
        assertNotEquals("password", driver.findElement(By.id("password")).getAttribute("value"));

        driver.findElement(By.id("loginButton")).click();
        assertTrue(driver.findElement(By.id("message")).getText().contains("Nome de usuário ou senha incorretos."));
        driver.quit();

    }

    @Test
    public void ambosCorreto(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");


        assertEquals("admin", driver.findElement(By.id("username")).getAttribute("value"));
        assertEquals("password", driver.findElement(By.id("password")).getAttribute("value"));

        driver.findElement(By.id("loginButton")).click();
        assertTrue(driver.findElement(By.id("message")).getText().contains("Login realizado com sucesso!"));
        driver.quit();

    }



}