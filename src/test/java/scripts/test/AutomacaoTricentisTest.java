package scripts.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

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

import driverConfig.AutomacaoTricentis;

class AutomacaoTricentisTest {
	static AutomacaoTricentis driverConfig;
	static WebDriver driver;
	static WebElement element;

	@BeforeAll // Notação do Junit -> executada antes de todos os testes
	public static void init() {
		driverConfig = new AutomacaoTricentis();
		driver = driverConfig.getWebDriver();
	}

	@Test
	@DisplayName("TC000 - Abrir Website")
	void test01() {
		String esperado = "Tricentis Vehicle Insurance";
		String atual;

		driver.get("http://sampleapp.tricentis.com/101/index.php");

		atual = driver.getTitle();

		assertEquals(esperado, atual, "Não foi possível Carregar a pagina!");
	}

	@Test
	@DisplayName("TC001 - Cadastro de Camper")
	void test02() {
		String esperado = "Sending e-mail success!";
		String atual;

		element = driver.findElement(By.id("nav_camper"));
		element.click();

		element = driver.findElement(By.id("make"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"make\"]/option[3]"));
		element.click();

		element = driver.findElement(By.id("engineperformance"));
		element.sendKeys("100");

		element = driver.findElement(By.id("dateofmanufacture"));
		element.sendKeys("05/15/2018");

		element = driver.findElement(By.id("numberofseats"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"numberofseats\"]/option[2]"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[5]/p/label[1]/span"));
		element.click();

		element = driver.findElement(By.id("fuel"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"fuel\"]/option[3]"));
		element.click();

		element = driver.findElement(By.id("payload"));
		element.sendKeys("350");

		element = driver.findElement(By.id("totalweight"));
		element.sendKeys("1200");

		element = driver.findElement(By.id("listprice"));
		element.sendKeys("20000");

		element = driver.findElement(By.id("licenseplatenumber"));
		element.sendKeys("1236544");

		element = driver.findElement(By.id("annualmileage"));
		element.sendKeys("5200");

		element = driver.findElement(By.id("nextenterinsurantdata"));
		element.click();

		element = driver.findElement(By.id("firstname"));
		element.sendKeys("fernando");

		element = driver.findElement(By.id("lastname"));
		element.sendKeys("antonio");

		element = driver.findElement(By.id("birthdate"));
		element.sendKeys("04/18/1990");

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span"));
		element.click();

		element = driver.findElement(By.id("streetaddress"));
		element.sendKeys("av. onde judas perdeu as botas");

		element = driver.findElement(By.id("country"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"country\"]/option[32]"));
		element.click();

		element = driver.findElement(By.id("zipcode"));
		element.sendKeys("54400123");

		element = driver.findElement(By.id("city"));
		element.sendKeys("Hellcife");

		element = driver.findElement(By.id("occupation"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"occupation\"]/option[2]"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span"));
		element.click();

		element = driver.findElement(By.id("website"));
		element.sendKeys("www.JunitTestesAutomatizados.com");

		element = driver.findElement(By.id("nextenterproductdata"));
		element.click();

		element = driver.findElement(By.id("startdate"));
		element.sendKeys("10/15/2021");

		element = driver.findElement(By.id("insurancesum"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"insurancesum\"]/option[3]"));
		element.click();

		element = driver.findElement(By.id("damageinsurance"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"damageinsurance\"]/option[4]"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span"));
		element.click();

		element = driver.findElement(By.id("nextselectpriceoption"));
		element.click();

		element = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span"));
		element.click();

		element = driver.findElement(By.id("sendquote"));
		element.click();

		element = driver.findElement(By.id("email"));
		element.sendKeys("fernando@gmail.com");

		element = driver.findElement(By.id("phone"));
		element.sendKeys("5581991112365");

		element = driver.findElement(By.id("username"));
		element.sendKeys("fernando90");

		element = driver.findElement(By.id("password"));
		element.sendKeys("As123456");

		element = driver.findElement(By.id("confirmpassword"));
		element.sendKeys("As123456");

		element = driver.findElement(By.id("Comments"));
		element.sendKeys("Gostaria de receber contato por telefone para saber melhor sobre as ofertas");

		element = driver.findElement(By.id("sendemail"));
		element.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // espera 10 segundos para que o elemento
																			// oculto h2 possa aparecer e ser capturado
		element = driver.findElement(By.xpath("/html/body/div[4]/h2"));
		atual = element.getText();

		assertEquals(esperado, atual, "Não foi possível cadastrar");

	}

	@AfterAll
	public static void killWebDriver() {
		driverConfig.killAndCloseWebDriver();
	}

}
