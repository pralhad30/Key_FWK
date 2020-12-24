package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestCaseParser {
	

	Executioner e;	
	String FILE_XML_NAME = "NewFile.xml";
	String Path;
	
	public TestCaseParser(Executioner e) {
		this.e = e;
		Path = this.e.root + "/Test_data/";
	}
	

 
	private HashMap<String,Boolean> getFileMap() throws ParserConfigurationException, SAXException, IOException
	{
		
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();

				Document document = builder.parse(new File(FILE_XML_NAME));

				NodeList nodeList = document.getDocumentElement().getChildNodes();
				HashMap<String,Boolean> hm= new HashMap<String,Boolean>();
				for (int i = 0; i < nodeList.getLength(); i++)
				{
					Node node = nodeList.item(i);

					if (node.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elem = (Element) node;						
						String flag_S = elem.getElementsByTagName("Flag").item(0).getChildNodes().item(0).getNodeValue();
						String fileName = elem.getElementsByTagName("File").item(0).getChildNodes().item(0).getNodeValue();
						boolean Flag = Boolean.parseBoolean(flag_S);						 
						hm.put(fileName,Flag);						
						System.out.println("Hashmap output is:"+hm.get(fileName));					
						
					}
				 }
			     return hm;
			   }
	
	@SuppressWarnings("null")
	private ArrayList<ArrayList<String>> csv_read_data(String FileName, boolean _isActive) throws ParserConfigurationException, SAXException, IOException {
		   
		ArrayList<ArrayList<String>> csv_data = new ArrayList<ArrayList<String>>();
				if(_isActive)
				{
				File directory = new File(Path);
				if (directory.exists()) {
					System.out.println(Path + " already exists ...");
						File f = new File(Path + FileName);						
						if (f.exists()) {
							try {
								
								FileReader fileReader = new FileReader(f);								
								BufferedReader bufferedReader = new BufferedReader(fileReader);
								String temp = null;								
							
								
							  while ((temp = bufferedReader.readLine()) != null)
							       {
									ArrayList<String> fileData = new ArrayList<String>();	
									   //Collections.addAll(fileData, temp.split(","));
									   fileData.addAll(Arrays.asList(temp.split(",")));
										csv_data.add(fileData);									   
										System.out.println(fileData);

								   }									
								bufferedReader.close();								
							} 
							catch (IOException ex) {
								System.out.println("Error reading file named '" + f + "'");
							}
						}
						else 
						{
							System.out.println("Input CSV Not exists");
							System.exit(0);

						}
						
				       }
				    }
				return csv_data;
			}
	
	public ArrayList<ArrayList<String>> csvReader() throws ParserConfigurationException, SAXException, IOException 
	{
		HashMap<String,Boolean> _map = this.getFileMap();
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		for(String FileName : _map.keySet())
		{
			Boolean _isActive = _map.get(FileName);
			if(_isActive)
			{
				ArrayList<ArrayList<String>> _data = csv_read_data(FileName, _isActive);
				data.addAll(_data)
;				/* new function which will take the file path as input and give ArrayList<ArrayList<String>> as output*/
			}
		}
		return data;
	}
	
	

}
