import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class asta7 {

    WebDriver driver;
    String email;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    //sprawdzam czy ilość w koszyku zgadza się po dodaniu 2 rzeczy
    public void TwoItemsInCart()  {
        driver.navigate().to("https://buggy-testingcup.pgs-soft.com/task_1");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/input")).sendKeys("2");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/span")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")).sendKeys("3");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/span")).click();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/span")).getText().equals("2"));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]/span")).getText().equals("3"));
        if(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/span")).getText().equals("2")
                &&driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]/span")).getText().equals("3"))
                {
                    System.out.println("Produkty zliczone poprawnie");
                }
        else
            System.out.println("Produkty zliczone nieppoprawnie");
        driver.quit();
    }
    //sprawdzam czy ilość w koszyku zgadza się po dodaniu 3 rzeczy (fail)
@Test
public void ThreeItemsInCart()  {
    driver.navigate().to("https://buggy-testingcup.pgs-soft.com/task_1");
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/input")).clear();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/input")).sendKeys("2");
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div/span")).click();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")).clear();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")).sendKeys("3");
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/span")).click();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[3]/div[2]/div/div/div/input")).clear();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[3]/div[2]/div/div/div/input")).sendKeys("4");
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[3]/div[2]/div/div/div/span")).click();


    if(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/span")).getText().equals("2")
            &&driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]/span")).getText().equals("3")
    &&driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[1]/span")).getText().equals("4"))
    {
        System.out.println("Produkty zliczone poprawnie");
    }
    else
        System.out.println("Produkty zliczone nieppoprawnie");

    driver.quit();

}}
