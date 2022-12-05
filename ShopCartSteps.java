package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShopCartSteps {
    WebDriver driver=null;
    String gettext, totoltext;

    @Given("user is on the Home_Page")
    public void user_is_on_the_home_page() throws InterruptedException {
        System.out.println("Browser is open");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagar\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user click on the signin tab")
    public void user_click_on_the_signin_tab() {
        System.out.println("Click Signin option");
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']")).click();
    }

    @When("user enters the username and password")
    public void user_enters_the_username_and_password() {
        System.out.println("Enter the username and password");
        driver.findElement(By.id("email")).sendKeys("nagarajm8300@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Nagaraj767@");
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        System.out.println("Click login button");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @When("user enters the hom page")
    public void user_enters_the_hom_page() {
        System.out.println("Click Home button");
        driver.findElement(By.xpath("//span[text()=' Home']")).click();
    }

    @When("user clicks AddtoCart for any products")
    public void user_clicks_addto_cart_for_any_products() throws InterruptedException {
        System.out.println("Add products to cart");
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_product=4&controller=product']")).click();
        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("p#add_to_cart>button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div/div[3]/div/p/button")).click();
    }

    @When("user gets the price of that product")
    public void user_gets_the_price_of_that_product() {
        System.out.println("Price of the product");
        String gettext = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();
        System.out.println(gettext.replaceAll("[^0-9]", ""));
    }

    @When("user clicks contiue shopping")
    public void user_clicks_contiue_shopping() {
        System.out.println("Click continue shopping");
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
    }

    @When("user clicks the checkout option")
    public void user_clicks_the_checkout_option() {
        System.out.println("Click checkout option");
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
        String totaltext = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
        System.out.println(totaltext.replaceAll("[^0-9]",""));
    }

    @When("user compares the Actuall price and Cart value")
    public void user_compares_the_actuall_price_and_cart_value() {
        System.out.println("Compare price");
        Assert.assertArrayEquals(gettext.getBytes(), totoltext.getBytes());
    }

    @Then("place order")
    public void place_order() throws InterruptedException {
        System.out.println("order is going to be placed");
       driver.findElement(By.xpath("(//span)[61]")).click();
       Thread.sleep(10000);
       driver.close();
    }
}
