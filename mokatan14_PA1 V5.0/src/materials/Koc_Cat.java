package materials;

import materials.interfaces.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import materials.interfaces.movable;

public class Koc_Cat extends Material implements drawable{
	private static String direction;
	//private String listener_direction;
	
	private int x,y;
	private Image KocCat_image;
	public static int score = 0;
	
	
	
	public Koc_Cat() {
		//default position x:51, y:51
		setDirection("right");
		setX(250);
		setY(250);
		draw();
		
	
	}
	
	


	
	public void draw(int x, int y, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getKocCat_image("koccat", getDirection()), getX(), getY(), null);
       // g2d.drawRect(x, y, getWidth(), getHeight());
		
	}
	
	@Override
	public void doAction(Graphics g, int walk) {
		move(g,walk);
		
	}
	
	public void move(Graphics g, int walk) {
		if(getDirection().equalsIgnoreCase("up")) {
			if(getY() > 0) setY(getY()-walk);
			
		}
		if(getDirection().equalsIgnoreCase("down")) {
			if(getY() < 450) setY(getY()+walk);
			
		}
		if(getDirection().equalsIgnoreCase("right")) {
			if(getX() < 450) setX(getX()+walk);
			
		
		}
		if(getDirection().equalsIgnoreCase("left")) {
			if(getX() > 0)setX(getX()-walk);
		
		}
		
		
	}
	
	public  Image getKocCat_image(String type,String direction) {
		URL path = getClass().getResource("/library/"+type+"_"+direction+".png");  //getDirectionFileName() returns "up.png", "down.png" etc
		try {
			 BufferedImage image = ImageIO.read(path);
			 Image srcImg = image;
			return srcImg;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), " Could not load KocCat Image! %n  "+type+"_"+direction," Error", JOptionPane.ERROR_MESSAGE);
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
	
	private void getNewLocation() {
		Random rand = new Random();
		int xr = rand.nextInt(10);
		int yr = rand.nextInt(10);
		
		setX(xr*50 + 1);
		setY(yr*50 + 1);
		
		
	}
	
	public static String getDirection() {
		return direction;
	}

	public String getDirectionFileName() {
		return direction+".png";
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void draw() {
		Image src = getScaledImage(getKocCat_image("koccat", getDirection()), 49, 49);
		ImageIcon icon = new ImageIcon(src);
		
		this.setIcon(icon);
		
		
	}

	public Image img() {
		Image src = getScaledImage(getKocCat_image("koccat", getDirection()), 49, 49);
		
		return src;
	}

	public String score_toString() {
		String text = Integer.toString(score);
		return text;
	}
	


	
	
	private String getRandomDirection() {
		String text = "";
		Random rand = new Random();
		int num = rand.nextInt(4);
		
		if(num == 0) text = "up";
		if(num == 1) text = "down";
		if(num == 2) text = "left";
		if(num == 3) text = "right";
		
		
		return text;
	}

	public int getPlatformXPosition() {
		int number =(int) getX() / super.precision;
		return number;
		
	}


	
	public int getPlatformYPosition() {
		int number =(int) getY() / super.precision;
		return number;
		
	}




	




	


	



}
