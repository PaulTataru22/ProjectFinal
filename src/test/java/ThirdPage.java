import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThirdPage extends PageObject{

    public ThirdPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"vendorsContainer\"]/div/div[1]/div[1]/div[2]/div[1]/div[3]/a[1]")
    private WebElement deleteProd;
    @FindBy (xpath="//*[@id=\"cartProductsPage\"]/div[1]/div[1]/div/div[3]/a")
    private WebElement buyProd;
    @FindBy (xpath = "//*[@id=\"card_grid\"]/div[1]/div/div/div[1]/div[2]/button[2]")
    private WebElement addFavorite;
    @FindBy (xpath="//*[@id=\"masthead\"]/div/div/div[3]/div/div[3]")
    private WebElement clickFavorite;
    @FindBy (xpath= "//*[@id=\"list-of-favorites\"]/div/div[2]/div[2]/div[2]/div[4]/div[2]/button/i")
    private WebElement clickOnDelete;

    public void clickOnAddToFavorite() {this.addFavorite.click();}
    public void clickFavorite() {this.clickFavorite.click();}
    public void clickDeleteProd() {this.clickOnDelete.click();}

}
