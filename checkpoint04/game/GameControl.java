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
	long previousTime;
	long startingTime;
	long lastEnemy;
	double totalTime;
	double nextSnailTime, nextSCargoTime;
	long snailCount, SCargoCount;
	
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
    	state.addGameObject(new Menu(state));
    	
    	// Start the animation loop.
    	// Set up a repeating timer that triggers every 16 milliseconds.  When the
    	// timer goes off, the ActionPerformed method in 'this' is automatically
    	// called.
    	Timer t = new Timer(16, this); // The second parameter is the 'listening' object.
    	t.start(); // This is what makes the timer actually begin timing.
    	
    	// Keep track of the start time of the first tick.
    	previousTime = System.nanoTime();
    	
    	// Initialize generation parameters.
    	totalTime = 0.0;
    	snailCount = 0;
    	SCargoCount = 0;
    	nextSnailTime = 1.0;
    	nextSCargoTime = 4.0;
    }
    
    /**
     * Called whenever an action event happens, and we
     * are listening to that event. The timer automatically
     * sets 'this' up as the listener above.
     */
    public void actionPerformed(ActionEvent e)
    {
    	// Our animation 'loop' -- not an actual loop, but we
    	// recognize that this function gets called repeatedly.
    	// Calculate elapsed time since last update (tick).
    	long currentTime = System.nanoTime();
    	double elapsedTime = (currentTime - previousTime)/(1_000_000_000.0);
    	totalTime = totalTime + elapsedTime;
    	previousTime = currentTime;
    	
    	// Generate enemies.
    	generateEnemies(elapsedTime);
    	  	
    	// Update the game objects.
    	state.updateAll(elapsedTime);
    	
    	// Consume the mouse click if nothing else did.
    	state.consumeMouseClick();
    	
    	// Draw the game objects.
    	view.repaint();
    }
    
    public void generateEnemies(double elapsedTime)
    {
    	if(totalTime > nextSnailTime)
    	{
    		// Add snail.
    		state.addGameObject(new EnemySnail(0, state));
    		snailCount++;
    		
    		// Calculate next snail time.
    		nextSnailTime += 1.0;
    		
    		if(snailCount % 4 == 0) // Every four snails, pause for two seconds.
    			nextSnailTime += 3.0;
    	}
    	
    	if(totalTime > nextSCargoTime)
    	{
    		// Add SCargo.
    		state.addGameObject(new EnemySCargo(0, state));
    		SCargoCount++;
    		
    		// Calculate next SCargo time.
    		nextSCargoTime += 2.0;
    		
    		if(SCargoCount % 2 == 0) // Every two SCargos, pause for five seconds.
    			nextSCargoTime += 5.0;
    	}
    }
}
