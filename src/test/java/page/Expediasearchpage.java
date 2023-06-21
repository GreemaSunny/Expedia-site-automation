package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expediasearchpage {

	WebDriver driver;
	By flighttabb=By.xpath("//*[@id='multi-product-search-form-1']/div/div/div[1]/ul/li[2]/a/span");
	By leavingfrom=By.xpath("//button[@aria-label='Leaving from']");
	By leavingfield=By.xpath("//*[@id='origin_select']");
	By goingto=By.xpath("//*[@id='destination_select-menu']/div/div/div[1]/button");
	By goingfield=By.xpath("//*[@id='destination_select']");
	
	By travelers=By.xpath("//button[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']");
	By increaseadult=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[3]/div/div[2]/div/div/section/div[1]/div/div/button[2]");
	By increasechild=By.xpath("//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[3]/div/div[2]/div/div/section/div[2]/div[1]/div/button[2]");
	By childage=By.xpath("//select[@id='age-traveler_selector_children_age_selector-0']");
	By Donebutton=By.xpath("//button[@id='travelers_selector_done_button']");
	
	By Economy=By.xpath("//*[@id='cabin_class']");
	By firstclass=By.xpath("//*[@id='cabin_class_menu']/div/div/button[4]/span");
	
	By date=By.xpath("//button[@id='date_form_field-btn']");
	By Dmonthjuly=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/h2");
	By arrow=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/button[2]");
	By Ddates=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
	By rmonthsep=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/h2");
	By rdates=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
	By datedone=By.xpath("//*[@id='FlightSearchForm_ROUND_TRIP']/div/div[2]/div/div/div/div[2]/div/div[2]/div/button");
	
	By Search=By.xpath("//*[@id='search_button']");
	
	public Expediasearchpage(WebDriver driver) {
		this.driver=driver;
	}
	public void tabclick() {
		driver.findElement(flighttabb).click();	
		}
	public void setvalues(String Leaving,String going) throws Exception  {
		Thread.sleep(3000);
		driver.findElement(leavingfrom).click();
		driver.findElement(leavingfield).sendKeys(Leaving,Keys.ENTER);
		
	driver.findElement(goingto).click();
	driver.findElement(goingfield).sendKeys(going,Keys.ENTER);
	
	}
	public void selecttravelers(String agevalue) throws Exception {
		driver.findElement(travelers).click();
	 Thread.sleep(3000);
	
	driver.findElement(increaseadult).click();
		driver.findElement(increasechild).click();
		Thread.sleep(3000);
		WebElement agechild=driver.findElement(childage);
		agechild.click();
		Select ageelement=new Select(agechild);
		ageelement.selectByValue(agevalue);
		driver.findElement(Donebutton).click();
	
		}
	public void selecteconomy() throws Exception {
		
		driver.findElement(Economy).click();
		Thread.sleep(3000);	
		driver.findElement(firstclass).click();
		
	}
	public void selectdates(String depmonth,String depdate,String retmonth,String retdate) throws Exception {
		driver.findElement(date).click();
		
		//departure date selection
		while(true) {
		String month1=driver.findElement(Dmonthjuly).getText();
		System.out.println(month1);
		if(month1.equals(depmonth)) {
			System.out.println(month1);
			break;
		}else {
			driver.findElement(arrow).click();;
		}
		}
		List<WebElement>alldates1=driver.findElements(Ddates);
		for(WebElement dateelement1:alldates1) {
			String date=dateelement1.getAttribute("data-day");
			System.out.println(date);
			if(date.equals(depdate)) {
				System.out.println(date);
				dateelement1.click();
				System.out.println("date selected"); 
				break;
			}
		}Thread.sleep(3000);	
		
		//returning date selection
		while(true) {
			String month2=driver.findElement(rmonthsep).getText();
			System.out.println(month2);
			if(month2.equals(retmonth)) {
				System.out.println(month2);
				break;
			}else {
				driver.findElement(arrow).click();;
			}
			}
			List<WebElement>alldates2=driver.findElements(rdates);
			for(WebElement dateelement2:alldates2) {
				String date=dateelement2.getAttribute("data-day");
				System.out.println(date);
				if(date.equals(retdate)) {
					System.out.println(date);
					dateelement2.click();
					System.out.println("date selected"); 
					break;
				}Thread.sleep(3000);	
			}driver.findElement(datedone).click();
		
		}
	
	public void searchflights() {
		driver.findElement(Search).click();;
	}
	}
	

