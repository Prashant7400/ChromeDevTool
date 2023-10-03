package CDP;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;

import com.google.common.collect.ImmutableList;

public class NetworkMethod2 {
		
		// Using Network Method block all jpg,png,css image

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools dev = driver.getDevTools();
		dev.createSession();
		
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		long starttime = System.currentTimeMillis();
		
		dev.send(Network.setBlockedURLs(ImmutableList.of("*.png")));
		driver.get("https://jklcsky.in/home/login");
		Long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
		

		
		
		
		
	}

}
