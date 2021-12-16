/**
 * This is a superclass that manages all tower
 * Animatables put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

abstract public class Tower implements Animatable
{	
	// Fields.
	protected int x, y;
	
	/**
	 * Constructor that initializes Tower position.
	 * 
	 * @param x, y		Integers that represent the tower location in x, y coordinates.
	 * @return None.
	 */
	public Tower(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method that updates Tower objects.
	 * 
	 * @param timeElapsed	A double that represents time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// The update method will watch for enemies (in checkpoint #4) and attack them.
	}

	/**
	 * Method that draws Tower objects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub

	}

}
