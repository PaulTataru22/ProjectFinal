import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThirdPage extends PageObject{

    private WebElement clickOnDelete;
    private WebElement clickOnBuy;

    public ThirdPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath="//*[@id=\"vendorsContainer\"]/div/div[1]/div[1]/div[2]/div[1]/div[3]/a[1]")
    private WebElement deleteProd;

    @FindBy (xpath="//*[@id=\"cartProductsPage\"]/div[1]/div[1]/div/div[3]/a")
    private WebElement buyProd;

    public void clickOnDelete() {this.clickOnDelete.click();}
    public void clickOnBuy() {this.clickOnBuy.click();}

}
