/**
 * This class controls the pepper effect when an
 * enemy is fired at by a pepper tower, which
 * hits enemies and removes them from the map.
 * 
 * Tessa Vu
 * Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

class EffectPepper extends Effect
{
	// Fields.
	private GameState state;
	
	/**
	 * Constructor that initializes the superclass constructor
	 * and is made aware of the game state.
	 * 
	 * @param state, origin, destination	A GameState object and two Point objects respectively.
	 * @return None.
	 */
	public EffectPepper(GameState state, Point origin, Point destination)
	{
		super(origin, destination);
		this.state = state;
	}
	
	/**
	 * Updates pepper effects in the game, determining
	 * its life span and velocity.
	 * 
	 * @param timeElapsed	A double representing the time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		age += timeElapsed;
		if(age > 1.0) // If age is greater than 1 second...
		{
			state.removeGameObject(this); // Remove the effect.
			return;
		}
		
		// Determine velocity of the effect.
		x += dx * timeElapsed * 3;
		y += dy * timeElapsed * 3;
		
		// Find the nearest enemy.
		Point p = new Point((int)x, (int)y);
		Enemy e = state.findNearestEnemy(p);
		
		// If there is an enemy within distance and it is a snail...
		if(e != null && e.getPosition().distance(p) < 30 && e instanceof EnemySnail)
		{
			// Remove the snail and effect and change the score and credits.
			e = (EnemySnail)e;
			state.removeGameObject(e);
			state.removeGameObject(this);
			state.changeScore(100);
			state.changeCredits(100);
		}
		
		// If there is an enemy within distance and it is an SCargo...
		if(e != null && e.getPosition().distance(p) < 30 && e instanceof EnemySCargo)
		{
			// Remove the SCargo and effect and change the score and credits.
			e = (EnemySCargo)e;
			state.removeGameObject(e);
			state.removeGameObject(this);
			state.changeScore(300);
			state.changeCredits(300);
		}
	}

	/**
	 * Method that draws the pepper effect across the map.
	 * 
	 * @param g, v		A Graphics and GameView object respectively.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Draw the pepper.
    	v.drawCenteredImage(g, "pepper_crystals.png", (int)x, (int)y, 0.08);
	}
}