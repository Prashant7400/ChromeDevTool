package CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class NetworkMethod {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(opt);

		DevTools dev = driver.getDevTools();

		dev.createSession(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("width", 500);
		map.put("height", 700);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);

		

		driver.get("https://www.supersitare.in/Account/RegisterNew");

	


		
	}

}
