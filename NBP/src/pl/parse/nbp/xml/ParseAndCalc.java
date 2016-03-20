package pl.parse.nbp.xml;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseAndCalc {

	ArrayList<String> XmlLinks;

	ArrayList<Float> kursy;
	
    public Calendar Start,End;

    public ParseAndCalc(Calendar Start, Calendar End) {
    
    	this.Start = Start;
    	
    	this.End = End;
    	

		this.XmlLinks = new ArrayList<String>();
		
    	
    	try {
			this.xmllinks();
			
			this.showxml();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


    public void pobierzKurs(String Value) throws Exception {
    	
    	kursy = new ArrayList<Float>();
    	
    	for (int i =0; i <XmlLinks.size() ; i++){
    	
    		URL url = new URL("http://www.nbp.pl/kursy/xml/"+XmlLinks.get(i)+".xml");
        
    		URLConnection connection = url.openConnection();
    
    		
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    		dbFactory.setIgnoringComments(true);
    		
    		dbFactory.setIgnoringElementContentWhitespace(true);
    		
   
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	
    		
    		Document doc = dBuilder.parse(connection.getInputStream());
    	
    		System.out.println(" Root element  " + doc.getDocumentElement().getNodeName());
    		
    		NodeList pozycje = doc.getElementsByTagName("pozycja");
    		
    		System.out.println("ILE POZYCJI  " + pozycje.getLength());
    		
    		for (int j =0 ; j < pozycje.getLength(); j++)
    		{
    			
    			Node temp = pozycje.item(j);
    			
    			Element GetInside = (Element) temp;
    			
    			NodeList kursy = GetInside.getElementsByTagName("kurs_kupna");
    			
    			Element kursy_walut = (Element) kursy.item(0);
    			
    			NodeList kursiki = kursy_walut.getChildNodes();
    			
    			NodeList lista_walut = GetInside.getElementsByTagName("kod_waluty");
    			
    			Element kody = (Element) lista_walut.item(0);
    			
    			NodeList kod =  kody.getChildNodes();
    			
    			if(kod.item(0).getNodeValue().equals(Value))
    			{
    				System.out.println(kursiki.item(0).getNodeValue());
    			}
    		}
    	}
   
    
    
    }
    

 
    public void wszystkieKursy() {
    
    for(int i = 0 ; i < kursy.size(); i++)
    {
    	System.out.println(Float.toString(kursy.get(i)));
    	
    }
    
    }

    /**
     * 
     */
    public void liczSrednia() {

    
    }

    /**
     * 
     */
    public void liczOdchylenie() {
    
    }
    
    public void showxml(){
    	
    	for(int i = 0; i < XmlLinks.size() ; i++)
    	{
    		
    		System.out.println(XmlLinks.get(i));
    		
    	}
    	
    }

    public void xmllinks() throws IOException 
    { 
    	
    	Calendar tmp = Start;
		
		for (int i = 0; i < ((End.get(Calendar.YEAR) - Start.get(Calendar.YEAR))+1);i++){
			
		URL text = new URL("http://www.nbp.pl/kursy/xml/dir"+tmp.get(Calendar.YEAR)+".txt");
		
		BufferedReader in = new BufferedReader(
			    new InputStreamReader(text.openStream()));
		
		String TmpString= null;
		
		while((TmpString = in.readLine()) != null ){	
		
			if(End.get(Calendar.MONTH) >= Integer.parseInt(TmpString.substring(7,9))  
					&&  End.get(Calendar.DAY_OF_MONTH) >= (Integer.parseInt(TmpString.substring(9,11)))) {
				if( Integer.parseInt(TmpString.substring(7,9)) >= Start.get(Calendar.MONTH)
					&& Integer.parseInt(TmpString.substring(9,11)) >= Start.get(Calendar.DAY_OF_MONTH)){
			if(TmpString.substring(0,1).equals("c"))
			{
				XmlLinks.add(TmpString);
		
			}
			
			}
		
			}
	}
			
			
		
		
		
		
		
		
		}
    }
    
}