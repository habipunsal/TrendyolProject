import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class StepImp extends BaseClass {

    public Actions action = new Actions(webDriver);
    static String gelenText;

    @Step("<url> sitesi acilir.")
    public void UrlGo(String url) {

        webDriver.get(url);

    }

    @Step("<int> saniye bekle")
    public void WaitSecond(int second) {

        Methods.WaitBySecond(second);

    }

    @Step("<id> li Elementin textini al.")
    public void ElementGetText(String id){

        gelenText = webDriver.findElement(By.id(id)).getText();
        System.out.println("Gelen text => " + gelenText);
    }

    @Step("<id> li elementin texti ile gelenText'i karsilastir.")
    public void TextKarsilastir(String id) {
        Assert.assertEquals("Değerler Eşleşmedi!!", webDriver.findElement(By.id(id)).getText(), gelenText);
    }

    @Step("<xpath> Xpath'li Elementin textini al.")
    public void XpathElementGetText(String xpath){

        gelenText = webDriver.findElement(By.xpath(xpath)).getText();
        System.out.println("Gelen text => " + gelenText);
    }

    @Step("<xpath> Xpath'li elementin texti ile gelenText'i karsilastir.")
    public void XpathTextKarsilastir(String xpath) {
        System.out.println("Son Text =>" + webDriver.findElement(By.xpath(xpath)).getText());
        Assert.assertEquals("Değerler Eşleşmedi!!", webDriver.findElement(By.xpath(xpath)).getText(), gelenText);
    }

    @Step("<name> popup kapat.")
    public void popupKapat(String name) {

        webDriver.findElement(By.className(name)).click();

    }

    @Step("<id> anasayfada giris yap tıkla.")
    public void girisYap(String id) {

        webDriver.findElement(By.id(id)).click();
    }

    @Step("<id> Id'li elemente <text> i yazdir")
    public void IdSendKey(String id,String text){
        WebElement element = webDriver.findElement(By.id(id));
        element.sendKeys(text);
    }
    @Step("<xpath> Xpath'li elemente <text> i yazdir")
    public void XpathSendKey(String xpath,String text){
        WebElement element = webDriver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    @Step("<xpath> Xpath'li elemente tıkla.")
    public void ButtonXpathClick(String xpath) throws InterruptedException {

        Methods.ButtonClickXpath(xpath);
    }

    @Step("<id> Id'li elemente tıkla.")
    public void ButtonIdClick(String id) throws InterruptedException {
        Methods.ButtonClickId(id);
    }

    @Step("<xpath> li element var mı ? <text>")
    public void Control(String xpath,String text){

        WebElement element = webDriver.findElement(By.xpath(xpath));

        Assert.assertEquals("Giris Yapılamadı!!",element.getText(),text);
    }

    @Step("<xpath> li elementlerden random urun sec ve tikla")
    public void RndClick(String xpath) throws InterruptedException {

        List<WebElement> elementList = webDriver.findElements(By.xpath(xpath));

        int size = elementList.size();
        Random rnd = new Random();
        int randomUrun = rnd.nextInt(size);

        WebElement selectElement = webDriver.findElement(By.xpath("//div[@class='p-card-wrppr']["+randomUrun+"]/div/a"));

        action.moveToElement(selectElement).build().perform();
        selectElement.click();
    }

    @Step("Urun adedini arttir ve kontrol et.")
    public void UrunArttir() throws InterruptedException {

        if (webDriver.findElements(By.xpath("//button[@class='ty-numeric-counter-button']")).size()>0){

            webDriver.findElement(By.xpath("//button[@class='ty-numeric-counter-button']")).click();

            Thread.sleep(3000);

            String adet = webDriver.findElement(By.xpath("//div[@class='ty-display-flex ty-numeric-counter']/input")).getAttribute("value");

            Assert.assertEquals("Adet arttırılmadı!!",adet,"2");
        }else {
            System.out.println("Bu üründen 1 adet alınabilir!!");
        }

    }
}
