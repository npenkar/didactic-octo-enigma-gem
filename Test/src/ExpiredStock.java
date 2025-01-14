
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.sourceforge.tess4j.Tesseract;


public class ExpiredStock {

	public static void main(String[] args) throws Exception{
		
		String uname;
		String pwd;
		String pnum = null;
		String str;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("   :: Stock update for Pooja/ Yash/ Kantado/ Eshani ::");
		System.out.println("==> Enter P = Pooja || Enter Y = Yash || K = Kantado || E = Eshani: ");
	    str = in.next();
	    Thread.sleep(500);
	    if(str.contentEquals("p") || str.contains("P") || str.contains("pooja"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Pooja ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(1);
			pnum = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\pagenumber.txt")).get(0);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			System.out.println("Page Number for stock update : " +pnum);
	    }else if (str.contentEquals("y") || str.contains("Y") || str.contains("yash"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Yash ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(1);
			pnum = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\pagenumber.txt")).get(0);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			System.out.println("Page Number for stock update : " +pnum);
	    }
	    else if (str.contentEquals("KT") || str.contains("kt") || str.contains("kantado") || str.contains("K") ||  str.contains("k"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Kantado ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
	    }
	    else

//	    	if(str.contentEquals("ES") || str.contains("es") || str.contains("eshani") || str.contains("E"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Eshani ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
	    }
		
		long start = System.currentTimeMillis(); 
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver99.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver99.exe");

//		ChromeOptions o= new ChromeOptions();
//	    o.addArguments("--incognito", "--disable-geolocation");
//	    DesiredCapabilities c = DesiredCapabilities.chrome();
//	    c.setCapability(ChromeOptions.CAPABILITY, o);
	    WebDriver driver = new ChromeDriver();
	      
	      
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String draft = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/index";
		
		System.out.println("	Reading Username and Password from file... ");
		driver.manage().window().maximize();
		driver.get(login);
		driver.findElement(By.id("loginid")).sendKeys(uname); 
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(2)>button")).click();
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(500);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(4000); 
		System.out.println("===>> LOGIN SUCCESS...");
		
		driver.get(draft);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath(".//span[contains(text(),'More')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//a[contains(text(),'Expired Offerings')]")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		
//		driver.findElement(By.xpath("//a[contains(text(),'»')]")).click();
//		Thread.sleep(4000);
		int count = 0;
for(int i=0; i<500; i++)
{	
	
	driver.findElement(By.xpath("//a[contains(text(),'»')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'‹')]")).click();
	Thread.sleep(3000);
//	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/ul/li["+pnum+"]/a")).click();
//	Thread.sleep(5000);
	
//	driver.findElement(By.xpath("//a[contains(text(),'‹')]")).click();
//	Thread.sleep(7000);

	for(int j=1;j<=10;j++)
	{		

		Actions action = new Actions(driver);
		WebElement opennewTAB = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr["+j+"]/td[12]/span[1]/a"));		
//		action.moveToElement(opennewTAB).contextClick().build().perform();

		Robot robot = new Robot();
		
		action.keyDown(Keys.CONTROL).moveToElement(opennewTAB).click().perform();
		Thread.sleep(100);
		
//		Thread.sleep(500);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(200);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(5000);

		WebElement country = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[1]/div[2]/div[1]/div[1]/input"));
		country.click();
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//		Thread.sleep(300);
//		country.sendKeys("JAPAN");
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(100);
	
		
//		WebElement TEXTBOX20 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input"));
//		
//		WebElement TEXTBOX21 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input"));
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		box20
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input")).size() != 0)
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input")).sendKeys("a");
		}else
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input")).sendKeys("a");
		}
		
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input")).sendKeys("a");
		
//		uPDATE20/21
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/button/span")).size() != 0)
		{
			WebElement Submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/button/span"));
			action.moveToElement(Submit).click().build().perform();
		}else
		{
			WebElement Submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/button/span"));
			action.moveToElement(Submit).click().build().perform();
		}
		
//		Thread.sleep(1000);
//		captcha check start here
					
		do {
		if(( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha")) || ( driver.getPageSource().contains("Catalogue already uploaded by you"))))
						
			Thread.sleep(1000);
		
//		REFRESH20/21
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[1]/i")).size() != 0)
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[1]/i")).click();
		}else
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[1]/i")).click();
		}
		
//		CAPTCHA20/21
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[1]/img")).size() != 0)
		{
			WebElement captchaElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[1]/img"));
			String captcha = captchaElement.getAttribute("src");
			Thread.sleep(600);
			URL CAPTCHAURL = new URL(captcha);
			BufferedImage saveCAPTCHA = ImageIO.read(CAPTCHAURL);
			ImageIO.write(saveCAPTCHA, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\captcha.png"));
		}else
		{
			WebElement captchaElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[1]/img"));
			String captcha = captchaElement.getAttribute("src");
			Thread.sleep(600);
			URL CAPTCHAURL = new URL(captcha);
			BufferedImage saveCAPTCHA = ImageIO.read(CAPTCHAURL);
			ImageIO.write(saveCAPTCHA, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\captcha.png"));
		}
			
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\OCRlib\\Tess4J");
					// the path of your tess data folder
					// inside the extracted file
		String captchaTotext = tesseract.doOCR(new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\captcha.png"));
					// path of your image file
		String CapitalCaptcha = captchaTotext.toUpperCase();
		System.out.print(CapitalCaptcha);
			
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input")).size() != 0)
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input")).clear();
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/show-captcha/div/div[2]/input")).sendKeys(CapitalCaptcha);
		}else
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input")).clear();
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input")).sendKeys(CapitalCaptcha);	
		}
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input"))
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[2]/input")).sendKeys(CapitalCaptcha);
		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/show-captcha/div/div[3]/label")).click();
//		Thread.sleep(1000);
				
				//				============= Tess4J CAPTCHA Tweak end =============
		
//		uPDATE20/21
		if(driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/button/span")).size() != 0)
		{
			WebElement Submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/button/span"));
			action.moveToElement(Submit).click().build().perform();
		}else
		{
			WebElement Submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/button/span"));
			action.moveToElement(Submit).click().build().perform();
		}
		
		
//		Thread.sleep(500);
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		Thread.sleep(500);
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		Thread.sleep(500);
//		action.moveToElement(Submit).click().build().perform();
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/input")).click();;
		Thread.sleep(1500);
				
		if (driver.getPageSource().contains("Stock Updated Successfully"))
		{
			break;
		}
		else {
			continue;
		}
//		Thread.sleep(4000);	
		}while( ( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha"))));
//		
		
//		WebElement UPDATE = driver.findElement(By.xpath("//button[contains(text(),'Update Stock')]"));
//		JavascriptExecutor CLICK = (JavascriptExecutor) driver;
//		CLICK.executeScript("arguments[0].click();", UPDATE);
		Thread.sleep(3500); 
		driver.close();
		driver.switchTo().window(tabs.get(0));
		count++;
		long ExecutionTime = (System.currentTimeMillis() - start);
		long ETS = ExecutionTime/1000 ;
		System.out.println(" ====>  "+count+" : Stock Updated in " + ETS +" seconds");
		}
	  }
	}
}	