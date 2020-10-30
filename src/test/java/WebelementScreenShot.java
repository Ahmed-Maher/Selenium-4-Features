import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebelementScreenShot {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com/");

        //take screenshot for the searchField
        WebElement googleLogo = driver.findElement(By.id("logo"));
        File scrFile = googleLogo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/screenshot/googleLogo.png"));

        driver.close();
    }
}
