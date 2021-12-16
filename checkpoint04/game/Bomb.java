/**
 * This is a superclass that manages all bomb
 * Animatables put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

abstract public class Bomb implements Animatable
{	
	// Fields.
	protected int x, y;
	
	/**
	 * Constructor that initializes Bomb position.
	 * 
	 * @param x, y		Integers that represent the bomb location in x, y coordinates.
	 * @return None.
	 */
	public Bomb(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method that updates Bomb objects.
	 * 
	 * @param timeElapsed	A double that represents time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// Empty.
	}

	/**
	 * Method that draws Tower objects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Empty.
	}
}
