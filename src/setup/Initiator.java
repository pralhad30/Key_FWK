package setup;
import java.io.File;
import java.io.IOException;
import execute.*;
import java.util.Scanner;



public 	class Initiator {
	
	boolean success = false;
	 String userDir ;
	 String Test_Data =  "/Test_data/";
	 String Test_Cases =  "/Test_Cases/";
	 String Reports = "/Reports/";
	 
	 String[] dirNames = {"",Test_Cases,Test_Data,Reports};
   String[] fileCheck = {"C:/Webdriver/chromedriver.exe"};

	
	public Initiator()
	{
	  	 Scanner reader = new Scanner(System.in);
	   	 System.out.println("Enter path of directory to create");

		  userDir = reader.nextLine();	
	     reader.close();
	}
	
	public Initiator(String userDir)
	{
		this.userDir = userDir;
	}
	
	
	public Executioner GetExecutioner()
	{
		return new Executioner(userDir);
	}
		
	 
    public void setupDir() throws IOException { 	
    	
 
    	 
         	
 		 
    	 
       // Root and Test Folder Exist Check,Create if it doesn't exists
        
        for (int  i = 0; i < dirNames.length; i++) 
         {
	        File directory = new File(userDir + dirNames[i]);
	        if (directory.exists()) {
	            System.out.println(dirNames[i]+" Directory already exists ...");
	            
	
	        } else {
	            System.out.println(dirNames[i]+" Directory not exists, creating now");
	            
	            success = directory.mkdir();
	            if (success) {
	                System.out.printf("Successfully created new directory : %s%n", directory);
	                
	            } else {
	                System.out.printf("Failed to create new directory: %s%n", directory);
	            }
	        }
        }
             
        for (int  i = 0; i < fileCheck.length; i++) {             
        File f = new File(fileCheck[i]);
        if (f.exists()) {
            System.out.println(fileCheck[i]+ " already exists");

        } else {
            System.out.println(fileCheck[i]+" Not exists");
            
        }

        }   
        
    }
}

