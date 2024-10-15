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

public class ECommerceTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.inmotionhosting.com/"); // Update with the actual e-commerce site URL
    }

    @Test(priority = 1)
    public void searchForProductAndAddToCart() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("web hosting");
        driver.findElement(By.id("search-button")).click();

        // Assuming there's an "Add to cart" button on the product page
        WebElement firstProduct = driver.findElement(By.xpath("(//button[@class='add-to-cart'])[1]"));
        firstProduct.click();

        WebElement cartCount = driver.findElement(By.id("cart-count"));
        Assert.assertEquals(cartCount.getText(), "1", "Product was not added to the cart");
    }

    @Test(priority = 2)
    public void proceedToCheckout() {
        WebElement cart = driver.findElement(By.id("cart"));
        cart.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout-button"));
        checkoutButton.click();

        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Checkout page was not displayed");
    }

    @Test(priority = 3)
    public void loginWithValidCredentials() {
        driver.findElement(By.id("login-link")).click();
        driver.findElement(By.id("email")).sendKeys("valid-email@example.com");
        driver.findElement(By.id("password")).sendKeys("validpassword");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.findElement(By.id("logout-link")).isDisplayed(), "Login failed with valid credentials");
    }

    @Test(priority = 4)
    public void loginWithInvalidCredentials() {
        driver.findElement(By.id("login-link")).click();
        driver.findElement(By.id("email")).sendKeys("invalid-email@example.com");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.id("error-message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid credentials");
    }

    @Test(priority = 5)
    public void verifyUIElements() {
        WebElement searchBar = driver.findElement(By.name("q"));
        WebElement navigationMenu = driver.findElement(By.id("nav"));
        WebElement footer = driver.findElement(By.id("footer"));

        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");
        Assert.assertTrue(navigationMenu.isDisplayed(), "Navigation menu is not displayed");
        Assert.assertTrue(footer.isDisplayed(), "Footer is not displayed");
    }

    @Test(priority = 6)
    public void formValidation() {
        driver.findElement(By.id("contact-us-link")).click();
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        nameField.sendKeys(""); // Leave name empty to trigger validation
        emailField.sendKeys("invalid-email"); // Invalid email format
        submitButton.click();

        WebElement nameError = driver.findElement(By.id("name-error"));
        WebElement emailError = driver.findElement(By.id("email-error"));

        Assert.assertTrue(nameError.isDisplayed(), "Name field validation failed");
        Assert.assertTrue(emailError.isDisplayed(), "Email field validation failed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
