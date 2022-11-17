package app;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Step1 {
	
	WebDriver driver;
	
	public Step1(WebDriver driver) {
		this.driver=driver;
	}
	
	public void run(String val) throws InterruptedException {
		try {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get(val);
        driver.manage().window().maximize();
		}catch(NoSuchElementException e) {
			System.out.println("Error: "+e);
		}
	}

}
