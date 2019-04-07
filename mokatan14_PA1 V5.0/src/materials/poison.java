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

public class poison extends Food  {
	private int x,y;
	private int time;
	private int age;
	private int[] xPoints = new int[4],yPoints = new int[4];
	private int a,b,c,d;
		
	public poison() {
		getNewLocation();
		setTime(1);
		
		
	}

	public void draw(Graphics g) {
		
		if(getAge() < 10) {
			g.setColor(Color.YELLOW);
			g.drawPolygon(getxPoints(), getyPoints(), 4);
			g.fillPolygon(getxPoints(), getyPoints(), 4);
		}
		else {	
			int number =10*2;
			 a = getY()+25 -number; 
			 b = getY()+25;
			 c = getY()+25 +number;
			 d = getY()+25;
			 int e = getX()+25;
			 int f = getX()+25 +number;
			 int ff = getX()+25;
			 int h = getX()+25 -number;
			 
			 int xp[] = new int[4];
			 int yp[] = new int[4];
			 yp[0] = a;  yp[1] = b; yp[2] = c;  yp[3] = d;
			 xp[0] = e;  xp[1] = f; xp[2] = ff; xp[3] = h;		
			g.setColor(Color.RED);
			g.drawPolygon(xp, yp, 4);
			g.fillPolygon(xp, yp, 4);
		}
	}	
	
	public void grow(Graphics g) {
		setTime(getTime()+1);
		draw(g);
	}
	
	public void consumed() {
		Koc_Cat.score = Koc_Cat.score - getAge()*10;
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

	public int[] getxPoints() {
		int number = getAge()*2;
		 a = getX()+25;
		 b = getX()+25 +number;
		 c = getX()+25;
		 d = getX()+25 -number;
		
		
		 xPoints[1] = a;
		 xPoints[2] = b;
		 xPoints[3] = c;
		 xPoints[0] = d;
		return xPoints;
	}

	public int[] getyPoints() {
		int number = getAge()*2;
		 a = getY()+25 -number; 
		 b = getY()+25;
		 c = getY()+25 +number;
		 d = getY()+25;
		
		
		 
		 
		 yPoints[1] = a;
		 yPoints[2] = b;
		 yPoints[3] = c;
		 yPoints[0] = d;
		 
		return yPoints;
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
