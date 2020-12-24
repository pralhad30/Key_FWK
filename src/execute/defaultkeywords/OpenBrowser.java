package execute.defaultkeywords;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

import defaultkeywords.Keyword;
import defaultkeywords.keywordinfo;
import execute.defaultkeywords.*;
import defaultkeywords.*;


@keywordinfo("open_Browser")
 public class OpenBrowser extends Keyword
   {

	public OpenBrowser(WebDriver driver, ArrayList<String> input,ArrayList<TestStepReport> reportList) {
		super(driver,input,reportList);
		
		}
	
	
	public boolean run()
	{
	    System.out.println("Keyword is :" + "open_browser");
		this.driver.navigate().to(input.get(0));				
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
