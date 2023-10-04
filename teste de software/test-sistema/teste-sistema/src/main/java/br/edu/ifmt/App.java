package br.edu.ifmt;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("Webdriver.chorme.driver", "C:\\Users\\Aluno\\Documents\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com.br");    
        driver.manage().window().maximize();
        System.out.println("Titulo: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.quit();
    }
}
