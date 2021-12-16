/**
 * This is a superclass that manages all effects
 * Animatables put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

abstract public class Effect implements Animatable
{
	/**
	 * Method that updates the effects.
	 * 
	 * @param timeElapsed	A double representing time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Method that draws the effects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
	}
}
