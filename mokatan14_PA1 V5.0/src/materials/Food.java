package materials;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import materials.interfaces.*;

public class Food extends Material {
	private int x,y;  //coordinates of fruit
	private Image food_image;
	private int time;  	//1 sec is 10 time
	private int age;	//10 sec is 1 age
		
	
	
	public void grow(Graphics g) {
		
	}
	public void consumed() {
		
	}
	@Override
	public void draw() {
		
		
	}
	public void draw(Graphics g) {
		
	}	
		
	public void getNewLocation() {
		Random rand = new Random();
		int xr = rand.nextInt(10);
		int yr = rand.nextInt(10);
		
		setX(xr*50 + 1);
		setY(yr*50 + 1);
		
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
	public int getPlatformXPosition() {
		return 0;
		
	}
	

		
	public int getPlatformYPosition() {
		return 0;
		
	}
		
	@Override
	public void doAction(Graphics g, int walk) {
		// TODO Auto-generated method stub
		
	}
		

}
