package aula.com.br;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class AutomacaoTricentisTest {
	static AutomacaoTricentis driverConfig;
	static WebDriver driver;
	static WebElement element;
	
	@BeforeAll //Notação do Junit -> executada antes de todos os testes
	public static void init() {
		driverConfig = new AutomacaoTricentis();
		driver = driverConfig.getWebDriver();
	}
	

	@Test
	@DisplayName("TC000 - Abrir Website")
	void testA() {
		String esperado = "Tricentis Vehicle Insurance";
		String atual;
		
		driver.get("http://sampleapp.tricentis.com/101/index.php"); //trocar para: http://sampleapp.tricentis.com/101/app.php
		atual = driver.getTitle();
		
		assertEquals(esperado, atual, "Não foi possível Carregar a pagina!");
	}
	
	/*@Test
	@DisplayName("TC002 - Login")
	void testB() {
		File scrFile;
		String esperado = "Hello Admin User";
		String atual;
		
		element = driver.findElement(By.id("LoginLink"));
		element.click();
		
		element = driver.findElement(By.name("uid"));
		element.sendKeys("admin");
		
		element = driver.findElement(By.name("passw"));
		element.sendKeys("admin");
		
		element = driver.findElement(By.name("btnSubmit"));
		element.click();
		
		element = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		atual = element.getText();
		
		assertEquals(esperado, atual, "Erro ao fazer login!");
	}*/
	
	@AfterAll
	public static void killWebDriver() {
		driverConfig.killAndCloseWebDriver();
	}

}
