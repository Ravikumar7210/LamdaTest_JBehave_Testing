# 🧪 JBehave Login Test with API Validation (LambdaTest Cloud)

This demo project showcases a full-stack BDD testing flow using **JBehave**, **Selenium WebDriver**, and **Java HttpClient**, executed on the **LambdaTest cloud grid**.

It includes:
- ✅ UI automation for login page
- ✅ Dashboard verification
- ✅ REST API validation after login
- ✅ HTML report generation using JBehave templates

---

## 📁 Project Structure

```
jbehave-login-test/
├── pom.xml
├── README.md
├── src/
│   ├── test/
│   │   └── resources/
│   │       └── stories/
│   │           └── login.story
│   └── test/
│       └── java/
│           └── com/
│               └── lamdatest/
│                   └── jbehave/
│                       └── login/
│                           ├── LoginSteps.java
│                           ├── DriverManager.java
│                           ├── RunLoginStoryTest.java
│                           ├── LoginStoryRunner.java
│                           └── JbehaveLoginTestApplicationTests.java
```

---

## 🧪 Scenario: Valid Login and Profile Fetch
Scenario: Valid login and profile fetch
- Given the user is on the login page
- When the user enters valid credentials
- Then the user should see the dashboard
- Then the user profile API should return valid data


### 1. Clone the Repository
```bash
git clone https://github.com/your-username/jbehave-login-test.git
cd jbehave-login-test
```

### 2. Configure LambdaTest Credentials

You can either:
- Set environment variables:
  ```bash
  set LT_USERNAME=your_user_name
  set LT_ACCESS_KEY=your_access_key
  ```
- Or hardcode them inside `LoginSteps.java` (for quick testing only)

### 3. Install Dependencies
```bash
mvn clean install
```

---

### 4. Run the Test
```bash
mvn test
```

This will execute the JBehave story and generate both console output and an HTML report.

---

## 📊 View Test Report


After execution, open the following file in your browser:

```
target/jbehave/view/reports.html
```

This report shows:
- ✅ Which scenarios were executed
- ✅ Which steps passed or failed
- ✅ Any exceptions or errors encountered


---
🔧 Tech Stack
- Java 17+
- Maven
- JBehave 5.2.0
- Selenium 4.x
- LambdaTest cloud grid
- JUnit 5
- FreeMarker templates for reporting

---

## 🌐 LambdaTest Dashboard


If the test runs successfully, you can view the session details, logs, and screenshots on your LambdaTest dashboard:
```markdown
[LambdaTest Automation Dashboard](https://automation.lambdatest.com)
```

## 📌 Notes

```markdown

- This project uses W3C-compliant capabilities (`LT:Options`) for Selenium 4.
- If you face network issues, consider using [LambdaTest Tunnel](https://www.lambdatest.com/support/docs/real-time-testing-troubleshooting/).
- You can find your LambdaTest credentials on the [Username and Access Key page](https://accounts.lambdatest.com/security/username-accesskey).
```

