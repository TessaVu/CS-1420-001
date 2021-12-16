/**
 * The SCargo enemy is a class from the
 * Enemy superclass that travels slower
 * and explodes into three Snail enemies
 * when its health is depleted. Its health
 * as an SCargo is higher than the Snail.
 * 
 * Tessa Vu
 * Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

class EnemySCargo extends Enemy
{
	// Fields.
	private GameState state;
	
	/**
	 * Constructor that takes a double and initializes it in the body.
	 * 
	 * @param p, state		Double value for position and GameState.
	 * @return None.
	 */
	public EnemySCargo(double p, GameState state)
	{
		super(p);
		this.state = state;
	}
	
	/**
	 * This method updates the SCargo position given a double representing the time elapsed.
	 * 
	 * @param timeElapsed		A double representing time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		position = position + 0.06 * timeElapsed * 0.5; // Increment position by 0.5.
//		position = position + 0.5 * timeElapsed; // For check off.
		
		if (position > 1) // If position is greater than 1, restart the position. This loops the SCargo back to the beginning.
		{
			state.removeGameObject(this);
			state.changeLife(-3);
			state.changeScore(-300);
		}
	}

	/**
	 * This method draws the SCargo and specifies the path to be taken.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g)
	{
		// Figure out where the SCargo should be drawn.
    	Point p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position); // Specifies path points and gets the path's position.
    	
    	// Draw the snail.
    	g.drawImage(ResourceLoader.getLoader().getImage("SCargo.png"), p.x - 25, p.y - 20, 40, 40, null);
	}
}