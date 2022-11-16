package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTest {
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {
        //declare scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Browser");
        //store user input into userBrowser
        String userBrowser = scanner.next();
        try{
            //if statement
            if(userBrowser.equalsIgnoreCase("chrome")){
                //set property of key and value to webdriver and chromedriver link
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                //declare an object
                driver = new ChromeDriver();
            } else if (userBrowser.equalsIgnoreCase("edge")) {
                //set property of key and value to webdriver and edgedriver link
                System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
                //declare an object
                driver = new EdgeDriver();
            } else if (userBrowser.equalsIgnoreCase("firefox")) {
                //set property of key and value to webdriver and geckodriver link
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                //declare an object
                driver = new FirefoxDriver();
            } else{
                System.out.println("Invalid Browser");
            }
            //launch page
            driver.get(baseUrl);
            //maximize the window
            driver.manage().window().maximize();
            //implicit wait time definition
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
            passwordField.sendKeys("Testing1234");
            //Close the browser
            //driver.quit();
        }catch(Exception e){
            System.out.println("Invalid Browser");
            System.exit(0);
        }
    }
}
