package pl.parse.nbp.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 */
public class Panel extends JPanel {

	private String Choice;
	
    public Panel(String ChoicePanel) {
       
    	this.Choice = ChoicePanel;
    	
    	if(this.Choice == "top"){
    		this.setSize(400, 200);
    		
    		FlowLayout toplay = new FlowLayout();
    		
    		toplay.preferredLayoutSize(this);
    		
    		toplay.setVgap(40);
    		
    		this.setLayout(toplay);
    		
    		}
    	else if(this.Choice == "middle"){
    		this.setSize(400,100);
    		
    		FlowLayout middlelay = new FlowLayout();
    		
    		middlelay.preferredLayoutSize(this);
    		
    		middlelay.setHgap(50);
    		
    		middlelay.setVgap(30);
    		
    		this.setLayout(middlelay);
    		
    	}
    	else if(this.Choice == "bottom"){
    		this.setSize(400,200);
    		
    		
    	}
    }

    @Override
    public void paintComponent(Graphics g){
    	
    	if(this.Choice == "top"){
    		Image top = new ImageIcon("nbp_gui/top.jpg").getImage();
    		g.drawImage(top, 0, 0, this);
    		}
    	else if(this.Choice == "middle"){
    		Image middle = new ImageIcon("nbp_gui/middle.jpg").getImage();
    		g.drawImage(middle, 0, 0, this);
    			
    		}
    	else if(this.Choice == "bottom"){
    		Image bottom = new ImageIcon("nbp_gui/bottom.jpg").getImage();
    		g.drawImage(bottom, 0, 0, this);
    	}
    }
}