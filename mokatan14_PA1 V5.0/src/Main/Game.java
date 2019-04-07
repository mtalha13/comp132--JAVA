package Main;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Launcher.Launch_panel;


public class Game extends JFrame {
	
	
	public Game() {
		Launch_panel launcher = new Launch_panel();
		add(launcher);
		
	}
	public static void main(String[] args) {
		Game frame = new Game();
		frame.setTitle("Launcher v5.0");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)d.getWidth()/2-200,(int)d.getHeight()/2-100);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setVisible(true);

	}
	
	
	
	

		
}

