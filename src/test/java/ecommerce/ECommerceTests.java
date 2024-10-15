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
        driver.get("https://www.inmotionhosting.com/");
    }

    @Test(priority = 1)
    public void searchForProductAndAddToCart() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("web hosting");
        driver.findElement(By.id("search-button")).click();

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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
