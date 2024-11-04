package mentorings.tuesday.amazon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    WebDriver driver;

    public AmazonPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    String url = "https://www.amazon.com/";

    AmazonUtils utils = new AmazonUtils();

    @Test
    public void navigateTo() {

        driver.get(Config.getProperty("amazonUrl"));
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(url, actualUrl);
    }

    //Expected size = 47

    public void validateCategoriesSize() {
        int expCategoriesSize = 47;
        List<WebElement> categoriesList = driver
                .findElements(By.cssSelector("ul.hmenu-visible li"));
        Assert.assertEquals(expCategoriesSize, categoriesList.size());
    }

    public void clickHamburgerMenu() {
        driver.findElement(By.id("nav-hamburger-menu")).click();
    }

    @Test
    public void clickCategory() {
        driver.get(url);
        clickHamburgerMenu();
        String categorName = "Prime Video";
        utils.clickCategory(categorName);
        verifyHeader(categorName);
    }

    @Test
    public void clickCategoryFromList() {
        driver.get(url);
        clickHamburgerMenu();
        String categorName = "Prime Video";
        utils.clickCategoryFromList(categorName).click();
        verifyHeader(categorName);
    }

    private void verifyHeader(String categorName) {
        String expectedHeader = driver
                .findElements(By.cssSelector("ul.hmenu-visible .hmenu-title"))
                .get(0)
                .getText();
        Assert.assertTrue(categorName.equalsIgnoreCase(expectedHeader));
    }
}
