import java.awt.AWTException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Approvals 
{
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver94.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String pendinglist = "https://admin-mkp.gem.gov.in//cms/admin/catalog_approval#!/oem_approval_index/catalogs?category_id=home_offi_offi_prin_comp&make=11680&dceo_view=false";
		int count = 1;
		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\approvals.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\approvals.txt")).get(1);
		System.out.println("	get Username and Password ... ");
		
		driver.manage().window().maximize();
		driver.get(login);
		driver.findElement(By.id("loginid")).sendKeys(uname);
		Thread.sleep(100);
		driver.findElement(By.xpath("/html[1]/body[1]/section[5]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/button[1]")).click();
		Thread.sleep(100);
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(600);
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		Thread.sleep(600);
		Thread.sleep(600);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(3000);

		for(int i=0; i<=100; i++)
		{
		Robot robot = new Robot();
		driver.get(pendinglist);
		Thread.sleep(600);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request") || driver.getPageSource().contains("GeM - Government e Marketplace : Service Unavailable"))
		{
			 driver.navigate().refresh();
			 System.out.println("Error: page not loaded correctly ......., refreshing ... " );
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		for(int j=1; j<=10; j++)
		{
		long start = System.currentTimeMillis();
		Thread.sleep(700);
		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[11]/a[1]"));
		action.moveToElement(link).contextClick().build().perform();
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(700);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request") || driver.getPageSource().contains("GeM - Government e Marketplace : Service Unavailable"))
		{
			 driver.navigate().refresh();
			 System.out.println("Error: page not loaded correctly ......., refreshing ... " );
		} 

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Price = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/approval-component[1]/div[1]/div[2]/uib-accordion[1]/div[1]/div[2]/div[2]/div[1]/div[1]/seller-mrp[1]/table[1]/tbody[1]/tr[1]/td[1]/i[1]/font[1]")).getText();
		System.out.println("	Price Ye hee ==> " + Price);
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/approval-component/div/div[3]/div/button[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/approval-component[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("25");
		Thread.sleep(200);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/approval-component[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(Price);
		Thread.sleep(200);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/approval-component[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(5500);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		Thread.sleep(600);
		System.out.println("Product Appoved Success --> "+count);
		count++;
		long ExecutionTime = (System.currentTimeMillis() - start);
		long ETS = ExecutionTime / 1000;
		System.out.println("Time: " + ETS + " seconds");
		}
		}
	}
}