package CDP;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Request;
import org.openqa.selenium.devtools.v116.network.model.Response;

public class NetworkMethod1 {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe116\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(opt);
		
		DevTools dev = driver.getDevTools();
		
		dev.createSession();
		
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		dev.addListener(Network.requestWillBeSent(), request -> {
			
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			
		});
		
		dev.addListener(Network.responseReceived(), response ->{
			
			Response res = response.getResponse();
			System.out.println( res.getStatus()+ res.getStatusText());
		});
		
		driver.get("https://www.supersitare.in/Account/RegisterNew");
	
		
		
		
		
		
		
		

	}

}
