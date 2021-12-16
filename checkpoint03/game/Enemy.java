/**
 * This is a superclass that manages all enemy
 * Animatables put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Point;

abstract public class Enemy implements Animatable
{
	protected double position;
	
	/**
	 * Constructor that initializes Enemy position.
	 * 
	 * @param p		A double representing position.
	 * @return None.
	 */
	public Enemy(double p)
	{
		position = p;
	}
	
	/**
	 * Method that gets the position of the Enemy object.
	 * 
	 * @param None.
	 * @return Point	Point object that represents the Enemy position.
	 */
	public Point getPosition()
	{
		Point p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
		
		return p;
	}
}
