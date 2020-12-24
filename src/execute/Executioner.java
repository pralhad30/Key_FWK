package execute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;


public class Executioner {
	
	String root;
	public Executioner()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter root directory ");
		root = reader.nextLine();
		reader.close();

	}
	
	public Executioner(String root)
	{
		this.root = root;
	}
	public void execute() throws Exception
	{

		TestCaseParser tp = new TestCaseParser(this);
		ArrayList<ArrayList<String>> data =  tp.csvReader();
		Testcase_Runner tr = new Testcase_Runner();
		tr.runCommand(data);
	}


	
}




