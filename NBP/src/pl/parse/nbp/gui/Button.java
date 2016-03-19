package pl.parse.nbp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 */
public class Button extends JButton {

 private String ChoiceButton;

    public Button(String ChoiceButton) {

    	this.ChoiceButton= ChoiceButton;
    	
    	if(this.ChoiceButton == "Confirm")
    	{
    		this.setPreferredSize(new Dimension(100,50));
    		
    		this.setBorder(null);
    		
    		
    	}
    	else if(this.ChoiceButton == "Clear")
    	{
    		this.setPreferredSize(new Dimension(100,50));
    		
    		this.setBorder(null);
    		
    	}
    	
    }

    @Override
    public void paintComponent(Graphics g)
    {
    	
    	if(this.ChoiceButton == "Confirm")
    	{
    		Image confirm = new ImageIcon("nbp_gui/licz.jpg").getImage();
    		g.drawImage(confirm, 0, 0, this);
    	}
    	else if(this.ChoiceButton == "Clear")
    	{
    		Image clear = new ImageIcon("nbp_gui/clear.jpg").getImage();
    		g.drawImage(clear, 0, 0, this);
    		
    	}
    	
    }
    
}