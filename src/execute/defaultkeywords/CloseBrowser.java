package execute.defaultkeywords;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import defaultkeywords.Keyword;
import defaultkeywords.keywordinfo;
import execute.defaultkeywords.*;
import defaultkeywords.*;




@keywordinfo("close_Browser")
public class CloseBrowser extends Keyword
  {

	public CloseBrowser(WebDriver driver,ArrayList<String> input,ArrayList<TestStepReport> reportList) {
		super(driver,input,reportList);
		
		
	}
	
	
 public boolean run()
	 {
	    System.out.println("Keyword is :" + "close_browser");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		
	    this.driver.quit();				
		try {
			Thread.sleep(2000);
			this.driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
