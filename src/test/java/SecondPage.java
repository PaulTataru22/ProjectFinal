import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondPage extends PageObject {

    public SecondPage(WebDriver driver){
    super(driver);
}

    @FindBy(xpath = "//*[@id=\"my_cart\"]")
    private WebElement clickOnCart;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[3]/a[1]")
    private WebElement deleteButton;
    @FindBy(xpath ="//*[@id=\"page-skin\"]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div[2]/div[1]/button")
    private WebElement selectFilters;
    @FindBy(xpath ="//*[@id=\"card_grid\"]/div[1]/div/div/div[3]/div[3]/form/button")
    private WebElement addToCart;
    @FindBy(css = ".sort-control-group > div:nth-child(2)  > div:first-of-type > div:first-of-type  > ul:first-of-type> li:nth-child(3) > a")
    private WebElement filterOption;
    @FindBy(xpath ="/html/body/div[8]/div/div/div[2]/div/div[3]/a")
    private WebElement viewCart;
    @FindBy(xpath = "/html/body/div[8]/div/div/div[1]/h4")
    private WebElement cartHeader;
    @FindBy(xpath= "/html/body/div[8]/div/div/div[1]/button")
    private WebElement exitButton;
    @FindBy(xpath="//*[@id=\"empty-cart\"]/div[1]")
    private WebElement emptyHeader;

    public String getEmptyHeader() {return this.emptyHeader.getText();}
    public String getCartHeader() { return this.cartHeader.getText(); }
    public void clickOnAddToCart() {this.addToCart.click();}
    public void clickOnFilters() {
        this.selectFilters.click();
    }
    public void clickOnFilterOption(){this.filterOption.click();}
    public void clickOnMyCart() {this.clickOnCart.click();}
    public void clickExit() {this.exitButton.click();}
    public void deleteProd() {this.deleteButton.click(); }
}

