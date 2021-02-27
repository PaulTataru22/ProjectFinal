import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends PageObject {
    private final String SEARCH_PRODUCT = "FIFA 21";

    FirstPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'searchboxTrigger\']")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"my_account\"]")
    private WebElement myAccount;
    @FindBy(xpath = "//*[@id=\"my_cart\"]/i")
    private WebElement myCart;
    @FindBy(xpath = "//*[@id=\"auxiliary\"]/div/div/ul[3]/li/a")
    private WebElement helpEMag;
    @FindBy(css =".send-me-a-message > div:first-of-type > div > input")
    private WebElement downloadApp;
    @FindBy(xpath ="/html/body/div[4]/footer/div[1]/div/div/div[2]/div/form/div[1]/div/div/button")
    private WebElement sendSms;

    public void clickOnSendSms() {this.sendSms.click();}
    public void searchForProduct() { this.searchBar.sendKeys(SEARCH_PRODUCT);}
    public void clickSearchButton() {this.searchButton.click();}
    public void clickOnMyAccount() {this.myAccount.click();}
    public void clickOnMyCart() {this.myCart.click();}
    public void clickOnHelpEMag() {this.helpEMag.click(); }
    public void clickOnDownloadApp() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.downloadApp);
        Utils.WaitForElement(5);
        this.downloadApp.sendKeys("0754935280");}
}
