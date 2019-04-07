package Play;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import Main.Game;
import materials.*;

public class game_frame extends JFrame {
	private String title;
	private static int amount_of_food_type;
	private static int amount_of_ghost_type;
	private static int amount_of_poison_type;
	private int width;
	private int height;
	private int time =0;
	
	private static int score_checker;
	
	game_panel myPanel = new game_panel();
	Timer timer;
	
	public game_frame() {
		//myPanel.setBackground(Color.blue);
		this.add(myPanel);
		score_checker = 0;
		
		 	 timer = new Timer(100,new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	           	   myPanel.repaint();
	           	 
	           	   if(Koc_Cat.score < 0) {

	           		   timer.stop();

	           		myPanel.repaint();
	           	   }
	             }
	         } );
	        
	        timer.start();
	        
				
	}
	
	public game_frame(String title, int amount_of_food_type, int amount_of_ghost_type,int amount_of_poison_type,int  width, int height){
		super();
		this.title = title;
		this.amount_of_food_type = amount_of_food_type;
		this.amount_of_ghost_type = amount_of_ghost_type;
		this.amount_of_poison_type = amount_of_poison_type;
		this.width = width;
		this.height = height;
		
		draw();
	}

	private void draw() {
		game_frame frame = new game_frame();
		frame.setTitle(title);
		frame.setSize(width,height);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)d.getWidth()/2-width/2,(int)d.getHeight()/2-height/2);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		
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
	
	
	
	
	
	
	
	
	
	
	
	

	}
	 
	
	
	

	

