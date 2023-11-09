package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Headless {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--window-size=2560,1440");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login(driver);
        driver.quit();
    }

    private static void login(WebDriver driver) {
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

}
