package app;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	String base = Math.random()+"-";
	String fileType = base.substring(2,10)+".jpg";
	
	public void getSreenShoot(WebDriver wd) throws IOException {
		
		java.io.File file = (java.io.File) ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new java.io.File("./src/screenshots/"+fileType));
	}
	
	
	public void closeAlert(WebDriver wd) {
	 	if (wd.getPageSource().contains("Get Price Alerts")) {
	  		wd.switchTo().alert().dismiss();
	  		System.out.println("Alert closed ");
	 	}
	}
	
	
	

}





