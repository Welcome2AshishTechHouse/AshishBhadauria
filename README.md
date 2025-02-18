# 🌟 Bright Horizon Automation Framework

🚀 An expandable BDD automation framework using Selenium WebDriver and Java for automating the Bright Horizon web application.

## 📌 Key Features
- ✅ Automates feature: Bright Horizon functionality
- ✅ Uses BDD Cucumber for structured test cases
- ✅ Includes Page Object Model (POM) for maintainability
- ✅ Generates detailed reports using Extent Reporting
- ✅ Supports test execution with tags via Test Runner
- ✅ Manages WebDriver efficiently using utility classes
- ✅ Stores common configurations in config.properties
- ✅ Built using Maven with all dependencies in pom.xml

## 📌 Test Cases Covered

|Test Case Number | Test Case                       | Description                                         |
|-----------------|---------------------------------|-----------------------------------------------------|
| Test Case 01    | 🔍 Verify Search Functionality  | Validates that the search feature works correctly.  |
| Test Case 02    | 🏫 Search for Child Care Center | Ensures users can find child care centers efficiently. |

## 🔧 Technologies Used
- Java – Programming language
- Selenium WebDriver – Browser automation
- Cucumber (BDD) – Behavior-driven development
- Maven – Dependency and build management
- Extent Reports – Test result visualization
- Gherkin – Test case definition

## 📂 Project Structure

```plaintext
📦 bright-horizon-automation
 ┣ 📂 src/main/java
 ┃ ┣ 📂 configUtil
 ┃ ┃ ┣ 📜 ScreenshotUtil.java  # Capture screenshots
 ┃ ┃ ┗ 📜 WebDriverUtil.java  # WebDriver manager
 ┃ ┣ 📂 projectManager
 ┃ ┃ ┣ 📜 PropertyManager.java  # Manages config properties
 ┃ ┃ ┗ 📜 ScenarioManager.java  # Handles scenario-level execution
 ┃ ┣ 📂 webPages
 ┃ ┃ ┣ 📜 HomePage.java  # Home page actions
 ┃ ┃ ┗ 📜 SearchPage.java  # Search page actions
 ┣ 📂 src/main/resources
 ┃ ┣ 📜 logger.xml  # Logger configuration
 ┣ 📂 src/test/java
 ┃ ┣ 📂 runner
 ┃ ┃ ┗ 📜 TestRunner.java  # Executes tests using Cucumber options
 ┣ 📂 src/test/main
 ┃ ┣ 📂 stepDefinitions
 ┃ ┃ ┣ 📜 BrightHorizonSteps.java  # Step definitions
 ┃ ┃ ┗ 📜 Hooks.java  # Setup & teardown methods
 ┣ 📂 src/test/resources
 ┃ ┣ 📂 featureFiles
 ┃ ┃ ┗ 📜 brightHorizon.feature  # Gherkin scenarios
 ┃ ┣ 📜 config.properties  # Stores static configurations (e.g., URLs)
 ┃ ┣ 📜 extent.properties  # Extent Report configurations
 ┣ 📜 pom.xml  # Maven dependencies
 ┣ 📜 README.md  # Documentation
 ┣ 📜 test-automation-results  # Extent Report

```


## 🚀 How to Run the Tests

1. **Clone the repository**
    ```bash
    git clone https://github.com/Welcome2AshishTechHouse/AshishBhadauria.git
    git clone .git
    cd BrightHorizonsAutomation
    ```

2. **Install dependencies**
    ```bash
    mvn clean install
    ```

3. **Run tests using Maven**
    ```bash
    mvn test
    ```

    or using tags
    ```bash
    mvn test -Dcucumber.options="--tags @Test_BrightHorizons"
    ```

## 📊 Test Reports
- After execution, test reports will be generated under: AutomationExecutionReport




- Open the report in a browser to view detailed results with screenshots.

## 📸 Sample Extent Report Screenshot

## 🔧 Configuration

Modify the `config.properties` file to update browser settings and URLs:
```properties
baseURL=https://www.brighthorizon.com
```

💡 Why Choose This Framework?
- ✔ Easy to Use – Plug & play BDD framework




- ✔ Scalable – Follows Page Object Model for easy expansion




- ✔ Detailed Reports – Beautiful HTML reports with screenshot
  




- ✔ Reusable Utilities – WebDriver & Screenshot utilities for efficient execution

