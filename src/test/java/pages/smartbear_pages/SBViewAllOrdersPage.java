package pages.smartbear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SBViewAllOrdersPage {
    //new class under smartbear_pages package
    public SBViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[2]")
    public WebElement newOrderNameCell;


}
