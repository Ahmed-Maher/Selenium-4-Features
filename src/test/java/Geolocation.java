import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Geolocation {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude", 34.036903);
        coordinates.put("longitude", -118.086153);
        coordinates.put("accuracy", 1);

        //https://chromedevtools.github.io/devtools-protocol/tot/Emulation/ -- Location of the emaulation cmd
        ((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://oldnavy.gap.com/stores");


    }
}
