/**
 * This is a superclass that manages all effects
 * Animatables put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

abstract public class Effect implements Animatable
{
	protected double age; // How long in seconds this object has existed.
	protected double x, y; // Draw location of the salt.
	protected double dx, dy; // Change of location.
	
	public Effect(Point origin, Point destination)
	{
		age = 0;
		x = origin.x;
		y = origin.y;
		dx = destination.x - origin.x;
		dy = destination.y - origin.y;
	}
	
	/**
	 * Method that updates the effects.
	 * 
	 * @param timeElapsed	A double representing time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// Empty.
	}

	/**
	 * Method that draws the effects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Empty.
	}
}
