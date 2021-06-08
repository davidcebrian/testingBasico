package seleniumWebDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaTest {
  private WebDriver driver;
  
  //INSTANCIAMOS NUESTRO DRIVER ANTES DE CADA TEST
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver = new ChromeDriver();
  }
  
  
  //EJECUTAMOS UN TEST POR CLASE YA QUE 
  @Test
  public void busqueda() {
	//NOS DIRIGIMOS A LA PAGINA DE PCCOMPONENTES
    driver.get("https://www.pccomponentes.com/");
    //CLICK EN LA BARRA DE BUSQUEDA
    driver.findElement(By.id("ais-autocomplete-selectized")).click();
    //ENVIAMOS EL TEXTO NECESARIO
    driver.findElement(By.id("ais-autocomplete-selectized")).sendKeys("ordenador gaming");
    //PULSAMOS ENTER
    driver.findElement(By.id("ais-autocomplete-selectized")).sendKeys(Keys.ENTER);
    
    //AÑADIMOS UNA ESPERA HASTA QUE EL ELEMENTO ESTE PRESENTE
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".Wrapper-sc-8udqwp:nth-child(1) .sc-dHMioH")));
    
    //COMPROBAMOS QUE EL TEXTO DE ESE ELEMENTO COINCIDA CON LOS DATOS NECESARIOS.
    assertEquals(driver.findElement(By.cssSelector(".Wrapper-sc-8udqwp:nth-child(1) .sc-dHMioH")).getText(), "Asus ROG Zephyrus S17 GX701LXS-HG032T Intel Core i7-10875H/32GB/1TB SSD/RTX 2080/17.3\" Reacondicionado");
  }
  
  //DESPUES DE CADA TEST CERRAMOS NUESTRO DRIVER
  @After
  public void tearDown() {
	  driver.quit();
  }
}
