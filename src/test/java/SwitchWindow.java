import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchWindow() throws IOException {

        //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

//Switching Window

        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();

        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        driver.get("https://rahulshettyacademy.com/");

        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

                .get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement name = driver.findElement(By.cssSelector("[name='name']"));

        name.sendKeys(courseName);

//Screenshot

        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

//driver.quit();

//GEt Height & Width

        //System.out.println(name.getRect().getDimension().getHeight());

        // System.out.println(name.getRect().getDimension().getWidth());

    }

    @Test
    public void chileWindow() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        
        Set<String> handel = driver.getWindowHandles();
        Iterator<String> t = handel.iterator();
        String parent = t.next();
        String child = t.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parent);

        driver.findElement(By.id("username")).sendKeys(emailId);

    }

}








