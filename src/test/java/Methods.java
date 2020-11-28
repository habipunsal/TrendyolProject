import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods extends BaseClass {

    public static void ButtonClickId(String id) throws InterruptedException {

        WebElement element;
        int sayac=0;
        int son=50;
        while (sayac<son) {
            try {
                element = webDriver.findElement(By.id(id));
                element.click();
                break;
            }catch (Exception e){
            }
            sayac++;
            Thread.sleep(200);
        }
    }

    public static void ButtonClickXpath(String xpath) throws InterruptedException {

        WebElement element;
        int sayac=0;
        int son=50;
        while (sayac<son) {
            try {
                element = webDriver.findElement(By.xpath(xpath));
                element.click();
                break;
            }catch (Exception e){
            }
            sayac++;
            Thread.sleep(200);
        }
    }

    public static void WaitBySecond(int second){

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
