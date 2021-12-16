/**
 * A Backdrop object holds the background
 * for the game path to be drawn using the
 * ResourceLoader class.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class Backdrop implements Animatable
{
	/**
	 * This method updates the graphic as time elapses.
	 * 
	 * @param None.
	 */
	public void update(double timeElapsed)
	{
		// Empty.
	}

	/**
	 * This method draws the backdrop graphic using the ResourceLoader.
	 * 
	 * @param g		A graphics object.
	 */
	public void draw(Graphics g)
	{
		// Draw the backdrop.
    	g.drawImage(ResourceLoader.getLoader().getImage("path_2.jpg"), 0, 0, null);
	}
}
