package pl.parse.nbp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.parse.nbp.gui.*;
/**
 * 
 */
public class ClearListener implements ActionListener {

    GuiBuilder dostep;
    public ClearListener(GuiBuilder build) {
        
    	dostep = build;
    }
    
    @Override
	public void actionPerformed(ActionEvent arg0) {
    	
    	//-------------CZYSZCZENIE POL TEKSTOWYCH------------
    	dostep.getTextField("start").setText(null);
    	
    	dostep.getTextField("end").setText(null);
    	
    	dostep.getTextField("value").setText(null);
    	
    	dostep.getTextArea().setText(null);
		
	}

}