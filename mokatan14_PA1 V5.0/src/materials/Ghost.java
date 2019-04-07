package materials;

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

import materials.interfaces.movable;

public class Ghost extends Material implements  movable{
	private int x,y;
	private String direction;
	private Image Ghost_image;
	private String type;
	private int m,n;
	private int counter; //this is a counter for casper moves
	private int moveXorY; //this is a movement controller for casper
	
	
	
	public Ghost(String type) {
		//default position (151,51)
		setDirection("right");
		setCounter(0);
		setMoveXorY(0);
		setType(type);
		getNewLocation();
		
	}
	
	public  Image getGhost_image(String direction,int n) {
		URL path = getClass().getResource("/library/ghost_"+n+"_"+direction+".png");  //getDirectionFileName() returns "up.png", "down.png" etc
		try {
			 BufferedImage image = ImageIO.read(path);
			 Image srcImg = image;
			return srcImg;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), " Could not load Ghost Image!  "+n+"_"+direction," Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	/*
	 * source=
	 * https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
	 */
	public Image getScaledImage(Image srcImg, int w, int h){
		
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
		
		setX(xr*50 );
		setY(yr*50 );
		
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Image img() {
		int n = 1;
		if(getType().equalsIgnoreCase("Ash")) n = 1;
		if(getType().equalsIgnoreCase("Dolly")) n=2;
		if(getType().equalsIgnoreCase("Casper")) n=3;
		
		Image src = getScaledImage(getGhost_image(getDirection(),n), 50, 50);
		return src;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void doAction(Graphics g, int walk) {
		move(g,walk);
		
	}

	
	
	@Override
	public void move(Graphics g,int walk) {
		if(getM() == 0) {
			setM(walk);
		}
		if(getN() == 0) {
			setN(walk);
		}
		/*,
		 * ASH only moves horizontally
		 */
		if(getType().equalsIgnoreCase("ash")) {
			ash_move_H();
		}
		/*
		 * Dolly only moves vertically
		 */
		if(getType().equalsIgnoreCase("dolly")) {
			dolly_move_V();
		}
		
		//TAMAMLANMADI
		if(getType().equalsIgnoreCase("casper")) {
			casper_move();
		}
	}

	private void dolly_move_V() {
		if(getY() > 450) {
			setN(getN() *-1 );
		}
		if(getY() < 0) {
			setN(getN() *-1 );
		}
		setY(getY()+getN()); 
		
	}
	
	private void ash_move_H() {
		if(getX() > 450) {
			setM(getM() *-1 );
		}
		if(getX() < 0) {
			setM(getM() *-1 );
		}
		setX(getX()+getM()); 
	}
	
	private void casper_move() {

		if(getCounter() <9) {
			setCounter(getCounter()+1);
			switch(getMoveXorY()) {
			case 0:
				if(getY() >= 450) {
				setM(getM() *-1 );
				}
				if(getY() <= 0) {
				setM(getM() *-1 );
				}
				setY(getY()+getM());
			break;
			case 1:
				if(getX() > 445) {
					setN(getN() *-1 );
				}
				if(getX() < 0) {
					setN(getN() *-1 );
				}		
				setX(getX()+getN()); 
				break;
		}
			
		}else {
			Random rand = new Random();
			int number = rand.nextInt(2);
			setMoveXorY(number);
			
			
			
			switch(getMoveXorY()) {
				case 0:
					
					
					if(getY() > 450) {
					setM(getM() *-1 );
					}
					if(getY() < 0) {
					setM(getM() *-1 );
					}
					setY(getY()+getM());
					break;
				case 1:
					
					
					if(getX() > 450) {
						setN(getN() *-1);
					}
					if(getX() < 0) {
						setN(getN() *-1);
					}
					setX(getX()+getN()); 
					break;
			}
			setCounter(0);
		}

		
	}
	

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getMoveXorY() {
		return moveXorY;
	}

	public void setMoveXorY(int moveXorY) {
		this.moveXorY = moveXorY;
	}

	
	public int getPlatformXPosition() {
		int number =(int) getX() / super.precision;
		return number;
		
	}

	public int getPlatformYPosition() {
		int number =(int) getY() / super.precision;
		return number;
		
	}



	public void die() {
		if(Koc_Cat.score == 0) {
			Koc_Cat.score = Koc_Cat.score  - 1;
		}
		else {
			Koc_Cat.score = Koc_Cat.score * -1;
		}
		
	}






	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	


	
}
