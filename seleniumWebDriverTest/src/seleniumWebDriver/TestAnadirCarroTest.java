package seleniumWebDriver;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAnadirCarroTest {
  private WebDriver driver;
 
  //INSTANCIAMOS NUESTRO DRIVER ANTES DE CADA TEST
  @Before
  public void setUp() {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver = new ChromeDriver();
  
  }
  
  @Test
  public void testAnadirCarro() {
	//ENTRAMOS EN LA PAGINA
    driver.get("https://www.pccomponentes.com/");
    WebDriverWait wait = new WebDriverWait(driver, 30);
    
    //AÑADIMOS LA ESPERA HASTA QUE EL PRODUCTO SEA VISIBLE Y CLICKABLE Y LO CLICKAMOS
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"producto-interesa\"]/a")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"producto-interesa\"]/a")));
    driver.findElement(By.xpath("//*[@id=\"producto-interesa\"]/a")).click();
    
    //ESPERAMOS QUE EL BOTON DE ACEPTAR COOKIES SEA CLICKABLE Y LO ACEPTAMOS
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ficha-producto\"]/div[6]/div/div/div[2]/button")));
    driver.findElement(By.xpath("//*[@id=\"ficha-producto\"]/div[6]/div/div/div[2]/button")).click();
    
    //HACEMOS CLICK EN AÑADIR AL CARRO
    wait.until(ExpectedConditions.elementToBeClickable(By.id("add-cart")));
    driver.findElement(By.id("add-cart")).click();
    
    //COMPROBAMOS QUE HAY UN OBJETO EN NUESTRO CARRO DE LA COMPRA(YA QUE SE NOS ABRE SOLO AL CLICKAR EN AÑADIR AL CARRITO)
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".enlace-superpuesto")));
    List<WebElement> elements = driver.findElements(By.cssSelector(".enlace-superpuesto"));
    assert(elements.size() > 0);
  }
  
  @After
  public void tearDown() {
	  driver.quit();
  }
}
