package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOuts {
	WebDriver driver;
	
	public TimeOuts(WebDriver driver) {
		this.driver=driver;
	}
	
//try to improve this method, because was not working as expected.
	//instead, is working better by using a Thread.sleep(1000);
	
	public void myWait(int x, By y) {
		WebDriverWait explicit = new WebDriverWait(driver, x);
		explicit.until(ExpectedConditions.visibilityOfElementLocated(y));
		
	}
    
    
}
