package pl.parse.nbp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.*;

import javax.swing.JTextField;


public class TextField extends JTextField {

private String Choice; 

    public TextField(String ChoiceTextField) {
      
    	this.Choice = ChoiceTextField;
    	
    	if(this.Choice == "Data"){
    		
    		this.setPreferredSize(new Dimension(200,30));
    		
    		this.setEditable(true);
    		
    		this.setBorder(null);
    		
    		this.setHorizontalAlignment(CENTER);
    		
    		Font f = new Font("Segoe UI Light", 1, 20);
    		
    		this.setOpaque(false);
    		
    		this.setForeground(Color.WHITE);
    		
    		this.setCaretColor(Color.WHITE);
    		
    		this.setFont(f);
    		
    	}
    	else if(this.Choice =="Wynik"){
    		
    		this.setPreferredSize(new Dimension(350,150));
    		
    		this.setEditable(false);
    		
    		this.setBorder(null);
    		
    		Font f = new Font("Segoe UI Light", 1, 20);
    		
    		this.setFont(f);
    		
    		this.setForeground(Color.WHITE);
    		
    		this.setCaretColor(Color.WHITE);
    		
    		this.setOpaque(false);
    		
    	}	else if(this.Choice =="Waluta"){
    		
    		this.setPreferredSize(new Dimension(35,35));
    		
    		this.setEditable(true);
    		
    		this.setBorder(null);
    		
    		Font f = new Font("Segoe UI Light", 1, 17);
    		
    		this.setForeground(Color.WHITE);
    		
    		this.setCaretColor(Color.WHITE);
    		
    		
    		this.setFont(f);
    		
    		this.setOpaque(false);
    		
    		
    		
    	}
   
    }

}