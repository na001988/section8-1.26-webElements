package app;

public class Constants {
	
	static int delay = 1500;
	
	static String us = "operator";
	
	static String ps = "operator";
	
	static String mydb = "jdbc:mysql://localhost:3306/automation";
	
	String base_uri="https://www.kayak.com.au";
	
	String home_title="//h2[@class=\"title dark\"]";
	
	String trip="//select[@class=\"wIIH-fake-select\"]";
	
	String people="//div[@class=\"S9tW S9tW-pres-default\"]";
	
	String adult="div.u9Xa:nth-child(1) > div:nth-child(2) > button:nth-child(3)";
	
	String children="div.u9Xa:nth-child(4) > div:nth-child(2) > button:nth-child(3)";
	
	String from="//input[@placeholder=\"From?\"]";
	
	String to="//input[@placeholder=\"To?\"]";
	
	String close_element="//div[@class=\"vvTc-item-button\"]";
	
	String click_search="//div[@class=\"zEiP-formField zEiP-submit\"]";
	
	public int delay() {
		return delay;
	}
	
	public String us() {
		return us;
	}
	
	public String ps() {
		return ps;
	}
	
	public String url() {
		return mydb;
	}	
	
}
