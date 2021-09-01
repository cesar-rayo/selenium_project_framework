package com.selenium.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import utilities.ConfigFileReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.selenium")
public class DriverConfig {

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriver(){
        WebDriver driver = null;
        ConfigFileReader configFileReader = new ConfigFileReader();
        String browser = configFileReader.getBrowser();
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                //WebDriverManager.chromedriver().setup();
                //ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("['start-maximized']");
                //driver = new ChromeDriver(chromeOptions);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
                    driver.manage().window().maximize();
                } catch (MalformedURLException e) {
                    System.out.println("Invalid URL");
                }
                break;
            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                //driver = new FirefoxDriver();
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
                    driver.manage().window().maximize();
                } catch (MalformedURLException e) {
                    System.out.println("Invalid URL");
                }
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
        return driver;
    }

    @Bean
    @Scope("cucumber-glue")
    public WebDriverWait waitFor(){
        return  new WebDriverWait(webDriver(), Duration.ofSeconds(10));
    }

}
