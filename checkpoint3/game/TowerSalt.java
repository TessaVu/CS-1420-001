/**
 * This is a class that displays the salt tower
 * and fires salt at nearby enemies with a small
 * radius, but high damage.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class TowerSalt extends Tower
{
	// Fields.
	private GameState state;
	
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
	}
	
    /**
     * Method that updates the salt tower.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		// Fire salt at nearby enemies.
		
	}

    /**
     * Method that draws the salt tower.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g)
	{
		g.drawImage(ResourceLoader.getLoader().getImage("salt.png"), x, y, null);
	}
}
