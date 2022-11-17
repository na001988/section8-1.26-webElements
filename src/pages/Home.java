package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver=driver;
	}
	
	public String search_xpath(String x, String y) {
		
		String val="";
		By header = By.xpath(x);
		
		try{
			val = driver.findElement(header).getText();
			if(val.contains(y)) {
				return val = "Element Located OK";
			}

		}catch(NoSuchElementException e){
			System.out.println("Error on page Main: "+e);
		}
		return val;
	}
	

}
