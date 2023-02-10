package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LCWaikiki_StepDefinitions {
    DialogContent dc=new DialogContent();
    Parent parent=new Parent();

    @Given("Navigate To Website")
    public void navigateToWebsite() {
        GWD.getDriver().get("https://www.lcwaikiki.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Verify the menu options that appear")
    public void verifyTheMenuOptionsThatAppear() {
        List<String>menuExpected=new ArrayList<>();
        menuExpected.add("KADIN");
        menuExpected.add("ERKEK");
        menuExpected.add("ÇOCUK");
        menuExpected.add("BEBEK");
        menuExpected.add("AYAKKABI");
        menuExpected.add("AKSESUAR");
        menuExpected.add("EV & YAŞAM");
        menuExpected.add("DİĞER MARKALAR");
        menuExpected.add("WAIKIKILAND");
        menuExpected.add("DOĞA ADINA");
        menuExpected.add("OUTLET");

        for (int i = 0; i < menuExpected.size(); i++) {
            Assert.assertEquals(menuExpected.get(i),dc.menuList.get(i).getText());
            System.out.println(dc.menuList.get(i).getText());
        }

    }

    @And("Type Jacket in the search box and search")
    public void typeJacketInTheSearchBoxAndSearch() {
        dc.findAndSend("inputSearch","Ceket");
        dc.findAndClick("araButton");
        dc.verifyText("ceketPageVerify","\"Ceket\"");
        dc.findAndClick("tumCerezleriReddet");
    }

    @And("Click on the woman button")
    public void clickOnTheWomanButton() {
        dc.kadinClickAction();
        dc.verifyText("cinsiyetVerify","Kadın");
    }

    @And("Select Blazer Jacket from product type")
    public void selectBlazerJacketFromProductType() {
        dc.hoverOver();
        dc.findAndClick("blazerJacket");
    }

    @And("Choose size M")
    public void chooseSizeM() {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.MSize);
        GWD.Bekle();
        dc.MSizeActionClick();
    }

    @And("Choose brown from the colors")
    public void chooseBrownFromTheColors() {
        GWD.Bekle();
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.kahverengi);
        GWD.Bekle();
        dc.findAndClick("kahverengi");
    }

    @And("Click on the first of the results")
    public void clickOnTheFirstOfTheResults() {
        dc.findAndClick("firstProduct");
    }

    @And("Click add to cart")
    public void clickAddToCart() {
            JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
            WebElement iconImage=GWD.getDriver().findElement(By.xpath("(//img[@src='/Resource/Images/ikon-fullscreen.svg'])[1]"));
            js.executeScript("arguments[0].scrollIntoView();",iconImage);
            js.executeScript("arguments[0].click()",iconImage);
            dc.findAndClick("urunDetay");
            GWD.Bekle();
            WebElement addToCart=GWD.getDriver().findElement(By.xpath("(//*[text()='SEPETE EKLE'])[2]"));
            js.executeScript("arguments[0].scrollIntoView();",addToCart);
            js.executeScript("arguments[0].click()",addToCart);
        }

    @And("Click my cart")
    public void clickMyCart() {
        dc.findAndClick("myCart");
    }

    @And("Verify that the product has arrived in the cart")
    public void verifyThatTheProductHasArrivedInTheCart() {
        dc.verifyText("itemTitle","Blazer Ceket");
        dc.verifyText("itemSize","Beden: M");
        dc.verifyText("itemColor","Renk: Kahverengi");
    }

    @And("Compare the subtotal to the grand total and verify that the amount is the same")
    public void compareTheSubtotalToTheGrandTotalAndVerifyThatTheAmountIsTheSame() {
        Assert.assertEquals(dc.subtotal.getText(),dc.grandTotal.getText());
    }

    @And("Delete product from cart")
    public void deleteProductFromCart() {
        dc.deleteItem.click();
        dc.findAndClick("deleteClick");
    }

    @And("Verify that the basket is empty")
    public void verifyThatTheBasketIsEmpty() {
        dc.verifyText("verifyBasket","Sepetinizde ürün bulunmamaktadır.");
    }

    @Then("Go back to the main page and verify that you are on the page")
    public void goBackToTheMainPageAndVerifyThatYouAreOnThePage() {
        dc.findAndClick("goBackToMain");
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://www.lcwaikiki.com/tr-TR/TR"));
    }
}
