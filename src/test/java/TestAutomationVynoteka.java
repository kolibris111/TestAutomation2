import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationVynoteka {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.get("https://vynoteka.lt/");
        _globalDriver.manage().window().maximize();
    }
    @Test
    public void Test1(){
        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement acceptAge = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        acceptAge.click();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement resultText = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div[1]"));
        Assert.assertEquals(resultText.getText(),"UŽSISAKYKITE AKCIJŲ LEIDINUKĄ");

        //Tikriname, ar atsiranda reklaminis langas, atsisakius ir uzdarius prenumeratos langa//
        _globalDriver.findElement(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-close-action")).click();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement advertisementText = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/a/img[1]"));

        WebElement closeAdvertisement = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/button"));
        closeAdvertisement.click();

        //Tikrinama, ar veikia paieska ir randama suvesta preke//
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input")).sendKeys("Šampanas");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Sukurti nauja vartotojo paskyra//
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div[1]/div/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.findElement(By.id("firstname")).click();
        _globalDriver.findElement(By.id("firstname")).sendKeys("Pūkis");
        _globalDriver.findElement(By.id("lastname")).click();
        _globalDriver.findElement(By.id("lastname")).sendKeys("Miau");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[16]/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[10]/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[29]/span")).click();
        _globalDriver.findElement(By.id("email")).click();
        _globalDriver.findElement(By.id("email")).sendKeys("pukismiau123@inbox.lt");
        _globalDriver.close();
    }




}
