package aula.com.br;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomacaoTricentis {
	private WebDriver driver;
	static final String PATH_WEBDRIVER = "./src/main/resources/chromedriver.exe";

	public WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", PATH_WEBDRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void killAndCloseWebDriver() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
	}
}
