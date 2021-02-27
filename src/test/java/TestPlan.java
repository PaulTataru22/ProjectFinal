import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    public static final WebDriver driver = new ChromeDriver();

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
        webForm.clickOnSendSms();
    }


    @Test(testName = " Select Filters")
    public void selectFilters(){
        NavigateToFirstPage();
        SecondPage webForm = new SecondPage(driver);
        Utils.WaitForElement(3);
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

    @Test(testName = "Empty Cart")
    public void deleteProd() {
        NavigateToFirstPage();
        SecondPage webForm = new SecondPage(driver);
        webForm.clickOnAddToCart();
        Utils.WaitForElement(3);
        webForm.clickExit();
        Utils.WaitForElement(3);
        webForm.clickOnMyCart();
        Utils.WaitForElement(3);
        webForm.deleteProd();
        Utils.WaitForElement(3);
        Assert.assertEquals(webForm.getEmptyHeader(), "Cosul tau este gol");
    }

    @Test(testName = "Favorite")
    public void clickOnAddToFavorite(){
        NavigateToFirstPage();
        ThirdPage webForm = new ThirdPage(driver);
        webForm.clickOnAddToFavorite();
    }

    @Test(testName = "Delete Favorite")
    public void deleteFavorite(){
        NavigateToFirstPage();
        ThirdPage webForm = new ThirdPage(driver);
        webForm.clickOnAddToFavorite();
        Utils.WaitForElement(3);
        webForm.clickFavorite();
        Utils.WaitForElement(3);
        webForm.clickDeleteProd();
    }

    @AfterSuite
    public static void cleanUp () {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    /*
    PAGE NAVIGATION HELPER FUNCTIONS
     */
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
}
