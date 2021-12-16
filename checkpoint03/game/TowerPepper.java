/**
 * This is a class that displays the pepper tower
 * and fires pepper at nearby enemies with a large
 * radius, but low damage.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class TowerPepper extends Tower
{
	// Fields.
	private GameState state;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state, x, y		Takes in the GameState and x and y points.
     * @return None.
     */
	public TowerPepper(GameState state, int x, int y)
	{
		super(x, y);
		this.state = state;
	}
	
    /**
     * Method that updates the pepper tower.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		// Fire pepper at nearby enemies.
		
	}

    /**
     * Method that draws the pepper tower.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g)
	{
		g.drawImage(ResourceLoader.getLoader().getImage("pepper.png"), x, y, 50, 50, null);
	}
}
