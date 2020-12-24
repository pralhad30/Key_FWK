package execute;
import defaultkeywords.*;
import execute.defaultreports.HTMLReportGenerator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.reflections.Reflections;

public class Testcase_Runner {	
	
	
	public void runCommand(ArrayList<ArrayList<String>> command) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver_87.exe");
		WebDriver driver=new ChromeDriver();
		Keyword k2 = null;
		Class<?> c = null;
		ArrayList<String> ip = new ArrayList<>();
		String default_keyword_package = "execute.defaultkeywords.";
		
		HashMap<String,String> keywordMap = new HashMap<>();
		//keywordMap.put("close_browser", "CloseBrowser");
		Reflections reflections = new Reflections(default_keyword_package);
		
		
		//Set<Class<? extends Keyword>> annotatedclassname = 
		//           reflections.getSubTypesOf(Keyword.class);*/
		//System.out.println("Reflection output :" + reflectsoutput);
		
		Set<Class<?>> annotatedclassname = 
		           reflections.getTypesAnnotatedWith(keywordinfo.class);
		//System.out.println("Class Names of Annotations :" + annotatedclassname);
		
		for(Class<?> t  : annotatedclassname )
		{
			
			
		for (Annotation annotation : t.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            

            for (Method method : type.getDeclaredMethods()) {
                Object value = method.invoke(annotation, (Object[])null);
               
                String annot_key =  (String) value ;                           
                String keyClass = t.toString().substring(30);
                keywordMap.put(annot_key.toLowerCase(),keyClass);
                System.out.println("KeywordMap_data:" + keywordMap);
               
               
            }
        }
		}
		
		ArrayList<TestStepReport> reportList = new ArrayList<>();
		HTMLReportGenerator reportGenerator = new HTMLReportGenerator(reportList);
		
		for (int i = 0; i < command.size() ; i++) 
		  { 
			for( int j =0;j < command.get(i).size();j++)
			 {	
					
				for(int k = 1; k<command.get(i).size(); k++)
				{
					ip.add((command.get(i).get(k)));
				}
			    String s = command.get(i).get(j) ; 
				if( s != null) {	
					
					String _s = s.toLowerCase().trim();	
					
					String className =  keywordMap.get(_s);
			
					if(className!=null)
					{
					c = Class.forName(default_keyword_package + className);
					Constructor<?> cons = c.getConstructor(WebDriver.class,ArrayList.class,ArrayList.class);
					k2 = (Keyword)cons.newInstance(driver,ip,reportList);
					System.out.println(k2);
					k2.start();

						}
					}
				else
				{
					throw new Exception();
				}
				
		      
	             }
			System.out.println();
		}
		
		   reportGenerator.generateReport();
		}
		
	}	
	
	
	



