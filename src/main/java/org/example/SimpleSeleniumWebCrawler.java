package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.stream.IntStream;

public class SimpleSeleniumWebCrawler {
    public static void main(String[] args) {
        // Set the path to the Chrome WebDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Configure Chrome options (headless mode for running without a visible browser window)
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // without user interface

        // Create a new instance of the Chrome WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Start crawling from the initial URL
        getSales("https://www.newpanoutlet.co.il/sale", driver);

        // Close the WebDriver when done
        driver.quit();
    }


    public static int getSales(String url, WebDriver driver) {
        driver.get(url);
        List<WebElement> links = driver.findElements(By.className("product-title"));
        List<WebElement> prices = driver.findElements(By.className("prices"));

        IntStream.range(0, 10).forEach(i ->{
            if (links.get(i).getText() != null && !links.get(i).getText().isEmpty()){
                System.out.printf("\t %s %.2f", prices.get(i).getText().replace(" ₪", " ->"),
                        100.0 - 100*(Float.parseFloat(prices.get(i).getText().replace(",","").split(" ")[3])/
                                Float.parseFloat(prices.get(i).getText().replace(",","").split(" ")[1])));
                System.out.printf("\t\t %s%n", links.get(i).getText());
            }
        });
        System.out.println(links.size());
        return links.size();}
}
