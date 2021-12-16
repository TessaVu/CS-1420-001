/**
 * This is a class that produces a start screen for the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Splash extends JFrame
{
	GameState state;
	
	public Splash()
	{
		super("Snail Tower Defense");
		BufferedImage screen = ResourceLoader.getLoader().getImage("screen.jpg"); 
		
		JPanel panel = new JPanel();
		
		OverlayLayout overlay = new OverlayLayout(panel);
		panel.setLayout(overlay);
		ImageIcon image = new ImageIcon(screen);
		JLabel label = new JLabel(image);
		
		JButton start = new JButton("Start");
		panel.add(start);
		panel.add(label);
		
		start.addActionListener(e ->
		{
				setVisible(false);
				GameControl g = new GameControl();
				SwingUtilities.invokeLater(g);
		});
		
		getContentPane().add(panel);
	}
	
	public static void main(String[] args)
	{
		Splash sp = new Splash();
		sp.setSize(900, 600);
		sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sp.setVisible(true);
	}
}
