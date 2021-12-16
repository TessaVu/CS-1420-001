/**
 * The Snail enemy is a class from the
 * Enemy superclass that travels fast.
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
	private double speed = 0.06;
	
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
		position = position + speed * timeElapsed; // Increment position by 0.06.
		
		if(position > 1) // If position is greater than 1, restart the position. This loops the snail back to the beginning.
		{
			state.removeGameObject(this);
			state.changeLife(-1);
			state.changeScore(-100);
		}
	}
	
	/**
	 * This method updates the Snail speed given a double.
	 * 
	 * @param speed		A double representing speed.
	 * @return None.
	 */
	public double changeSnailSpeed(double speed)
	{
		return speed;
	}

	/**
	 * This method draws the Snail and specifies the path to be taken.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Figure out where the snail should be drawn.
		Point p = this.getPosition();
    	
    	// Draw the snail.
    	v.drawCenteredImage(g, "snail.png", p.x, p.y, 1.0);
	}
}