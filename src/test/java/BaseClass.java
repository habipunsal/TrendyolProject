import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BaseClass {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    @BeforeScenario
    public void setup(){

        Locale.setDefault(new Locale("en","EN"));

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions chromeOptions = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Habip ÜNSAL\\IdeaProjects\\TrendyolProje\\WebDriver\\chromedriver.exe");

        chromeOptions.addArguments("incognito");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();

        webDriverWait = new WebDriverWait(webDriver,45,150);
    }

    @AfterScenario
    public void afterSc(){

        webDriver.quit();

    }

}
