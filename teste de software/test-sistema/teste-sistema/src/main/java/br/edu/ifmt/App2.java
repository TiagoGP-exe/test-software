package br.edu.ifmt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App2 {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chorme.driver", "C:\\Users\\Aluno\\Documents\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com.br");
        WebElement caixaPesquisa =driver.findElement(By.name("q"));
        caixaPesquisa.clear();
        caixaPesquisa.sendKeys("Selenium Java");
        WebElement botaoPesquisar = driver.findElement(By.name("btnK"));
        botaoPesquisar.submit();
    }
}
