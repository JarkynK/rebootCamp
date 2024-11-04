package pages.wiki_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WikiHomePage {

    public WikiHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //start locating webelements
    @FindBy(id = "searchInput")
    public WebElement searchBox;

    //2- search button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    //3- main header
    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    //4- image header
    @FindBy(css = "div.fn")
    public WebElement imageHeader;
}
