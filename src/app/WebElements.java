package app;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import db.ConnectionDB;
import pages.Flights;
import pages.Home;

public class WebElements {
	
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		WebDriver driver = new ChromeDriver();
		Constants c = new Constants(); // call desired selectors 
		Step1 obj = new Step1(driver); // get page object logic
		Flights x1 = new Flights(driver); //get page object logic
		ConnectionDB cn = new ConnectionDB();
		obj.run(c.base_uri); // open url
		Home ins = new Home(driver);
		Utils u = new Utils();
		ins.search_xpath(c.home_title,"Welcome!"); // verify presence of site
		x1.doClick(c.close_element); // clear origin field
		x1.search_xpath(c.from,"Canberra"); // origin
		x1.search_xpath(c.to,"Sydney"); // destination
		x1.select_trip(c.trip, "Return"); //type of trip
		x1.doClick(c.people); // add people
		x1.select_people(c.adult); //add extra adult 
		x1.select_people(c.children); // add one kid
		x1.select_people(c.children); // add one more kid
		x1.doClick(c.click_search); // a list of results will return
		obj.run(x1.bestOption()); // the best option will be choose
        Thread.sleep(2000); 
        u.getSreenShoot(driver); //print screen
		driver.quit(); //end
		cn.getTableList("dealers"); //print info from table in database
        
	}

}

