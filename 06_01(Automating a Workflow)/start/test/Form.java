import Pages.ConfirmationPage;
import Pages.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Pages.FormPage.submitForm;
import static org.junit.Assert.assertEquals;


public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/suparnasoman/Documents/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        // new object of form page
        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitforAlertBanner(driver);

        assertEquals("The form was successfully submitted!",confirmationPage.getAlertBannerText(driver));
        driver.quit();
    }
}
