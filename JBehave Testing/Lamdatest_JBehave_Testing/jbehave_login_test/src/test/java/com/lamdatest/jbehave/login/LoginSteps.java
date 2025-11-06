package com.lamdatest.jbehave.login;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSteps {

    private WebDriver driver;

    @SuppressWarnings("deprecation")
	@BeforeStory
    public void setUp() {
        try {
            System.out.println("🔗 Connecting to LambdaTest...");

            String username = System.getenv("LT_USERNAME");
            String accessKey = System.getenv("LT_ACCESS_KEY");

            if (username == null || accessKey == null) {
                throw new RuntimeException("❌ LambdaTest credentials not set in environment variables.");
            }

            String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

            Map<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("username", username);
            ltOptions.put("accessKey", accessKey);
            ltOptions.put("platformName", "Windows 11");
            ltOptions.put("browserVersion", "latest");
            ltOptions.put("project", "JBehave LambdaTest Demo");
            ltOptions.put("build", "JBehave Login Test");
            ltOptions.put("name", "Login Scenario");

            ChromeOptions options = new ChromeOptions();
            options.setCapability("LT:Options", ltOptions);

            driver = new RemoteWebDriver(new URL(hubURL), options);
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("❌ Exception during WebDriver initialization:");
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    @Given("the user is on the login page")
    public void openLoginPage() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    }

    @When("the user enters valid credentials")
    public void enterCredentials() {
        driver.findElement(By.id("input-email")).sendKeys("ravi12345@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Ravil@1234");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Then("the user should see the dashboard")
    public void verifyDashboard() {
    	String pageSource = driver.getPageSource();
        if (!pageSource.contains("My Account")) {
            System.out.println("❌ 'My Account' not found in page source.");
            System.out.println("🔍 Current URL: " + driver.getCurrentUrl());
            System.out.println("📝 Page Title: " + driver.getTitle());
            throw new AssertionError("Dashboard not visible after login.");
        } else {
            System.out.println("✅ Dashboard detected successfully.");
        }
    }

    @AfterStory
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}