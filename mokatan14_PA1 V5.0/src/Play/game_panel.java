package Play;

import materials.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class game_panel  extends JPanel implements KeyListener{
	private int walk = 5;
	private Koc_Cat KocCat;
	private int time;
	private KeyEvent e;
	
	private Ghost g1;
	private Ghost g2;
	
	private Food f1;
	private Food f2;
	

	ArrayList<fruit> FL = new ArrayList<fruit>();
	ArrayList<poison> PL = new ArrayList<poison>();
	ArrayList<Ghost> GL = new ArrayList<Ghost>();
	String[] ghost_names = {"Ash","Dolly","Casper"};
	
	public game_panel() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		KocCat= new Koc_Cat();
		
		//add ghost
		
		for(int i = 0; i < game_frame.getAmount_of_ghost_type(); i++) {
			int g = i %3;
			Ghost element = new Ghost(ghost_names[g]);
			GL.add(element);
			
		}
		
		
		for(int i = 0; i < game_frame.getAmount_of_food_type(); i++) {
			fruit element = new fruit();
			FL.add(element);
			
		}
		
		
		for(int i = 0; i < game_frame.getAmount_of_poison_type(); i++) {
			poison element = new poison();
			PL.add(element);
			
		}		
	}
	
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		time +=1;
		//draw vertical borders
		for(int i = 1; i < 11;i++) {
			g.drawLine(i*50, 0, i*50, 500);
		}
		//draw horizontal borders
		for(int i = 1; i < 11;i++) {
			g.drawLine(0, i*50, 500, i*50);
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("SCORE", 600, 100);
		g.drawString(KocCat.score_toString(), 650, 150);
		
		for(fruit element : FL) {
			if(KocCat.getPlatformXPosition() == element.getPlatformXPosition() &&
					KocCat.getPlatformYPosition() == element.getPlatformYPosition()) {
				element.consumed();
			}
			element.doAction(g, walk);
		}
		for(poison element : PL) {
			if(KocCat.getPlatformXPosition() == element.getPlatformXPosition() &&
					KocCat.getPlatformYPosition() == element.getPlatformYPosition()) {
				element.consumed();
			}
			element.doAction(g, walk);
		}
		for(Ghost element : GL) {
			if(KocCat.getPlatformXPosition() == element.getPlatformXPosition() &&
					KocCat.getPlatformYPosition() == element.getPlatformYPosition()) {
				element.die();
			}
			g.drawImage(element.img(), element.getX(), element.getY(), null);
			element.doAction(g, walk);
		}
		
		g.drawImage(KocCat.img(), KocCat.getX(), KocCat.getY(), null);
		KocCat.move(g, walk);
		
		if(KocCat.score < 0) {
			g.drawImage(getScaledImage(img(), 250, 150), getWidth()/2-125, getHeight()/2-75, null);
		}
	}




	private Image img() {
		URL path = getClass().getResource("/library/GAMEOVER.JPG");  //getDirectionFileName() returns "up.png", "down.png" etc
		try {
			 BufferedImage image = ImageIO.read(path);
			 Image srcImg = image;
			return srcImg;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), " Could not load KocCat Image! %n"+"gameover"  ," Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	/*
	 * source=
	 * https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
	 */
	private Image getScaledImage(Image srcImg, int w, int h){
		
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		String text = KocCat.getDirection();
		
		if(e.getKeyCode() == KeyEvent.VK_UP) text = "up";
		if(e.getKeyCode() == KeyEvent.VK_DOWN) text = "down";
		if(e.getKeyCode() == KeyEvent.VK_LEFT) text = "left";
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) text = "right";
		
		KocCat.setDirection(text);
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
