# JBehave Login Test with Selenium and LambdaTest 🌐

This project demonstrates Behavior-Driven Development (BDD) using **JBehave** and **Selenium WebDriver**, executed on the **LambdaTest cloud grid**. It automates a login scenario for a sample e-commerce site and generates HTML reports for test results.

---

## 🚀 Features

- ✅ BDD-style test flow using `.story` files
- ✅ Remote browser execution on LambdaTest
- ✅ HTML report generation via JBehave
- ✅ W3C-compliant capabilities for Selenium 4
- ✅ Beginner-friendly structure with reusable steps

---

## 🧰 Tech Stack

| Tool        | Purpose                          |
|-------------|----------------------------------|
| JBehave     | BDD framework                    |
| Selenium    | Web automation                   |
| LambdaTest  | Cloud-based browser execution    |
| Maven       | Build and dependency management  |
| Java        | Language used                    |

---

## 📂 Project Structure

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

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/jbehave-login-test.git
cd jbehave-login-test
```

### 2. Configure LambdaTest Credentials

You can either:
- Set environment variables:
  ```bash
  set LT_USERNAME=rk76912
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

