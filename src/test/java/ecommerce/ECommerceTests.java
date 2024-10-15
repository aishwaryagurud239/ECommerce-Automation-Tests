package ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class ECommerceTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add implicit wait
        driver.get("https://www.amazon.com/"); // Amazon site
    }

    @Test(priority = 1)
    public void searchForProductAndAddToCart() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Assuming there is an 'Add to cart' button for the first product
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[1]//h2/a"));
        firstProduct.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Validate the cart count increased
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertTrue(Integer.parseInt(cartCount.getText()) > 0, "Product was not added to the cart");
    }

    @Test(priority = 2)
    public void proceedToCheckout() {
        WebElement cart = driver.findElement(By.id("nav-cart"));
        cart.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.name("proceedToRetailCheckout"));
        proceedToCheckoutButton.click();

        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Checkout page was not displayed");
    }

    @Test(priority = 3)
    public void loginWithValidCredentials() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("agurud@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("rascal@123");
        driver.findElement(By.id("signInSubmit")).click();

        Assert.assertTrue(driver.findElement(By.id("nav-link-accountList")).getText().contains("Account"), "Login failed with valid credentials");
    }

    @Test(priority = 4)
    public void loginWithInvalidCredentials() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("invalid-email@example.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("invalidpassword");
        driver.findElement(By.id("signInSubmit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Your password is incorrect')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid credentials");
    }

    @Test(priority = 5)
    public void verifyUIElements() {
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement navigationMenu = driver.findElement(By.id("nav-main"));
        WebElement footer = driver.findElement(By.id("navFooter"));

        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");
        Assert.assertTrue(navigationMenu.isDisplayed(), "Navigation menu is not displayed");
        Assert.assertTrue(footer.isDisplayed(), "Footer is not displayed");
    }

    @Test(priority = 6)
    public void formValidation() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("createAccountSubmit")).click();

        WebElement nameField = driver.findElement(By.id("ap_customer_name"));
        WebElement emailField = driver.findElement(By.id("ap_email"));
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        WebElement submitButton = driver.findElement(By.id("continue"));

        nameField.clear(); // Leave name empty to trigger validation
        emailField.sendKeys("invalid-email"); // Invalid email format
        passwordField.sendKeys("123"); // Weak password
        submitButton.click();

        WebElement emailError = driver.findElement(By.xpath("//div[contains(text(),'Enter a valid email')]"));
        WebElement passwordError = driver.findElement(By.xpath("//div[contains(text(),'minimum of 6 characters')]"));

        Assert.assertTrue(emailError.isDisplayed(), "Email validation failed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password validation failed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
