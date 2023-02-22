package hw;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
		Actions move=new Actions(driver);
		move.moveToElement(brands).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
        driver.findElement(By.linkText("L'Oreal Paris")).click();
		
//		WebElement title=driver.findElement(By.linkText("L'Oreal Paris"));
		String name=driver.getTitle();
		System.out.println("Title ="+ name);
		
		WebElement sortby=driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
		sortby.click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		WebElement category=driver.findElement(By.xpath("//span[text()='Category']"));
		category.click();
		
		
		WebElement hair=driver.findElement(By.xpath("(//span[@class='filter-name '])[2]"));
		hair.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Hair Care']"))).click();
//		WebElement care=driver.findElement(By.xpath("//span[text()='Hair Care']"));
	     	
		
		WebElement shampoo=driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]"));
		shampoo.click();
		
		WebElement concern=driver.findElement(By.xpath("//span[text()='Concern']"));
		concern.click();
		
		WebElement cpro=driver.findElement(By.xpath("//span[text()='Color Protection']"));
		cpro.click();
		
		//checking
		WebElement filter=driver.findElement(By.xpath("//span[text()='Filters Applied']"));
		String name1=filter.getText();
		if(filter.getText().contains(name1)) {
			System.out.println("filter applied");
		}
//		 String a= driver.getWindowHandle();
//		 System.out.println(a);
		WebElement product=driver.findElement(By.xpath("//div[@class='css-43m2vm']"));
	    product.click();
	      
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowHandle1=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowHandle1.get(1));
		
		 WebElement ml=driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		   Select select=new Select(ml);
				select.selectByVisibleText("180ml"); 
				
				WebElement productPrice=driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']//span)[2]"));
				System.out.println(productPrice.getText());
			

				WebElement addToBag=driver.findElement(By.xpath("(//button[@class=' css-1qvy369']//span)[1]"));
				addToBag.click();
				
				WebElement shoppingBag=driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
				shoppingBag.click();
				
				driver.switchTo().frame(0);
				WebElement price=driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span"));
				String price1=price.getText();
				System.out.println(price1);
				
				WebElement proceed=driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]"));
				proceed.click();
				
				WebElement continueAs=driver.findElement(By.xpath("//button[text()='Continue as guest']"));
				continueAs.click();
				
				WebElement check1=driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']"));
				check1.click();
				
				WebElement check2=driver.findElement(By.xpath("(//span[@class='css-1b232xc ehes2bo3'])[2]"));
				check2.click();
				WebElement check3=driver.findElement(By.xpath("(//p[@class='css-masf0q eka6zu20'])[2]"));
				String rate2=check3.getText();
				System.out.println(rate2);
				
				if (price1.equals(rate2)) {
					System.out.println("the grand total is the same in step 14");
				}
				
	}

}