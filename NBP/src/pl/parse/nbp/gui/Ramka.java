package pl.parse.nbp.gui;

import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JFrame;

/**
 * 
 */
public class Ramka extends JFrame {


	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ramka() {
    	
    	this.setSize(new Dimension(400,450));
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 
    	this.setName("NBP PARSER by KRYSTIAN STEMPLEWSKI");
    
    	this.setResizable(false);
    	
    	GridLayout main = new GridLayout();
    	
    	main.setRows(3);
    	
    	main.setColumns(1);
    	
    	main.preferredLayoutSize(this);
    	
    	this.setLayout(main);
    	
    	
    }

    


}