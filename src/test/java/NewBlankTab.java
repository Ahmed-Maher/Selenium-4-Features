import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NewBlankTab {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com/");
        System.out.println(driver.getTitle());

        /* Open a new Blank Tab
         * the driver will be switched to the new tab
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
