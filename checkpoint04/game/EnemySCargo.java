/**
 * The SCargo enemy is a class from the
 * Enemy superclass that travels slower.
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
	private double speed = 0.03;
	
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
		position = position + speed * timeElapsed; // Increment position by 0.03.
		
		if (position > 1) // If position is greater than 1, restart the position. This loops the SCargo back to the beginning.
		{
			state.removeGameObject(this);
			state.changeLife(-3);
			state.changeScore(-300);
		}
	}
	
	/**
	 * This method updates the SCargo speed given a double.
	 * 
	 * @param speed		A double representing speed.
	 * @return None.
	 */
	public double changeSCargoSpeed(double speed)
	{
		return speed;
	}

	/**
	 * This method draws the SCargo and specifies the path to be taken.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Figure out where the SCargo should be drawn.
		Point p = this.getPosition();
    	
    	// Draw the snail.
    	v.drawCenteredImage(g, "SCargo.png", p.x, p.y, 0.15);
	}
}