package pages.cybertekTraning_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CBTHomepage {

    public CBTHomepage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[contains(text(),'Teacher Name')]/preceding-sibling::*")
    public WebElement teacherName;

    @FindBy(xpath = "//a[contains(text(), 'Search')]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//a[@class='avatar'])[1]")
    public WebElement avatar;

    @FindBy(xpath = "(//h4)[1]")
    public WebElement nameOfUser;

    @FindBy(xpath = "(//h3)[2]")
    public WebElement fullName;

    @FindBy(xpath = "//span[contains(text(), 'Phone')]/following-sibling::*/a")
    public  WebElement phoneNumber;

    @FindBy(xpath = "//span[contains(text(), 'Teacher ID:')]/following-sibling::*/a")
    public WebElement teacherId;

    @FindBy(xpath = "//span[contains(text(), 'Email')]/following-sibling::*/a")
    public  WebElement email;

    @FindBy(xpath = "//span[contains(text(), 'Batch')]/following-sibling::*/a")
    public  WebElement batch;

    @FindBy(xpath = "//span[contains(text(), 'Birthday:')]/following-sibling::*")
    public WebElement birthday;

    @FindBy(xpath = "//span[contains(text(), 'Join Date:')]/following-sibling::*")
    public WebElement joinDate;

    @FindBy(xpath = "//span[contains(text(), 'Address:')]/following-sibling::*")
    public WebElement address;

    @FindBy(xpath = "//span[contains(text(), 'Gender:')]/following-sibling::*")
    public WebElement gender;

    @FindBy(xpath = "//span[contains(text(), 'Section:')]/following-sibling::*")
    public WebElement section;

    @FindBy(xpath = "//span[contains(text(), 'Salary:')]/following-sibling::*")
    public WebElement salary;

    @FindBy(xpath = "//span[contains(text(), 'Subject:')]/following-sibling::*")
    public WebElement subject;

    @FindBy (xpath = "//div[@id='sidebar-menu']//span[.=' Teachers']")
    public WebElement teachersDropdown;

    @FindBy(xpath = "//div[@id='sidebar-menu']//span[.=' Students']")
    public WebElement studentsDropdown;

    @FindBy(xpath = "//div[@id='sidebar-menu']//a[@href='all-teachers.html']")
    public WebElement allTeachersLink;

    @FindBy (xpath = "//a[@href='add-teacher.html']")
    public WebElement addTeacherLink;

    @FindBy (xpath = "//div[@id='sidebar-menu']//a[@href='all-students.html']")
    public WebElement allStudentsLink;

    @FindBy (xpath = "(//div[@class='form-group custom-mt-form-group']//input)[1]")
    public WebElement searchStudentById;

    @FindBy (xpath = "//div[@id='sidebar-menu']//a[@href='add-student.html']")
    public WebElement addStudentLink;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement teacherIDSearchInput;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement teacherNameSearchInput;

    @FindBy(xpath = "//div[@class='row staff-grid-row']//h4/a")
    public List<WebElement> searchResultsName;

}
