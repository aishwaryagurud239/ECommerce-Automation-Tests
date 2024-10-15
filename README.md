Project Structure
bash
Copy code
├── pom.xml                     # Maven dependencies
├── src/
│   └── test/
│       ├── java/
│       │   └── ecommerce/
│       │       └── ECommerceTests.java  # Main test file
│   └── resources/
│       └── testng.xml           # TestNG configuration file
└── README.md
Test Cases
The ECommerceTests.java file includes the following automated test scenarios:

Search and Add to Cart: Search for a product ("laptop"), select the first result, and add it to the cart.
Proceed to Checkout: Proceed to the checkout process after adding an item to the cart.
Login with Valid Credentials: Login to Amazon with valid credentials.
Login with Invalid Credentials: Attempt to login with invalid credentials and verify the error message.
UI Verification: Verify the presence of key UI elements such as the search bar, navigation menu, and footer on the homepage.
Form Validation: Test invalid input data for account creation and validate the error messages.
Pre-requisites
Before you can run the tests, ensure you have the following installed:

Java JDK 8 or higher: Download here
Maven: Download here
Chrome Browser: Latest version of Google Chrome for running the tests.
ChromeDriver: ChromeDriver must be compatible with your Chrome version. It is automatically managed via the WebDriverManager.
Setup Instructions
1. Clone the Repository
First, clone this repository to your local machine:

bash
Copy code
git clone https://github.com/your-username/amazon-ecommerce-automation.git
cd amazon-ecommerce-automation
2. Install Dependencies
Ensure that Maven is installed and set up on your system. Then, run the following command to install all the necessary dependencies:

bash
Copy code
mvn clean install
This will download and configure Selenium, TestNG, and WebDriverManager for browser automation.

3. Update Credentials
In the ECommerceTests.java file, update the following placeholders with valid Amazon credentials to run login tests:

java
Copy code
driver.findElement(By.id("ap_email")).sendKeys("your-valid-email@example.com");
driver.findElement(By.id("ap_password")).sendKeys("your-valid-password");
Running the Tests
To run the test suite, use the following Maven command:

bash
Copy code
mvn test
This command will run the tests defined in the ECommerceTests.java file.

Test Reporting
After running the tests, TestNG generates a report located in the target/surefire-reports directory. To view the report:

Navigate to target/surefire-reports.
Open index.html in your browser.
This report will provide detailed test results.

Contributing
If you would like to contribute to this project, follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes.
Commit your changes (git commit -am 'Add feature').
Push the branch (git push origin feature-branch).
Open a Pull Request.
This README file is structured to provide a clear guide on setting up, running, and contributing to the project. You can now add it to your repository. 
