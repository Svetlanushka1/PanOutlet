package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Objects;


public class CSS {

    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// weight element?//polling-interrupt
        //for Mac :driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login(driver);
        candymapper(driver);


        driver.close();
        driver.quit();
    }

    public static void login(WebDriver driver){

        driver.get("https://the-internet.herokuapp.com/login");
        driver.getTitle();
        WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
        username.clear();
        username.sendKeys("tomsmith");

        WebElement passwd = driver.findElement(By.xpath("//*[@id='password']"));
        passwd.clear();
        passwd.sendKeys("SuperSecretPassword!");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='login']/button/i"));
        submitButton.click();

    }

    public static void candymapper(WebDriver driver){

        driver.get("https://candymapper.com/");
        driver.getTitle();

        WebElement closePopup = driver.findElement(By.xpath("//*[@id='popup-widget135214']/div/div/div[1]"));
        closePopup.click();

        WebElement p1 = driver.findElement(By.xpath("//*[@id='n-135118']/div/section/div[4]/div/div[3]/p"));
        if (Objects.equals(p1.getText(), "+44 20 7946 0BOO")) {
            System.out.println("Pass");
        }else {
            System.out.println("fail");
            System.out.println(p1.getText());
        }

        WebElement p2 = driver.findElement(By.xpath("//*[@id='9c941769-5b62-4b9c-9076-2292b4e66576']/div/section/div/div/div[1]/p[3]"));
        if (Objects.equals(p2.getText(), "+44 20 7946 0BO0")){
            System.out.println("Pass");
        }else {
            System.out.println("fail");
            System.out.println(p2.getText());
        }

        WebElement c = driver.findElement(By.cssSelector("#\\39 c941769-5b62-4b9c-9076-2292b4e66576 > div > section > div > div > div.x-el.x-el-div.c1-1.c1-2.c1-1q.c1-1r.c1-1s.c1-1t.c1-1u.c1-6z.c1-b.c1-c.c1-db.c1-1v.c1-d.c1-1w.c1-e.c1-1x.c1-f.c1-1y.c1-g > div > ul > li:nth-child(4) > a"));
        System.out.println(c.getText());

        WebElement i = driver.findElement(By.id("freemium-ad-135120"));
        WebElement i1 = driver.findElement(By.cssSelector("div#freemium-ad-135120"));

        System.out.println(i.getText());




    }


}
