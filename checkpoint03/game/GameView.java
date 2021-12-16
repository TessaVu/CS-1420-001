/**
 * A GameView object represents the graphical user interface to
 * our game. It contains the code for building the JFrame (the
 * game window) and setting up the JPanels and menus. It also
 * listens for events and sends them to the GameControl object
 * when they arrive.
 * 
 * There is exactly one GameView object for the entire game. (It's
 * purpose is to handle drawing and events.)
 * 
 * In checkpoint #1, functionality that belonged in GameState and 
 * GameControl was placed in GameView for convenience. We'll
 * separate most of this out in checkpoint #2.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView extends JPanel implements MouseListener, MouseMotionListener
{
	// This constant is needed to get rid of a warning. It won't matter to us. Ignore it.
	private static final long serialVersionUID = 1L;
	
	// Fields -- These variables will be part of the GameView object (that we make in GameControl).
	// These will be removed and moved into GameControl or GameState as appropriate.
	private GameState state;
	
	/**
	 * Our GameView constructor. The 'view' is the GUI (Graphical User Interface) and
	 * this constructor builds a JFrame (window) so the user can see our 'drawing'.
	 */
    public GameView(GameState state)
    {
    	// Fields.
    	this.state = state;

    	// Build the frame. The frame object represents the application 'window'.
    	JFrame frame = new JFrame("Tower Defense 2021");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Add a drawing area to the frame (a panel). Note that 'this' object IS the
    	// panel that we need, so we add it.
    	JPanel p = this;
    	frame.setContentPane(p);
    	
    	// Set the size of 'this' panel to match the size of the backdrop.
    	Dimension d = new Dimension(900, 600);
    	this.setMinimumSize(d);
    	this.setPreferredSize(d);
    	this.setMaximumSize(d);
    	
    	// Allow the JFrame to layout the window (by 'packing' it) and make it visible.
    	frame.pack();
    	frame.setVisible(true);
    	
    	// The mouseListener was not a required part of checkpoint #1. I've left the
    	// listening functionality in place as you will want it later.
    	this.addMouseListener(this); // Report mouse button events to this panel.
    	// Students will also want to listen to MouseMotion events.
    	this.addMouseMotionListener(this);
    }
    
    /**
     * Draws our game. This function will be called automatically when Java needs to
     * repaint our window. Use the repaint() function call (on this object) to cause
     * this function to be executed. (See the actionPerformed function below.)
     * 
     * @param Graphics g	The Graphics object to use for drawing.
     */
    public void paint(Graphics g)
    {
    	// Draw everything else.
    	state.drawAll(g);
    }
    
    /* The following methods are required for mouse events. I've collapsed some of them to
     * make it easier to see which one you need. Note that these are only called
     * if this object is 'listening' to some source of mouse events. See the constructor.
     */
	public void mousePressed(MouseEvent e) 
	{
		state.setMouseClicked();
	}
	
    public void mouseClicked(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }

	public void mouseDragged(MouseEvent e)
	{
		state.setMouseLocation(e.getX(), e.getY());
	}

	public void mouseMoved(MouseEvent e)
	{
		state.setMouseLocation(e.getX(), e.getY());
	}
}
