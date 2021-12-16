/**
 * The Snail enemy is a class from the
 * Enemy superclass that travels faster
 * and disappears when its health is depleted.
 * Its health is short as it is a basic foe.
 * 
 * Tessa Vu
 * Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

class EnemySnail extends Enemy
{
	// Fields.
	private GameState state;
	
	/**
	 * Constructor that takes a double and initializes it in the body.
	 * 
	 * @param p, state		Double value for position and GameState.
	 * @return None.
	 */
	public EnemySnail(double p, GameState state)
	{
		super(p);
		this.state = state;
	}
	
	/**
	 * This method updates the Snail position given a double representing the time elapsed.
	 * 
	 * @param timeElapsed		A double representing time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		position = position + 0.06 * timeElapsed; // Increment position by 0.06.
//		position = position + 0.5 * timeElapsed; // For check off.
		
		if(position > 1) // If position is greater than 1, restart the position. This loops the snail back to the beginning.
		{
			state.removeGameObject(this);
			state.changeLife(-1);
			state.changeScore(-100);
		}
	}

	/**
	 * This method draws the Snail and specifies the path to be taken.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g)
	{
		// Figure out where the snail should be drawn.
    	Point p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position); // Specifies path points and gets the path's position.
    	
    	// Draw the snail.
    	g.drawImage(ResourceLoader.getLoader().getImage("snail.png"), p.x - 25, p.y - 20, null);
	}
}