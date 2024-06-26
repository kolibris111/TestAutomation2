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
        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click(); //Slapuku patvirtinimas
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement acceptAge = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")); //Amziaus patvirtinimas
        acceptAge.click();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement resultText = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div[1]")); //Naujienlaiskio langas
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
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/button")).click();//Paspausti "Paieška"
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
        _globalDriver.findElement(By.id("phone")).click();
        _globalDriver.findElement(By.id("phone")).sendKeys("63586485");
        _globalDriver.findElement(By.id("password")).click();
        _globalDriver.findElement(By.id("password")).sendKeys("FiktyviAnketa123");
        _globalDriver.findElement(By.id("password_repeat")).click();
        _globalDriver.findElement(By.id("password_repeat")).sendKeys("FiktyviAnketa123");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click();
        _globalDriver.close();
    }
    @Test
    public void Test2(){
        //Prekės įsidėjimas į krepšelį, visų duomenų pristatymui suvedimas. //
        // Vėliau -> peržiūrėti krepšelį, įsitikinti, kad jame yra būtent ta prekė, už būtent tą kainą, kurią pridėjome.//

        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();//Patvirtiname slapukus//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement acceptAge = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));//Patvirtiname amziu//
        acceptAge.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div[2]/div/form/div[1]/div/input")).sendKeys("pukismiau123@inbox.lt");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div[2]/div/form/div[2]/div/input")).sendKeys("FiktyviAnketa123");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div[2]/div/form/div[4]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Tikrinama, ar veikia paieska ir randama suvesta preke//

        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/button/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div/nav/div[3]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[3]/div/div/div[1]/a/img")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Idedame i krepseli//
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/button")).click(); //Ideti i krepseli//
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div")).click(); //Pristatymas i namus//
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[1]/div[1]/button/span")).click(); //Toliau pristatymo adresas//
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/div[1]/div/div/input")).sendKeys("Upės g.1, Vilnius"); //Suvedamas adresas//
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/div[2]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/div[2]/button")).click(); //Ieskoti//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div[1]/button")).click(); //Pasirinkti is duotu adresu//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/button")).click(); //Pasirinkti adresa//
        try {
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Naujienlaiskio langas
        _globalDriver.findElement(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-close-action")).click(); //Uzdaryti naujienlaiski
        try {
            TimeUnit.SECONDS.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/button")).click(); //Uzdaryti reklama
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div/button")).click(); //Issaugoti pristatymo adresa//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //_globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div/button")).click(); //Issaugoti pristatymo adresa//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/div/div[2]/div[5]/div[9]/label/span[2]/span")).click(); //Pasirinkti pristatymo laika//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/button")).click(); //Rezervuoti laika//
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[3]/div[1]/button")).click(); //Perziureti krepseli//
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Tikriname pavadinima ir kaina

        String priceActual = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div[2]/strong")).getText();
        String priceInChart = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div[2]/div/div/div/div[3]/div/div[2]/div/div[5]/div[2]")).getText();
        Assert.assertEquals(priceActual, priceInChart);

        String nameInPage = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[1]/h3")).getText();
        String nameInCahrt = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]")).getText();
        Assert.assertEquals(nameInPage, nameInCahrt);

       _globalDriver.close();

    }






}
