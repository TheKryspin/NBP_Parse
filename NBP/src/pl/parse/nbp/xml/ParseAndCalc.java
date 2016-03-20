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

	ArrayList<Double> kursy_licz;
	
    public Calendar Start,End;
    
    String StartYearP, EndYearP, StartStart;

    int StartMonth,StartDay,EndMonth,EndDay, EndYear, StartYear;
    
    public ParseAndCalc(int StartYear, int StartMonth, int StartDay, int EndYear, int EndMonth, int EndDay) {
    
    	this.StartStart =Integer.toString(StartYear);
    	
    	this.StartYearP = Integer.toString(StartYear).substring(2,4);
    	
    	this.EndYearP = Integer.toString(EndYear).substring(2, 4);  
    	
    	this.StartMonth = StartMonth; this.EndMonth = EndMonth;
    	
    	this.StartDay = StartDay; this.EndDay = EndDay;

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
    	
    	kursy_licz = new ArrayList<Double>();
    	
    	for (int i =0; i <XmlLinks.size() ; i++){
    	
    		URL url = new URL("http://www.nbp.pl/kursy/xml/"+XmlLinks.get(i)+".xml");
        
    		URLConnection connection = url.openConnection();
    
    		
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    		dbFactory.setIgnoringComments(true);
    		
    		dbFactory.setIgnoringElementContentWhitespace(true);
    		
   
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	
    		
    		Document doc = dBuilder.parse(connection.getInputStream());
    	
    		NodeList pozycje = doc.getElementsByTagName("pozycja");
    		
    		
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
    				String tempor = kursiki.item(0).getNodeValue().trim().replace(",", ".");
    				kursy_licz.add(Double.parseDouble(tempor));
    				System.out.println(kursiki.item(0).getNodeValue());
    			}
    		}
    	}
   
    
    
    }
    

 
    public void wszystkieKursy() {
    
    for(int i = 0 ; i < kursy_licz.size(); i++)
    {
    	System.out.println(Double.toString(kursy_licz.get(i)));
    	
    }
    
    }

    public double liczSrednia() {
    	
    	double suma = 0;
    	double srednia;
    	
    	for(int i = 0 ; i < kursy_licz.size(); i++)
    	    {
    			suma += kursy_licz.get(i);
    		
    	    }
    

    //	System.out.println(Double.toString(suma));
    	
    	
    	srednia = suma / kursy_licz.size();
    	
    	return srednia;
    }

    /**
     * 
     */
    public double liczOdchylenie(double srednia) {
    
    	double odchylenie = 0; 
    	double suma_temp = 0;
    	double temp = 0;
    	int mianownik =kursy_licz.size() - 1;
    	
    	
    	for(int i = 0; i < kursy_licz.size(); i++)
    	{
    		double roznica = (double)kursy_licz.get(i) - srednia;
    		
    		suma_temp += (double)(1.0/mianownik)*Math.pow(roznica,2); 
    		
    		
    	}
    	
    	odchylenie = Math.sqrt(suma_temp);
    		
    	return odchylenie;
    }
    
    public void showxml(){
    	
    	for(int i = 0; i < XmlLinks.size() ; i++)
    	{
    		
    		System.out.println(XmlLinks.get(i));
    		
    	}
    	
    }

    public void xmllinks() throws IOException 
    { 
    	this.EndYear = Integer.parseInt(EndYearP);
    	
    	this.StartYear = Integer.parseInt(StartYearP);
    	
    	int tmp = Integer.parseInt(StartStart); 
		
		for (int i = 0; i < (EndYear - StartYear +1);i++){
			
			String year = Integer.toString(tmp);
			
			URL text = new URL("http://www.nbp.pl/kursy/xml/dir"+year+".txt");
		
			BufferedReader in = new BufferedReader(
						new InputStreamReader(text.openStream()));
		
			String TmpString= null;
			
			
				while((TmpString = in.readLine()) !=  null )
				{
				
				int tmpy, tmpm,tmpd;
				

				tmpy = Integer.parseInt(TmpString.substring(5,7));
				
				tmpm = Integer.parseInt(TmpString.substring(7,9));
				
				tmpd = Integer.parseInt(TmpString.substring(9,11));
				
				if(TmpString.substring(0,1).equals("c")){
					
					 if(this.chech_cond(tmpy, tmpm, tmpd))
						{
						 	System.out.println(tmpy + " " + tmpm + " "+ tmpd);
										XmlLinks.add(TmpString);
							
							}
							
						}
				
						
		
	
		
		
		}
				
			tmp++;	
		}
    }
    
public boolean chech_cond (int tmpy, int tmpm, int tmpd)
{
	boolean a,b,c,d,e,f;
	
	a = tmpm >= StartMonth;
	
	
	e= tmpy <= EndYear;
	
	
	c = tmpm <= EndMonth;
	
	
	
	
	f=a&&c&&e;

	if(tmpm == StartMonth)
		
		{b = tmpd >= StartDay; return f&&b;}
	
	else if(tmpy == EndYear && tmpm == EndMonth)
		{d =  tmpd <= EndDay; return f&&d;}
		
		
	else{ return f;}
}	
}
    
