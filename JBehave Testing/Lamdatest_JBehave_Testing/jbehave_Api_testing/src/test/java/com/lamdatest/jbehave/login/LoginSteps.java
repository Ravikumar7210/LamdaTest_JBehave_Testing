package com.lamdatest.jbehave.login;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import java.net.URI;
import java.net.http.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginSteps {

    private WebDriver driver;

    @BeforeStory
    public void setUp() {
        try {
            System.out.println("Connecting to LambdaTest...");

            String username = System.getenv("LT_USERNAME");
            String accessKey = System.getenv("LT_ACCESS_KEY");

            if (username == null || accessKey == null) {
                throw new RuntimeException("LambdaTest credentials not set in environment variables.");
            }

            String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

            Map<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("username", username);
            ltOptions.put("accessKey", accessKey);
            ltOptions.put("platformName", "Windows 11");
            ltOptions.put("browserVersion", "latest");
            ltOptions.put("build", "JBehave Login Test");
            ltOptions.put("name", "Login Scenario");
            ltOptions.put("project", "JBehave LambdaTest Demo");
            ltOptions.put("w3c", true);

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("LT:Options", ltOptions);

            driver = new RemoteWebDriver(new URI(hubURL).toURL(), capabilities);
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Exception during WebDriver initialization:");
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
            System.out.println("'My Account' not found in page source.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Title: " + driver.getTitle());
            throw new AssertionError("Dashboard not visible after login.");
        } else {
            System.out.println("Dashboard detected successfully.");
        }
    }

    @Then("the user profile API should return valid data")
    public void verifyUserProfileApi() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://ecommerce-playground.lambdatest.io/api/user/profile"))
            .header("Authorization", "Bearer " + getSessionToken()) // Optional: if API requires auth
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("API Response: " + response.body());
        System.out.println("Status Code: " + response.statusCode());

        if (response.statusCode() != 200) {
            throw new AssertionError("API response invalid or missing expected data.");
        } else {
            System.out.println("API response verified successfully.");
        }
    }

    public String getSessionToken() {
        Cookie sessionCookie = driver.manage().getCookieNamed("SESSION_ID");
        return sessionCookie != null ? sessionCookie.getValue() : "";
    }

    @AfterStory
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}