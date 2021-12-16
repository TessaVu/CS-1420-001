/**
 * A GameControl object represents all of the logic and control needed to 
 * make the game operate. The control is responsible for setting up the 
 * animation timer, updating positions, dealing with user actions, etc.
 * 
 * There is exactly one GameControl object for the entire game. (That's
 * it's job - to control the game.)
 * 
 * Tessa Vu
 * Fall 2021
 */

package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameControl implements Runnable, ActionListener
{
	// Fields.
	GameView view;
	GameState state;
	
	/**
	 * Constructor -- Gets called from the 'main' thread. Since building a
	 * graphical user interface (GUI) has to happen in the GUI thread, no
	 * initialization is done here. (I moved all the code into the function
	 * named 'run' below, and it is called indirectly (invisibly) by the
	 * invokeAndWait function call in TowerDefense.main
	 */
    public GameControl()
    {
    	// Don't add initializations here -- put them in the run function below.
    }
    
    /**
     * Initializes the game and gets it 'running'. Note that this function should
     * only be called once on any GameControl object, and it must be called
     * from the GUI thread (not the main thread).
     */
    public void run()
    {    	
    	// Build the game state.
    	state = new GameState();
    	
    	// Build a view. Note that the view builds it's own frame, etc. All the work is there.
    	view = new GameView(state);
    	
    	// Add initial Animatable objects to the game.
    	state.addGameObject(new Backdrop());
//    	state.addGameObject(new BlueCircle(0, state));
    	
    	// Start the animation loop.
    	// Set up a repeating timer that triggers every 16 milliseconds.  When the
    	// timer goes off, the ActionPerformed method in 'this' is automatically
    	// called.
    	Timer t = new Timer(16, this); // The second parameter is the 'listening' object.
    	t.start(); // This is what makes the timer actually begin timing.
    }
    
    /**
     * Called whenever an action event happens, and we
     * are listening to that event. The timer automatically
     * sets 'this' up as the listener above.
     */
    public void actionPerformed(ActionEvent e)
    {
    	// Our animation 'loop' -- not an actual loop,
    	// but we recognize that this function gets called
    	// repeatedly.
    	// Randomly add blue circles.
//    	if(Math.random() < 0.03)
//    	{
//    		state.addGameObject(new BlueCircle(0, state));
//    	}
    	
    	// Randomly add snails.
    	if(Math.random() < 0.03)
    	{
    		state.addGameObject(new Snail(0, state));
    	}
    		
    	// Update the game objects.
    	state.updateAll();
    	
    	// Draw the game objects.
    	view.repaint();
    }
}
