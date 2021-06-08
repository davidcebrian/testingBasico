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

public class LogTestTest {
  private WebDriver driver;

  //INSTANCIAMOS NUESTRO DRIVER ANTES DE CADA TEST
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver = new ChromeDriver();
  }
  
  
  @Test
  public void logTest() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
    driver.get("https://www.pccomponentes.com/");
    
    //AÑADIMOS LA ESPERA HASTA QUE EL PRODUCTO SEA VISIBLE Y CLICKABLE Y LO CLICKAMOS
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"producto-interesa\"]/a")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"producto-interesa\"]/a")));
    driver.findElement(By.xpath("//*[@id=\"producto-interesa\"]/a")).click();
    
    //ESPERAMOS QUE EL BOTON DE ACEPTAR COOKIES SEA CLICKABLE Y LO ACEPTAMOS
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ficha-producto\"]/div[6]/div/div/div[2]/button")));
    driver.findElement(By.xpath("//*[@id=\"ficha-producto\"]/div[6]/div/div/div[2]/button")).click();
 
    //ESPERAMOS QUE EL BOTON PARA CERRAR LA PESTAÑA EMERGENTE Y LA CERRAMOS
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ficha-producto\"]/div[20]/div/div/div/div/a")));
    driver.findElement(By.xpath("//*[@id=\"ficha-producto\"]/div[20]/div/div/div/div/a")).click();
    
    //ESPERAMOS QUE EL BOTON DE USUARIO SEA CLICKABLE Y LO CLICKAMOS
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"c-main-header\"]/div[3]/ul/li[2]/a")));
    driver.findElement(By.xpath("//*[@id=\"c-main-header\"]/div[3]/ul/li[2]/a")).click();
    
    //ENVIAMOS LOS DATOS AL FORMULARIO DE LOGIN 
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("pruebastest124@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("pruebastest");
    
    //CLICKAMOS EL BOTON DE INICIAR SESION
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-form\"]/button[2]")));
   driver.findElement(By.xpath("//*[@id=\"login-form\"]/button[2]")).click();
      
   //COMPROBAMOS QUE ESTAMOS LOGEADOS MEDIANTE LA COMPROBACION DE LA EXISTENCIA DE LA LETRA DEL USUARIO.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".user-panel-letter")));
    List<WebElement> elements = driver.findElements(By.cssSelector(".user-panel-letter"));
      assert(elements.size() > 0);
    
  }
  
  @After
  public void tearDown() {
	  driver.quit();
  }
}
