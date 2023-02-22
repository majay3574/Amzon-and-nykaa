package hw;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amzn {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//span[text()='₹34,999']
		String e=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText().replaceAll("[^\\d]", "");
		int price = Integer.parseInt(e);
		System.out.println("The price of the first product is: "+price);
		
		WebElement b=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro']//div[@class='a-row a-size-small'])[1]"));
		System.out.println("ratings =" +b.getText());
	
		WebElement link=driver.findElement(By.xpath("(//div[@class='aok-relative']//a)[1]"));
				link.click();
//		File screenshotFile =driver.getScreenshotAs(OutputType.FILE);
//		File destination = new File("/snap/linkpic.png");
//	    FileUtils.copyFile(screenshotFile,destination)
				
				Set<String> windowHandle = driver.getWindowHandles();
				List<String> windowHandle1=new ArrayList<String>(windowHandle);
				driver.switchTo().window(windowHandle1.get(1));
				
				driver.findElement(By.id("add-to-cart-button")).click();
		
//				File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
//				FileUtils.copyFile(screenshotFile, new File("product_screenshot.png"));

                String sub = driver.findElement(By.xpath("(//span[@class='a-price sw-subtotal-amount']//span)[4]")).getText().replaceAll("[^\\d]", "");
                    int  subPrice=Integer.parseInt(sub);
                    
                if (subPrice==price) {
                   System.out.println("Cart subtotal is correct: "+ subPrice);
                } 


}
}