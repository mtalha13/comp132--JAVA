package Launcher;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Play.game_frame;
import Play.game_panel;


public class Launch_panel extends JPanel{
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	
	private JButton button;
	
	private static int amount_of_food_type;
	private static int amount_of_ghost_type;
	private static int amount_of_poison_type;
	
	public Launch_panel() {
		super(); 
		 setLayout(new FlowLayout()); // set frame layout 
		 textField1 = new JTextField("Number of fruits:                       ");
		 textField1.setEditable(false);
		 add(textField1);
		 textField2 = new JTextField(5);
		 add(textField2); 
		// ImageIcon ghost = new ImageIcon(getClass().getResource("ghost_pic.png"));
		 textField3 = new JTextField("Number of ghosts:                     ");
		 textField3.setEditable(false);
		 add(textField3);
		 textField4 = new JTextField(5);
		 add(textField4);
		 textField5 = new JTextField("Number of poisons:                   ");
		 textField5.setEditable(false);
		 add(textField5);
		 textField6  = new JTextField(5);
		 add(textField6);
		 
		 TextFieldHandler handler = new TextFieldHandler();
	     textField2.addActionListener(handler);
	     textField4.addActionListener(handler);
	     textField6.addActionListener(handler);

	     button = new JButton("Start Playing                       ");
	     button.setVerticalAlignment(SwingConstants.BOTTOM);
	     button.setHorizontalAlignment(SwingConstants.CENTER);
	     add(button);
	     button.setToolTipText("Click twice!");
	     button.addActionListener(handler);
	}
	
	private class TextFieldHandler implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent event) {			
	         try {
	        	 
	        	// user pressed Enter in JTextField textField1
		         if (event.getSource() == textField2) {
		        	 amount_of_food_type = Integer.parseInt(textField2.getText());
		        	 setAmount_of_food_type(amount_of_food_type);
		        	 if(getAmount_of_food_type() < 1) {
		        		 throw new Exception();
		        	 }
		         }
		           

		         // user pressed Enter in JTextField textField3
		         if (event.getSource() == textField4) {
		        	 amount_of_ghost_type = Integer.parseInt(textField4.getText()); 
		        	 setAmount_of_ghost_type(amount_of_ghost_type);
		        	 if(getAmount_of_food_type() < 1 || getAmount_of_ghost_type() < 1) {
		        		 throw new Exception();
		        	 }
		         }
		         
		         // user pressed Enter in JTextField textField5
		         if (event.getSource() == textField6) {
		        	 amount_of_poison_type = Integer.parseInt(textField4.getText()); 
		        	 setAmount_of_poison_type(amount_of_poison_type);
		        	 if(getAmount_of_food_type() < 1 || getAmount_of_ghost_type() < 1 || getAmount_of_poison_type() < 1) {
		        		 throw new Exception();
		        	 }
		         }
		         //start game 
		         else if(event.getSource() == button) {
		        	 //oyun test dosyasý buradan çaðýralacak
		        	if(getAmount_of_food_type() == 0 || getAmount_of_ghost_type() == 0 || getAmount_of_poison_type() == 0) {
		        		JOptionPane.showMessageDialog(button, "Press 'ENTER' after setting the value!");
		        	}else {
		        	 //JOptionPane.showMessageDialog(button, "HENUZ TAMAMLANMADI");
		        	
		        	//game launch information
		        	
		        		game_frame start = new game_frame("KOC CAT"
								  ,getAmount_of_food_type()
								  ,getAmount_of_ghost_type()
								  ,getAmount_of_poison_type()
								  ,800
								  ,600 			);
		        	}
		         }
	         }catch (Exception e) {
				// TODO: handle exception
	        	 JOptionPane.showMessageDialog(button, "Invalid Argument! "+e.getCause());
			}
			
		}

		
}
	
	
	public static int getAmount_of_food_type() {
		return amount_of_food_type;
	}

	public static int getAmount_of_ghost_type() {
		return amount_of_ghost_type;
	}

	public static int getAmount_of_poison_type() {
		return amount_of_poison_type;
	}
	
	public void setAmount_of_food_type(int amount_of_food_type) {
		this.amount_of_food_type = amount_of_food_type;
	}

	public void setAmount_of_ghost_type(int amount_of_ghost_type) {
		this.amount_of_ghost_type = amount_of_ghost_type;
	}
	
	public void setAmount_of_poison_type(int amount_of_poison_type) {
		this.amount_of_poison_type	 = amount_of_poison_type;
	}
}
