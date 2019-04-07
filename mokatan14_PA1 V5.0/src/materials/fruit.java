package materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class fruit extends Food {
	private int x,y;  //coordinates of fruit
	private Image food_image;
	private int time;  	//1 sec is 10 time
	private int age;	//10 sec is 1 age
	private int counter; //counter for simulation
	
	public fruit() {
		getNewLocation();
		setTime(1);
		setAge(0);
		
	}
	
	public void draw(Graphics g) {
		if(getAge() == 11) {
			getNewLocation();
			setTime(0);
		}
		int int_number = getAge() *3 ;
		if(getAge() < 5) {
			g.setColor(Color.BLUE);
			g.drawOval(getX()+20, getY()+20,int_number, int_number);
			g.fillOval(getX()+20, getY()+20, int_number, int_number);
		}
		if(getAge() >= 5 && getAge() < 10) {
			g.setColor(Color.GREEN);
			g.drawOval(getX()+15, getY()+15, int_number, int_number);
			g.fillOval(getX()+15, getY()+15, int_number, int_number);
		}
		if(getAge() == 10) {
			g.setColor(Color.RED);
			g.drawOval(getX()+7, getY()+7, int_number, int_number);
			g.fillOval(getX()+7, getY()+7, int_number, int_number);
			
			
			
		}

	}	
	
	public void grow(Graphics g) {
		setTime(getTime()+1);
		draw(g);
	}
	
	public void consumed() {
		Koc_Cat.score = Koc_Cat.score + getAge()*5;
		getNewLocation();
		setTime(0);
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getAge() {
		int number =(int) getTime() /10;
		return number;
		
		
	}

	

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int getPlatformXPosition() {
		int number =(int) getX() / super.precision;
		return number;
		
	}


	@Override
	public int getPlatformYPosition() {
		int number =(int) getY() / super.precision;
		return number;
		
	}
	
	@Override
	public void doAction(Graphics g, int walk) {
		grow(g);
		
	}
	
}
