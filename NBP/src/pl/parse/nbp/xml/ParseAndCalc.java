package pl.parse.nbp.xml;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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


    public int pobierzKurs(int TmpData) {
        // TODO implement here
        return 0;
    }

 
    public void wszystkieKursy() {
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
		
		String TmpString;
		
		while((TmpString = in.readLine()) != null ){	
		
			if(Integer.parseInt(TmpString.substring(7,9)) <= 
				End.get(Calendar.MONTH) && (Integer.parseInt(TmpString.substring(9,11)) <= 
				End.get(Calendar.DAY_OF_MONTH)) && Integer.parseInt(TmpString.substring(7,9)) >= Start.get(Calendar.MONTH)
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