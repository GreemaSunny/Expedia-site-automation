package test;

import org.testng.annotations.Test;

import page.Expediasearchpage;

public class Expediasearchtest extends Baseurl {
	@Test
	public void flightsearch1() throws Exception {
		Expediasearchpage ob=new Expediasearchpage(driver);	
		ob.tabclick();
		
		ob.setvalues("Brusels","New York");
		ob.selecteconomy();
		ob.selecttravelers("3");
		ob.selectdates("July 2023", "20","September 2023","28");
		ob.searchflights();
	}
	}
