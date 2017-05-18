

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testcase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("u_0_1")).clear();
    driver.findElement(By.id("u_0_1")).sendKeys("ass");
    driver.findElement(By.id("u_0_3")).clear();
    driver.findElement(By.id("u_0_3")).sendKeys("aaads");
    driver.findElement(By.id("u_0_6")).clear();
    driver.findElement(By.id("u_0_6")).sendKeys("2311C");
    driver.findElement(By.id("u_0_d")).clear();
    driver.findElement(By.id("u_0_d")).sendKeys("cs");
    new Select(driver.findElement(By.id("month"))).selectByVisibleText("Feb");
    new Select(driver.findElement(By.id("day"))).selectByVisibleText("2");
    new Select(driver.findElement(By.id("year"))).selectByVisibleText("2016");
    driver.findElement(By.id("u_0_g")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
