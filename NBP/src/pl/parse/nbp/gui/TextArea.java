package pl.parse.nbp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {
	
	public TextArea(){
		
		this.setPreferredSize(new Dimension(350,150));
		
		this.setEditable(false);
		
		this.setBorder(null);
		
		Font f = new Font("Segoe UI Light", 1, 12);
		
		this.setFont(f);
		
		this.setForeground(Color.WHITE);
		
		this.setCaretColor(Color.WHITE);
		
		this.setOpaque(false);
		
		
	}

}
