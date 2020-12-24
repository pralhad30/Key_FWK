package execute.defaultreports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import defaultkeywords.ReportGenerator;
import defaultkeywords.TestStepReport;


public class HTMLReportGenerator extends ReportGenerator {
	


	public HTMLReportGenerator(ArrayList<TestStepReport> reportList) {
		super(reportList);		

	}
	

public void generateReport() throws IOException {
	
	
	 String Header= "<html>\n"+
			 "<style>"+
	          "table, th, td {" +
	          " border: 1px solid black;" +
	          " }" +
	          "</style>" +
	          "<body>\n"+
	 		  "<table style='width:100%'>";	 
	 String Footer ="</table>\n"+
					 "</body>\n"+
					  "</html>\n";	 
	 String Body ="<caption>TEST Report</caption><tr><th>Keywordname</th><th>Result</th><th>StartTime</th><th>EndTime</th></tr>";
	 
	 
	 for (int i = 0; i < reportList.size() ; i++) 
	  { 
		 Body+="<tr><td>"+reportList.get(i).keywordname+"</td>" +"<td>"+reportList.get(i).result+"</td>"+"<td>"+reportList.get(i).startdate+"</td>"+"<td>"+reportList.get(i).enddate+"</td></tr>\n";
		 System.out.println("Body is"+Body);
	  }
	 String Finalreport = Header+"\n"+ Body+Footer;
	 File f = new File("C:\\Root\\Reports\\htmlReport.html");
     BufferedWriter filewriter = new BufferedWriter(new FileWriter(f));
     filewriter.write(Finalreport);
     filewriter.close();
  }
	
}
