package CDP;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class EmulationMethod {
	
	// using customised setDeviceMetricsOverride  method
	// to open in mobile device mode

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(opt);

		DevTools dev = driver.getDevTools();

		dev.createSession();

		dev.send(Emulation.setDeviceMetricsOverride(390, 844, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));
		

		driver.get("https://www.supersitare.in/Account/RegisterNew");
		
		driver.findElement(By.cssSelector(".navbar-toggle")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()=\" Rewards\"]")).click();
	}

}
