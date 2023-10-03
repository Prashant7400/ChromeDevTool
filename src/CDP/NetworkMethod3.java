package CDP;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.ConnectionType;

public class NetworkMethod3 {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-orihins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools dev =  driver.getDevTools();
		
		dev.createSession();
		
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		dev.send(Network.emulateNetworkConditions(false, 3000, 3000, 2000, Optional.of(ConnectionType.WIFI)));
		
		
		
		driver.get("https://www.supersitare.in/Account/RegisterNew");
	}

}
