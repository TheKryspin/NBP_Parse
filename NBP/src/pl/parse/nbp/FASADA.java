package pl.parse.nbp;

import pl.parse.nbp.gui.*;
import pl.parse.nbp.listeners.*;


/**
 * 
 */
public class FASADA {

	private GuiBuilder build;

    private ConfrimListener confirm;
    
    private ClearListener clear;
    

    
    public FASADA() {
    	
    	build = new GuiBuilder();
    	
    	confirm = new ConfrimListener(build);
    	
    	clear = new ClearListener(build);
    	
         	build.getButton("confirm").addActionListener(confirm);
         	
         	build.getButton("clear").addActionListener(clear);
         	
    
    }



    public void gui_start() {

    	build.buildGui();
    	
    	
    }

}