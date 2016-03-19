package pl.parse.nbp.gui;

import java.util.*;



/**
 * 
 */
public class GuiBuilder {

    private Ramka Frame;

    private Panel TopPanel;
    private Panel MiddlePanel;
    private Panel BottomPanel;
    
    private Button ConfirmButton;
    private Button ClearButton;
   
    private TextField DataStart;
    private TextField DataEnd;
    private TextField Show;
    private TextField Waluta;

    
	public GuiBuilder() {
		//Tworzenie komponentów
		//G³ówna ramka
		Frame = new Ramka();
		
		//-------------Panele----------------------------
			TopPanel = new Panel("top");
		
			MiddlePanel = new Panel("middle");
		
			BottomPanel = new Panel("bottom");
			
		//-------------Przyciski--------------------------
				ConfirmButton = new Button("Confirm");
		
				ClearButton = new Button("Clear");
				
	
		//-------------Pola do wprowadzania i wyswietlania------------		
					DataStart = new TextField("Data");
					
					DataEnd = new TextField("Data");
	
					Show = new TextField("Wynik");
	
					Waluta = new TextField("Waluta");
	}

   
		public void buildGui() {
	//---Dodanie komponentow do paneli
				
				//---------------TOP----------------
					TopPanel.add(DataStart);
			
					TopPanel.add(DataEnd);
				
    
				//-------------MIDDLE---------------
				
					MiddlePanel.add(Waluta);
					
					MiddlePanel.add(ConfirmButton);
				
					MiddlePanel.add(ClearButton);
				
				//-------------BOTTOM----------------	
					BottomPanel.add(Show);
				
			  
			//-----------------DODANIE DO RAMKI
			  Frame.add(TopPanel);
			
			  Frame.add(MiddlePanel);
			
			  Frame.add(BottomPanel);

			 //-------------------USTAWIENIE WIDOCZNOSCI I ODMALOWANIE
			Frame.setVisible(true);
			
			Frame.repaint();
			
        }
		
		public Button getButton(String which){
			
			try{
			if(which == "confirm"){return this.ConfirmButton;}
			else if (which =="clear"){return this.ClearButton;}
			else
				return null;
			}
			
			catch(Exception a){
			System.out.print("Zwrocono nulla. ERROR");
			return null;
			}
			
		}

		public TextField getTextField(String which){
			try{
			if(which == "start"){return this.DataStart;}
			else if (which =="end"){return this.DataEnd;}
			else if (which == "show"){return this.Show;}
			else if (which == "value"){return this.Waluta;}
				return null;
			}catch(Exception a){
				System.out.print("Zwrocono nulla. ERROR");
				return null;
			}
			
			}

}