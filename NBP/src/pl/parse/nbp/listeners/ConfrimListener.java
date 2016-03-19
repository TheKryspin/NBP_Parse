package pl.parse.nbp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import pl.parse.nbp.gui.*;
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
    	
    	int counter = start.compareTo(end);
    	
		}else { dostep.getTextArea().setText("\n\nZLY FORMAT - POPRAWNY TO \n"+" OD: yyyy-mm-dd"
				+ "\n DO: yyyy-mm-dd \n WALUTA: USD, EUR, CHF, GBP"); }
    	
    	
	}

  public boolean check(int StartYear, int StartMonth, int StartDay, int EndYear, int EndMonth, int EndDay){
	  
	  String waluta = dostep.getTextField("value").getText();
	  
	  if(Start.substring(4,5) != "-" || Start.substring(7,8) != "-" || StartYear < 2002 || StartYear > 2016 
			  || StartMonth < 1 || StartMonth > 12 || (StartDay < 1 || StartDay > 31) || EndYear < StartYear 
			  || (EndYear < StartYear && EndMonth < StartMonth && EndDay<StartDay) || EndYear > 2016 ||
			  EndMonth > 12 || EndMonth < 0 || EndDay < 1 || EndDay > 31 || waluta != "USD" 
			  || waluta != "EUR" || waluta !="GBP" || waluta != "CHF")
              {return false; }
	  else { return true; }
	 
  }

}