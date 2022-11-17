package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import app.Constants;
import app.Utils;
import db.ConnectionDB;

public class Flights {

	WebDriver driver;
	WebElement we;
	Constants c = new Constants();
	Utils u = new Utils();
	ConnectionDB cn = new ConnectionDB();

	
	public Flights(WebDriver driver) {
		this.driver=driver;
	}
	
	public void search_xpath(String x, String y) throws InterruptedException{
		By obj = By.xpath(x);
		try{
			driver.findElement(obj).sendKeys(y);
			Thread.sleep(c.delay());
			driver.findElement(obj).sendKeys(Keys.ENTER);
			driver.findElement(obj).sendKeys(Keys.TAB);
			u.getSreenShoot(driver);
		}catch(NoSuchElementException | IOException e){
			System.out.println("Error on page Flights-search_xpath: "+e);
			try {
				u.getSreenShoot(driver);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}	

	public void doClick(String x) throws InterruptedException {
		By obj = By.xpath(x);
		try{
			driver.findElement(obj).click();
			Thread.sleep(c.delay());
						
		}catch(NoSuchElementException e ){
			System.out.println("Error on Flights-doClick: "+e);
			try {
				u.getSreenShoot(driver);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void select_trip(String x, String y)  throws InterruptedException{
		By obj = By.xpath(x);
		try{
			we = driver.findElement(obj);
			Select sl = new Select(we);
			sl.selectByVisibleText(y);
		}catch(NoSuchElementException e){
			System.out.println("Error on Flights-trip: "+e);
			try {
				u.getSreenShoot(driver);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	public void select_people(String x)  throws InterruptedException{
		By obj = By.cssSelector(x);
		try{
			driver.findElement(obj).click();
		}catch(NoSuchElementException e){
			System.out.println("Error on Flights-select_people: "+e);
			try {
				u.getSreenShoot(driver);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}	
	
	
	public String bestOption() throws InterruptedException, ClassNotFoundException, SQLException{ 
		String link="";

		// the list of options has a unique url link.
		// I will take that url to get the cheaper option.
		Thread.sleep(c.delay());
		List<WebElement> findTags = driver.findElements(By.tagName("a"));
		String[] name = new String[10];
				
		int i=0;
        try {
        	
			for(WebElement x:findTags) {
	        	link = x.getAttribute("href");
	        	//System.out.println("Contents-1: "+x.getAttribute("href"));
	        	//System.out.println("Contents-2: "+x.getAttribute("aria-label"));
	        	
	        	if(i<10 && link != null) {
	        		if(link.contains("?code")) {
	        			name[i]=x.getAttribute("href");
	        			cn.setTableData("dealers",name[i]);
	        			i++;
	        		}
	        	}
	        }
			
        }catch(StaleElementReferenceException x) {
        	System.out.println("StaleElementReferenceException");
        	Thread.sleep(c.delay());
        }
                
		 //System.out.println("BestOption: "+name[0]);
		 return name[0];       


	}
	

	
}
