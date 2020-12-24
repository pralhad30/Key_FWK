package init;

import java.io.IOException;
import execute.*;
import setup.*;
import ui.UserInterface;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;



public class FileDemo
{
    public static void main(String args[]) throws Exception { 
    	
    	
    	Boolean iscommand = false;
    	
    	iscommand = args.length>0;
    	if (iscommand) {
        	execute();	
    		System.out.print("CMD IS Open");
    	}
    	else if (!iscommand) {
    		System.out.print("UI IS Open");
    		 UserInterface s =new UserInterface();
    	}
		    		
  }
    
    public static void execute() throws Exception
    {
    	Executioner e = new Executioner();
    	e.execute();
	}

    public static void setup() throws IOException
    {
    	Initiator i = new Initiator();
    	i.setupDir(); 
    	
    }
}


