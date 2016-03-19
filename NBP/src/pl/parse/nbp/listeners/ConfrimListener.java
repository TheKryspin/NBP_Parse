package pl.parse.nbp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JOptionPane;

import pl.parse.nbp.gui.*;
import pl.parse.nbp.xml.ParseAndCalc;
/**
 * 
 */
public class ConfrimListener implements ActionListener {

	private Calendar start;
	
	private String Start;
    
	
    private Calendar end;
    
    private String End;
    
    
    private String Value;
    
    GuiBuilder dostep;
    
    public ConfrimListener(GuiBuilder build) {
    	
    	dostep = build;
    	
    	
    	start = Calendar.getInstance();
    	
    	end = Calendar.getInstance();
    	
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Start = dostep.getTextField("start").getText();

		int StartYear = Integer.parseInt(Start.substring(0, 4));
    	
    	int StartMonth = Integer.parseInt(Start.substring(5,7));
    	
    	int StartDay = Integer.parseInt(Start.substring(8,10));


		End = dostep.getTextField("end").getText();
    
    	
    	int EndYear = Integer.parseInt(End.substring(0, 4));
		
    	int EndMonth = Integer.parseInt(End.substring(5,7));
    	
    	int EndDay = Integer.parseInt(End.substring(8,10));
    	

    	
		if(this.check(StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay)){
		    	
    	start.set(StartYear, StartMonth, StartDay);
    	
    	end.set(EndYear, EndMonth, EndDay);
    	
    	Value = dostep.getTextField("value").getText();
    	
    	ParseAndCalc parsing = new ParseAndCalc(start, end);
    	
    	
  
		}else { dostep.getTextArea().setText("\n\nZLY FORMAT - POPRAWNY TO \n"+" OD: yyyy-mm-dd"
				+ "\n DO: yyyy-mm-dd \n WALUTA: USD, EUR, CHF, GBP"); }
    	
    	
	}

  public boolean check(int StartYear, int StartMonth, int StartDay, int EndYear, int EndMonth, int EndDay){
	  
	  String waluta = dostep.getTextField("value").getText();
	
	  
	  if(waluta.equals("USD") || waluta.equals("EUR") || waluta.equals("GBP") || waluta.equals("CHF"))
	  {
		  
		  if(Start.substring(4,5).equals("-") && End.substring(4,5).equals("-") && Start.substring(7,8).equals("-") && End.substring(7,8).equals("-"))
		  {
			  if( (StartYear > 2001) && (StartYear < 2017) && (StartMonth > 0) && StartMonth < 13 &&
				StartDay > 0 && StartDay < 32) 
				{
				  if((EndYear > 2001) && (EndYear < 2017) && (EndMonth > 0) && EndMonth < 13 &&
				EndDay > 0 && EndDay < 32)
				  {
					  if(StartYear > EndYear)
					  {
						  JOptionPane.showMessageDialog(null, "Rok poczatkowy wiekszy niz koncowy");
						  return false;
						
						  }else
						  {
							if (StartYear == EndYear && StartMonth > EndMonth)
							{
								  JOptionPane.showMessageDialog(null, "Ustaw wiekszy miesiac koncowy");
								  return false;
								
							}
							else
							{
								if(StartYear == EndYear && StartMonth == EndMonth && StartDay > EndDay)
								{
									JOptionPane.showMessageDialog(null, "Ustaw wiekszy dzien koncowy");
									return false;
									
									
									
								}else{return true;}
							}
						  }
						  
						  
					  }else
					  {
						  JOptionPane.showMessageDialog(null, "Rok poczatkowy musi byc wiekszy niz koncowy");;
						  return false;
					  }
					  
				  }else
				  {
					  JOptionPane.showMessageDialog(null, "Blad w dacie koncowe");
					  return false;
				  }
				  
				}
			  else
			  {
				  JOptionPane.showMessageDialog(null, "Blad w formacie daty poczatkowej");
				  return false;
			  }
			  
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null, "ZLY FORMAT. Pamietaj o -");
			  return false;
		  }
	  }
  
	 
  }

