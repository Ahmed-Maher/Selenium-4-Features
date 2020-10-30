import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetRectangle {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com/");
        WebElement emailId = driver.findElement(By.id("identifierId"));

        //getting Element Dimension in Selenium 3:
        Dimension emailIdDim = emailId.getSize();
        System.out.println(emailIdDim.getHeight());
        System.out.println(emailIdDim.getWidth());

        Point p  = emailId.getLocation();
        System.out.println(p.getX());
        System.out.println(p.getY());

        System.out.println("#############################");

        //getting Element Dimension in Selenium 4:
        Rectangle emailIdRect = emailId.getRect();
        System.out.println(emailIdRect.getHeight());
        System.out.println(emailIdRect.getWidth());
        System.out.println(emailIdRect.getX());
        System.out.println(emailIdRect.getY());

        driver.close();
    }
}
