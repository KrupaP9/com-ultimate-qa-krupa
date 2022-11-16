package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    public static void main(String[] args) {
        //define URL to test
        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
        //set properties of key Webdriver and value chromedriver
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //declare an object
        WebDriver driver = new ChromeDriver();
        //launch URL
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //set implicit time to wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("Title: "+driver.getTitle());
        //Print the current url
        System.out.println("URL: "+driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page Source: "+driver.getPageSource());
        //locate the email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        //Enter the email to email field
        emailField.sendKeys("Test123@gmail.com");
        //locate the password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        //Enter the password to password field
        passwordField.sendKeys("Test123");
        //quit the browser
        driver.quit();
    }
}
