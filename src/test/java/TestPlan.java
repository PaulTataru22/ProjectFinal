import org.apache.tools.ant.types.resources.First;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    public static final WebDriver driver = new ChromeDriver();

    private static void NavigateToFirstPage() {
        driver.get(Utils.BASE_URL);
        FirstPage firstPage = new FirstPage(driver);
        firstPage.searchForProduct();
        firstPage.clickSearchButton();
    }

    private static void NavigateToSecondPage(){
        NavigateToFirstPage();
        SecondPage secondPage = new SecondPage(driver);
        secondPage.clickOnAddToCart();
    }

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webDriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Search for product")
    public void searchForProduct(){
        driver.get(Utils.BASE_URL);
        FirstPage webForm = new FirstPage(driver);
        webForm.searchForProduct();
        webForm.clickSearchButton();
    }

    @Test(testName = "My Account")
    public void myAccount(){
        driver.get(Utils.BASE_URL);
        FirstPage webForm = new FirstPage(driver);
        webForm.clickOnMyAccount();
    }

    @Test(testName = "My Cart")
    public void myCart(){
        driver.get(Utils.BASE_URL);
        FirstPage webForm = new FirstPage(driver);
        webForm.clickOnMyCart();
    }

    @Test(testName = "Help EMag")
    public void helpEMag(){
        driver.get(Utils.BASE_URL);
        FirstPage webForm = new FirstPage(driver);
        webForm.clickOnHelpEMag();
    }

    @Test(testName = "Download App")
    public void downloadApp(){
        driver.get(Utils.BASE_URL);
        FirstPage webForm = new FirstPage(driver);
        webForm.clickOnDownloadApp();
    }


    @Test(testName = " Select Filters")
    public void selectFilters(){
        NavigateToFirstPage();
        SecondPage webForm = new SecondPage(driver);
        webForm.clickOnFilters();
        webForm.clickOnFilterOption();
    }

    @Test(testName= " Add To Cart")
    public void clickAddToCart(){
        NavigateToFirstPage();
        SecondPage webForm = new SecondPage(driver);
        webForm.clickOnAddToCart();
        Utils.WaitForElement(5);
        Assert.assertEquals(webForm.getCartHeader(), "Produsul a fost adaugat in cos");
    }

    @Test(testName =" View Cart")
    public void clickOnCart(){
        NavigateToSecondPage();
        SecondPage webForm = new SecondPage(driver);
        webForm.clickOnAddToCart();
    }

    @Test(testName = "Empty Cart")
    public void deleteProd() {
        NavigateToSecondPage();
        ThirdPage webForm = new ThirdPage(driver);
        webForm.clickOnDelete();
    }



    @AfterSuite
    public static void cleanUp () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
