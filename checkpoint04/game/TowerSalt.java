/**
 * This is a class that displays the salt tower
 * and fires salt at nearby enemies.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSalt extends Tower
{
	// Fields.
	private GameState state;
	private double timeSinceLastShot;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state, x, y		Takes in the GameState and x and y points.
     * @return None.
     */
	public TowerSalt(GameState state, int x, int y)
	{
		super(x, y);
		this.state = state;

		timeSinceLastShot = 0;
	}
	
    /**
     * Method that updates the salt tower.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		// See if enough time has elapsed to fire again.
		timeSinceLastShot += timeElapsed;
		
		// 1 second intervals.
		if(timeSinceLastShot < 1)
			return;
		
		// Find nearest enemy.
		Point towerPoint = new Point(x, y);
		Enemy e = state.findNearestEnemy(towerPoint);
		
		// Nothing to do.
		if(e == null)
			return;
		
		// Enemy is too far.
		if(towerPoint.distance(e.getPosition()) > 100)
			return;
		
		// Fire salt.
		EffectSalt s = new EffectSalt(state, towerPoint, e.getPosition());
		
		state.addGameObject(s);
		
		timeSinceLastShot = 0;
	}

    /**
     * Method that draws the salt tower.
     * 
     * @param g, v		A Graphics object and GameView object respectively.
     * @return None.
     */
	public void draw(Graphics g, GameView v)
	{
		v.drawCenteredImage(g, "salt.png", x, y, 1.2);
	}
}
