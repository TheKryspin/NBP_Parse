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
    
    private boolean StartCorrect, EndCorrect, ValueCorrect;
    
    GuiBuilder dostep;
    
    public ConfrimListener(GuiBuilder build) {
    	
    	dostep = build;
    	
    	
    	start = Calendar.getInstance();
    	
    	end = Calendar.getInstance();
    	
    	
    	StartCorrect = EndCorrect = ValueCorrect = false;
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Start = dostep.getTextField("start").getText();
    	System.out.println(Start);
    	
    	
    	
		End = dostep.getTextField("end").getText();
    	System.out.println(End);
	
    	Value = dostep.getTextField("value").getText();
    

    	int StartYear = Integer.parseInt(Start.substring(0, 4));
		
    	int StartMonth = Integer.parseInt(Start.substring(5,7));
    	
    	int StartDay = Integer.parseInt(Start.substring(8,10));
    	
    	//System.out.println(Integer.toString(StartYear) + "-" +Integer.toString(StartMonth)+ "-" +Integer.toString(StartDay));
    	
    	start.set(StartYear, StartMonth, StartDay);
    
    	
    	int EndYear = Integer.parseInt(End.substring(0, 4));
		
    	int EndMonth = Integer.parseInt(End.substring(5,7));
    	
    	int EndDay = Integer.parseInt(End.substring(8,10));
    	
    	end.set(EndYear, EndMonth, EndDay);
    	
    	
    	
    	
	}

  

}