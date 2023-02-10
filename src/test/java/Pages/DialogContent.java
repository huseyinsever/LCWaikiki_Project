package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.BreakIterator;
import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "ul[class='menu-nav__lists']>li")
    public List<WebElement> menuList;

    @FindBy(xpath = "//button[text()='Tüm Çerezleri Reddet']")
    public WebElement tumCerezleriReddet;

    @FindBy(css = "input[id='search-form__input-field__search-input']")
    private WebElement inputSearch;

    @FindBy(css = "button[class='search-form__input-field__btn-search false']")
    private WebElement araButton;

    @FindBy(css = "span[class='product-list-heading__product-count']>p")
    private WebElement ceketPageVerify;

    @FindBy(xpath = "(//*[text()='Kadın'])[1]")
    private WebElement kadinClick;

    @FindBy(css = "div[class='desktop-filter-area__content']")
    private WebElement hoverOver;

    @FindBy(css = "div[class='applied-filters__applied-filter']")
    private WebElement cinsiyetVerify;

    @FindBy(xpath = "//span[text()='Blazer Ceket']")
    private WebElement blazerJacket;

    @FindBy(xpath = "//span[text()='M']")
    public WebElement MSize;

    @FindBy(xpath = "//span[text()='Kahverengi']")
    public WebElement kahverengi;

    @FindBy(css = "img[class='product-image__image']")
    private WebElement firstProduct;

    @FindBy(xpath = "(//img[@src='/Resource/Images/ikon-fullscreen.svg'])[1]")
    public WebElement iconImage;

    @FindBy(xpath = "(//a[text()=' ÜRÜN DETAYA GİT'])[1]")
    private WebElement urunDetay;

    @FindBy(css = "[data-tracking-label='SepeteEkle']")
    private WebElement addToCartClick;

    @FindBy(xpath = "(//a[@href='https://www.lcwaikiki.com/tr-TR/TR/sepetim'])[1]")
    private WebElement myCart;

    @FindBy(xpath = "//span[text()='Blazer Ceket']")
    private WebElement itemTitle;

    @FindBy(xpath = "//span[@class='rd-cart-item-size']")
    private WebElement itemSize;

    @FindBy(xpath = "//span[@class='rd-cart-item-color']")
    private WebElement itemColor;

    @FindBy(xpath = "(//span[@class='pull-right'])[2]")
    public WebElement subtotal;

    @FindBy(xpath = "(//span[@class='total-grand-box-amount'])[1]")
    public WebElement grandTotal;

    @FindBy(css = "a[title='Sil']")
    public   WebElement deleteItem;

    @FindBy(xpath = "//a[@class='inverted-modal-button sc-delete']")
    private WebElement deleteClick;

    @FindBy(xpath = "//p[@class='cart-empty-title']")
    private WebElement verifyBasket;

    @FindBy(css = " a[class='main-header-logo']")
    private WebElement goBackToMain;














    WebElement myElement;

    public void findAndClick(String element) {
        switch (element) {
            case "tumCerezleriReddet":myElement = tumCerezleriReddet;break;
            case "araButton":myElement = araButton;break;
            case "kadinClick":myElement = kadinClick;break;
            case "blazerJacket":myElement = blazerJacket;break;
            case "kahverengi":myElement = kahverengi;break;
            case "firstProduct":myElement = firstProduct;break;
            case "iconImage":myElement = iconImage;break;
            case "urunDetay":myElement = urunDetay;break;
            case "myCart":myElement=myCart;break;
            case "deleteItem":myElement=deleteItem;break;
            case "deleteClick":myElement=deleteClick;break;
            case "goBackToMain":myElement=goBackToMain;break;



        }
        clickFunction(myElement);
    }

    public void findAndSend(String element, String value) {
        switch (element) {
            case "inputSearch":myElement = inputSearch;break;


        }
        sendKeysFunction(myElement, value);
    }

    public void verifyText(String element, String text) {
        switch (element) {
            case "ceketPageVerify":myElement = ceketPageVerify;break;
            case "cinsiyetVerify":myElement = cinsiyetVerify;break;
            case "itemTitle":myElement=itemTitle;break;
            case "itemSize":myElement=itemSize;break;
            case "itemColor":myElement=itemColor;break;
            case "verifyBasket":myElement=verifyBasket;break;


        }
        verifyContainsText(myElement, text);
    }

    public void kadinClickAction() {
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(kadinClick).click().build().perform();
    }

    public void hoverOver() {
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(hoverOver).build().perform();
    }

    public void MSizeActionClick() {
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(MSize).click().build().perform();
    }
    public void AddToCartClick() {
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(addToCartClick).click().build().perform();
    }


}




