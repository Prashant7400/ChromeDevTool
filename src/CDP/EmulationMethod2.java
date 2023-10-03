package CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class EmulationMethod2 {
	
	// 	 using without customised geolocation method


	public static void main(String[] args) {


		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(opt);

		DevTools dev = driver.getDevTools();

		dev.createSession();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("latitude", 41);
		map.put("longitude", 12);
		map.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", map);
		
		
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Amazon",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()=\"Shop online at Amazon India - Great deals on Amazon\"]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[text()=\"Best Sellers\"])[1]")).getText());
		
		
	}

}
